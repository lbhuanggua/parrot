package com.lb.parrot.support.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lb.parrot.support.WeChatHttp;
import com.lb.parrot.support.WeChatHttpUpload;
import com.lb.parrot.support.common.WeChatCert;
import com.lb.parrot.support.util.IOUtils;


/**
 * 
* <p>Title: 通信类</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
@Service
public class WeChatHttpDefault implements WeChatHttp {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatHttpDefault.class);

	private Map<String, String> headerMap = new HashMap<String, String>();
	private CloseableHttpClient client;
	
	private String responseCharset = "UTF-8";
    private String requestCharset = "UTF-8";
    
    private int timeout = 5000;

	public WeChatHttpDefault() {
		init();
	}
	
	protected void init(){
		headerMap.put("Accept", "text/html, application/xhtml+xml, */*");
		headerMap.put("Accept-Language", "zh-CN,en-US;q=0.5");
		headerMap.put("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
		headerMap.put("Accept-Encoding", "gzip, deflate");
		headerMap.put("Connection", "Keep-Alive");
		//headerMap.put("Accept", "text/html, application/xhtml+xml, */*");
		//headerMap.put("Accept-Language", "zh-CN,en-US;q=0.5");
		//headerMap.put("User-Agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36");
		//headerMap.put("Accept-Encoding", "gzip, deflate");
		//headerMap.put("Connection", "Keep-Alive");
		client = HttpClients.createDefault();
		
	}
    
	
	public String getUrl(String url) {
		HttpGet httpRequest = new HttpGet(url);
		try{
			for (Entry<String, String> entry : headerMap.entrySet()) {
				httpRequest.addHeader(entry.getKey(), entry.getValue());
			}
			return execute(client, httpRequest);
		}finally{
			httpRequest.releaseConnection();
		}
		
	}
	
	public String postUrl(String url, String content, WeChatCert cert) {
		if (cert == null) {
			return postUrl(url, content, client);
		} else {
			CloseableHttpClient certClient = getCertHttpClient(cert);
			return postUrl(url, content, certClient);
		}
	}
	
	public String postUrl(String url, String content) {
		return postUrl(url, content, client);
	}
	
	/**
	 * 获得绑定证书的CloseableHttpClient
	 * @param cert
	 * @return
	 */
	private CloseableHttpClient getCertHttpClient(WeChatCert cert){
		try{
			KeyStore keyStore  = KeyStore.getInstance(cert.getCertType());
			FileInputStream instream = new FileInputStream(new File(cert.getCertPath()));
			char[] password = cert.getPassword().toCharArray();
			
			try {
				keyStore.load(instream, password);
			} finally {
				instream.close();
			}

	        KeyManagerFactory factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	        factory.init(keyStore, password);
	        
	        // Trust own CA and all self-signed certs
	        SSLContext sslcontext = SSLContext.getInstance("TLS");
	        sslcontext.init(factory.getKeyManagers(), null, null);
	        
	        // Allow TLSv1 protocol only
	        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
	        CloseableHttpClient httpclient = HttpClients.custom()
	                .setSSLSocketFactory(sslsf)
	                .build();

			return httpclient;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	private String postUrl(String url, String content, CloseableHttpClient client){
		HttpPost httpRequest = new HttpPost(url);
		HttpEntity entity = new StringEntity(content, requestCharset);
		httpRequest.setEntity(entity);
		try{
			for (Entry<String, String> entry : headerMap.entrySet()) {
				httpRequest.addHeader(entry.getKey(), entry.getValue());
			}
			return execute(client, httpRequest);
		}finally{
			httpRequest.releaseConnection();
		}
	}
	
	private String execute(CloseableHttpClient client,HttpRequestBase httpRequest) throws RuntimeException{
		CloseableHttpResponse  response = null;
		try {
			response = client.execute(httpRequest);
	        int status = response.getStatusLine().getStatusCode();
			if (status == HttpStatus.SC_OK) {
	        	LOGGER.debug("HTTP请求结果成功返回");
	        	InputStream stream = response.getEntity().getContent();
	        	return IOUtils.readFromInputStream(stream, responseCharset);
	        }else{
	        	LOGGER.debug("结果返回失败，原因：{}", response.getStatusLine().toString());
	            throw new RuntimeException(response.getStatusLine().toString());
	        }
		} catch (Exception e) {
			LOGGER.debug("结果返回失败，原因：{}", e.getMessage());
			throw new RuntimeException(e);
		} finally{
			HttpClientUtils.closeQuietly(response);
		}
	}

	
	public String upload(String url, WeChatHttpUpload upload) {
		HttpPost httpRequest = new HttpPost(url);
		
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		
		//设置表单报文
		if (upload.getFormName() != null) {
			builder.addTextBody(upload.getFormName(), upload.getContent());
		}
		
		//设置文件流
		//builder.addPart(upload.getFileName(),new InputStreamBody(upload.getFile().getInputStream(),upload.getFile().getFileName()));
		
		//生成HttpEntity实体
		HttpEntity entity = builder.build();
		
		httpRequest.setEntity(entity);
		try{
			for (Entry<String, String> entry : headerMap.entrySet()) {
				httpRequest.addHeader(entry.getKey(), entry.getValue());
			}
			return execute(client,httpRequest);
		}finally{
			httpRequest.releaseConnection();
		}
	}
	
	
	public String getResponseCharset() {
		return responseCharset;
	}

	public void setResponseCharset(String responseCharset) {
		this.responseCharset = responseCharset;
	}

	public String getRequestCharset() {
		return requestCharset;
	}

	public void setRequestCharset(String requestCharset) {
		this.requestCharset = requestCharset;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
