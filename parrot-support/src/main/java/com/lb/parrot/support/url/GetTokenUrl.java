package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;

/**
 * 获取公众号的全局唯一票据access_token
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
 *
 */
public class GetTokenUrl extends AbstractToServerUrl implements ToServerUrl {
	/**
	 * 公众号的唯一标识
	 */
	private String appid;
	/**
	 * 公众号的appsecret
	 */
	private String secret;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getKey() {
		return "token";
	}

	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=#token.appid#&secret=#token.secret#";
	}

	public String getMethod() {
		return "get";
	}

}
