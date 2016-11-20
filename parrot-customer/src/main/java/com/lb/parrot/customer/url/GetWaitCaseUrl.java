package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 获取未接入会话列表
 * 微信请求地址：https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token=ACCESS_TOKEN
 *
 */
public class GetWaitCaseUrl extends AbstractToServerUrl implements
		ToServerUrl {

	public GetWaitCaseUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "getwaitcase";
	}

	public String getUrl() {
		return "http://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token=#getwaitcase.accessToken#";
	}

	public String getMethod() {
		return "get";
	}

}
