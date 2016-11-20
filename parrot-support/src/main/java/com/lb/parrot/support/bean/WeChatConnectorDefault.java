package com.lb.parrot.support.bean;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.WeChatHttpUpload;
import com.lb.parrot.support.WeChatReceiver;
import com.lb.parrot.support.WeChatSender;
import com.lb.parrot.support.common.FromServerMessage;
import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.common.WeChatErrMsg;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.result.AccessToken;
import com.lb.parrot.support.result.ErrorResult;
import com.lb.parrot.support.result.JsApiSignature;
import com.lb.parrot.support.result.JsApiTicket;
import com.lb.parrot.support.result.Oauth2Token;
import com.lb.parrot.support.result.UserInfoResult;
import com.lb.parrot.support.url.GetAuthOauth2TokenUrl;
import com.lb.parrot.support.url.GetOauth2TokenUrl;
import com.lb.parrot.support.url.GetRefreshOauth2TokenUrl;
import com.lb.parrot.support.url.GetTicketUrl;
import com.lb.parrot.support.url.GetUserInfoHtmlUrl;
import com.lb.parrot.support.util.ParserUtil;
import com.lb.parrot.support.util.SignatureUtil;
import com.lb.parrot.support.util.StreamUtil;
import com.lb.parrot.support.util.StringUtil;

/**
 * <p>
 * 微信公众号业务对接种类：
 * 1、微信消息
 * 2、网页应用（获取用户信息）可由js接口
 * </p>
 * <p>
 * 微信公众号接口列表：
 * 1、get|获取access_token：https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
 * </p>
 * 微信公众号API控制器
 * @author lbhuanggua
 *
 */
