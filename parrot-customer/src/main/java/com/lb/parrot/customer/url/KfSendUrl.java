package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;



/**
 * 客服接口-发消息
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN
 *
 */
public class KfSendUrl extends AbstractToServerUrl implements ToServerUrl{

	public KfSendUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "send";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=#send.accessToken#";
	}

	public String getMethod() {
		return "post";
	}


}
