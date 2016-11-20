package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 关闭会话
 * http请求方式: POST
 * https://api.weixin.qq.com/customservice/kfsession/close?access_token=ACCESS_TOKEN
 */
public class CloseSessionUrl extends AbstractToServerUrl implements ToServerUrl{

	public CloseSessionUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "close";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/customservice/kfsession/close?access_token=#close.accessToken#";
	}

	public String getMethod() {
		return "post";
	}


}