@Service
public class WeChatConnectorDefault implements WeChatConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatConnectorDefault.class);
	
	@Autowired
	private WeChatClient weChatClient;
	
	@Autowired
	private WeChatReceiver weChatReceiver;
	
	@Autowired
	private WeChatSender weChatSender;
	/**
	 * access_token刷新时间
	 */
	private long connectionTime = 0;
	/**
	 * 全局唯一票据
	 * <p>access_token的存储至少要保留512个字符空间。access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效</p>
	 */
	private AccessToken accessToken;
	private JsApiTicket jsApiTicket;
	
	public WeChatReceiver getWeChatReceiver() {
		return weChatReceiver;
	}
	
	public void setWeChatReceiver(WeChatReceiver weChatReceiver) {
		this.weChatReceiver = weChatReceiver;
	}

	public WeChatSender getWeChatSender() {
		return weChatSender;
	}

	public void setWeChatSender(WeChatSender weChatSender) {
		this.weChatSender = weChatSender;
	}
	
	public WeChatClient getWeChatClient() {
		return weChatClient;
	}

	public void setWeChatClient(WeChatClient weChatClient) {
		this.weChatClient = weChatClient;
	}

	public long getConnectionTime() {
		return connectionTime;
	}

	public void setConnectionTime(long connectionTime) {
		this.connectionTime = connectionTime;
	}

	public AccessToken getAccessToken() {
		if (accessToken == null || (System.currentTimeMillis() - connectionTime) / 1000 > accessToken.getExpiresIn() + 60) {
			accessToken = getWeChatSender().connect(getWeChatClient());
			connectionTime = System.currentTimeMillis();
        }
		LOGGER.debug(accessToken.toString());
        return accessToken;
	}
	
	public JsApiTicket getJsApiTicket() {
		if (jsApiTicket == null || (System.currentTimeMillis() - connectionTime) / 1000 > jsApiTicket.getExpiresIn() + 60) {
			GetTicketUrl ticket = new GetTicketUrl(getAccessToken().getAccessToken());
			jsApiTicket = getWeChatSender().getJsApiTicket(ticket);
			//jsApiTicket依赖accessToken，因此共享connectionTime时间
		}
		LOGGER.debug(jsApiTicket.toString());
		return jsApiTicket;
	}

	public void send(ToServerUrl toUrl, WeChatContext context) throws WeChatSupportException{
		getWeChatSender().send(toUrl, context);
	}

	public void upload(WeChatHttpUpload upload) throws WeChatSupportException{
		getWeChatSender().upload(upload, wrapperUpload(upload));
	}

	public void receive(HttpServletRequest request, HttpServletResponse response) throws WeChatSupportException {
		LOGGER.debug("微信服务器推送处理开始");
		boolean checktag = getWeChatClient().isCheckSignature() ? checkSignature(request) : true;
		if(!checktag){
			if (getWeChatClient().isCheckSignature()) {
				LOGGER.error("微信请求接收服务器验证微信签名失败,URL参数:{},token:{}",request.getQueryString(), getWeChatClient().getToken());
				throw new WeChatSupportException("开发服务器验证微信签名失败");
			}
		}
		String method = request.getMethod();
		LOGGER.debug("微信提交第三方服务器方法[{}]", method);
		if ("get".equalsIgnoreCase(method)) {
			try {
				dealService(request, response);
			} catch (Exception e) {
				LOGGER.error("微信请求接收服务器处理异常：{}", e.getMessage(), e);
				throw new WeChatSupportException("响应公众号服务发生异常",e);
			}
		} else if ("post".equalsIgnoreCase(method)) {
			try {
				receiveMessage(request, response);
			} catch (Exception e) {
				LOGGER.error("微信请求接收服务器处理异常：{}", e.getMessage(), e);
				throw new WeChatSupportException("推送消息发生异常",e);
			}
		} else {
			throw new WeChatSupportException("不支持的HTTP请求：" + method);
		}
		LOGGER.debug("微信服务器推送处理结束");
	}
	
	/**
	 * 处理post消息
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void receiveMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.debug("<<<推送消息处理开始>>>");
		WeChatContext context = new WeChatContextDefault();
		String xml = StreamUtil.readText(request.getInputStream(), "UTF-8", false);
		LOGGER.debug("<<<URL参数:" + request.getQueryString() + ">>>");
		LOGGER.debug("<<<推送报文:" + xml + ">>>");
		//获得模式参数
		String encryptType = request.getParameter("encrypt_type");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String msgSignature = request.getParameter("msg_signature");
		//执行解密逻辑
		if("aes".equals(encryptType)){
			xml = SignatureUtil.decryptMessage(xml, timestamp, nonce, msgSignature, getWeChatClient());
			LOGGER.debug("<<<解密后报文:" + xml + ">>>");
		}
		FromServerMessage message = ParserUtil.parse(xml, ConvertMode.RECEIVE);
		LOGGER.debug("<<<解析后报文:" + xml + ">>>");
		context.setInput(message);
		getWeChatReceiver().receive(context);
		Object result = context.getOutput();
		if (result != null) {
			String source = result.toString();
			LOGGER.debug("原始返回报文:" + source);
			response.setCharacterEncoding("UTF-8");
			//执行加密逻辑
			if("aes".equals(encryptType)){
				source = SignatureUtil.encryptMessage(source, timestamp, nonce, getWeChatClient());
				LOGGER.debug("加密后返回报文:" + source);
			}
			response.getWriter().write(source);
		}else{
			LOGGER.debug("无返回报文");
		}
		LOGGER.debug("推送消息处理结束!");
	}
	
	 /**
	  * 响应微信服务器信息
	  * @param request
	  * @param response
	  * @throws Exception
	  */
	private void dealService(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String echostr = request.getParameter("echostr");
		LOGGER.error("<<<{echostr:"+echostr+"}>>>");
		if (StringUtil.isNotEmpty(echostr)) {
			response.getWriter().write(echostr);
		}else{
			response.getWriter().write("");
		}
	}

	private WeChatContext wrapperUpload(WeChatHttpUpload upload){
		WeChatContext context = new WeChatContextDefault();
		context.setInput(upload);
		//context.put(ACCESS_TOKEN, getAccessToken().getAccessToken());
		return context;
	}
	
    /**
     * 验证签名(符合微信规范)
     * @param request
     * @param response
     * @throws IOException 
     */
	private boolean checkSignature(HttpServletRequest request) throws WeChatSupportException{
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String signature = request.getParameter("signature");
		LOGGER.debug("timestamp={0},nonce={1},signature={2},验证签名处理开始...", timestamp, nonce, signature);
		boolean checktag = false;
		// 计算签名
		String result = SignatureUtil.createSignature(getWeChatClient().getToken(), timestamp, nonce);
		if (StringUtil.isNotEmpty(result) && StringUtil.isNotEmpty(signature) && result.equals(signature)) {
			checktag = true;
		}
		// 增加输出日志
		LOGGER.debug("token={0},checktag={1},验证签名处理结束!", getWeChatClient().getToken(), checktag);
		return checktag;
	}
	
	public UserInfoResult getUserInfo(HttpServletRequest request) throws WeChatSupportException{
		UserInfoResult result = null;
		try{
			String code = request.getParameter("code");
			String state = request.getParameter("state");
			LOGGER.debug("接收微信推送参数，code = {}, state = {}" , code , state);
			if(StringUtil.isEmpty(code)){
				throw new WeChatSupportException("100", "参数code异常");
			}
			//第二步：通过code换取网页授权access_token
			GetOauth2TokenUrl getOauth2TokenUrl = new GetOauth2TokenUrl(getWeChatClient().getAppid(), getWeChatClient().getSecret(), code);
			WeChatContext oauth2TokenContext = new WeChatContextDefault();
			this.send(getOauth2TokenUrl, oauth2TokenContext);
			Oauth2Token oauth2Token = JSON.parseObject((String)oauth2TokenContext.getOutput(), Oauth2Token.class);
			LOGGER.debug("通过code换取网页授权Oauth2Token = {}", oauth2Token.toString());
			if(!StringUtil.isEmpty(oauth2Token.getErrCode())){
				throw new WeChatSupportException(oauth2Token.getErrCode(), oauth2Token.getErrMsg());
			}else {
				//LOGGER.debug("网页授权access_token 校验前, openid={}, accessToken={}", oauth2Token.getOpenId(), oauth2Token.getAccessToken());
				//附：检验授权凭证（access_token）是否有效
				GetAuthOauth2TokenUrl getAuthOauth2TokenUrl = new GetAuthOauth2TokenUrl(oauth2Token.getAccessToken(), oauth2Token.getOpenId());
				WeChatContext authOauth2TokenContext = new WeChatContextDefault();
				this.send(getAuthOauth2TokenUrl, authOauth2TokenContext);
				ErrorResult errorResult = JSON.parseObject((String)authOauth2TokenContext.getOutput(), ErrorResult.class);
				LOGGER.debug("检验授权凭证（access_token）是否有效,errcode={}, errmsg={}", errorResult.getErrCode(), errorResult.getErrMsg());
				//第三步：刷新access_token（如果需要）
				if(!errorResult.getErrCode().equalsIgnoreCase("0")){
					GetRefreshOauth2TokenUrl getRefreshOauth2TokenUrl = new GetRefreshOauth2TokenUrl(getWeChatClient().getAppid(), oauth2Token.getRefreshToken());
					WeChatContext refreshOauth2Token = new WeChatContextDefault();
					this.send(getRefreshOauth2TokenUrl, refreshOauth2Token);
					oauth2Token = JSON.parseObject((String)refreshOauth2Token.getOutput(), Oauth2Token.class);
					LOGGER.debug("刷新Oauth2Token = {}", oauth2Token.toString());
				}
				//LOGGER.debug("网页授权access_token 校验后, openid={},accessToken={}", oauth2Token.getOpenId(), oauth2Token.getAccessToken());
				//第四步：拉取用户信息(需scope为 snsapi_userinfo)
				GetUserInfoHtmlUrl getUserInfoUrl = new GetUserInfoHtmlUrl(oauth2Token.getAccessToken(),oauth2Token.getOpenId());
				WeChatContext userInfoContext = new WeChatContextDefault();
				this.send(getUserInfoUrl, userInfoContext);
				LOGGER.debug("拉取用户信息  = {}", userInfoContext.getOutput());
				result = JSON.parseObject((String)userInfoContext.getOutput(), UserInfoResult.class);
				LOGGER.debug("解析用户信息  = {}", result);
				if(!StringUtil.isEmpty(oauth2Token.getErrCode())){
					throw new WeChatSupportException(oauth2Token.getErrCode(), oauth2Token.getErrMsg());
				}
			}
		}catch(WeChatSupportException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			throw e;
		}
		return result;
	}

	public JsApiSignature getJsApiSignature(String appId, String url) throws WeChatSupportException {
		JsApiTicket jsApiTicket = this.getJsApiTicket();
		long timestamp = System.currentTimeMillis() / 1000;
		String nonceStr = SignatureUtil.getRandomStr();
		String signature = SignatureUtil.createJsApiSignature(nonceStr, jsApiTicket.getTicket(), timestamp + "", url);
		return new JsApiSignature(appId, timestamp, nonceStr, signature, url);
	}
	
}