package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;

/**
 * 获取微信服务器IP地址
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
 *
 */
public class GetIpsUrl extends AbstractToServerUrl implements ToServerUrl{

	public GetIpsUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "getcallbackip";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=#getcallbackip.accessToken#";
	}

	public String getMethod() {
		return "get";
	}

}
