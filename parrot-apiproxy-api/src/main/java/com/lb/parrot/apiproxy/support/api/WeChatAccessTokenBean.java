package com.lb.parrot.apiproxy.support.api;

import com.lb.parrot.support.result.AccessToken;
import com.lb.parrot.support.result.JsApiSignature;
import com.lb.parrot.support.result.JsApiTicket;

public interface WeChatAccessTokenBean {
	
	/**
	 * 获取全局唯一接口调用凭据
	 * @return
	 */
	AccessToken getAccessToken();
	/**
	 * 获取JS API的临时票据
	 * @return
	 */
	JsApiTicket getJsApiTicket();
	/**
	 * JS API签名验证
	 * @param url
	 * @return
	 */
	JsApiSignature getJsApiSignature(String url);
	
}
