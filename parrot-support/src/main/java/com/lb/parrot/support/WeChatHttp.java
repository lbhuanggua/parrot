package com.lb.parrot.support;

import com.lb.parrot.support.common.WeChatCert;

/**
 * 微信HTTP操作接口
 */
public interface WeChatHttp {
	
	 /**
     * 用get方式访问微信URL
     *
     * @param 要访问的微信URL
     * @return 请求结果
     */
    String getUrl(String url);
    
    /**
     * 用post方式访问微信URL
     *
     * @param 要访问的微信URL
     * @param content
     * @param cert
     * @return 请求结果
     */
	String postUrl(String url, String content, WeChatCert cert);
	
    /**
     * 用post方式访问微信URL
     *
     * @param 要访问的微信URL
     * @param content
     * @return 请求结果
     */
	String postUrl(String url, String content);
	
    /**
     * 上传文件
     * @param url
     * @param upload
     * @return
     */
    String upload(String url, WeChatHttpUpload upload);
}
