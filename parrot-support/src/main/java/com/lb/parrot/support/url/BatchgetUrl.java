package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 批量获取用户基本信息
 * 开发者可通过该接口来批量获取用户基本信息。最多支持一次拉取100条。
 * https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN
 */
public class BatchgetUrl extends AbstractToServerUrl implements ToServerUrl {
	
	public BatchgetUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "batchget";
	}

	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=#batchget.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
