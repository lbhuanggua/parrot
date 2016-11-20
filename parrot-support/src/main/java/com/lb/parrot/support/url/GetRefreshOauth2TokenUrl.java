package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;

/**
 * 第三步：刷新access_token（如果需要）
 * 由于access_token拥有较短的有效期，当access_token超时后，可以使用refresh_token进行刷新，refresh_token有效期为30天，当refresh_token失效之后，需要用户重新授权。
 * https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN 
 */
public class GetRefreshOauth2TokenUrl extends AbstractToServerUrl implements ToServerUrl{
	/**
	 * 	公众号的唯一标识
	 */
	private String appid;
	/**
	 * 填写通过access_token获取到的refresh_token参数  
	 */
	private String refreshToken;

	public GetRefreshOauth2TokenUrl(String appid, String refreshToken) {
		super();
		this.appid = appid;
		this.refreshToken = refreshToken;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getKey() {
		return "refresh_token";
	}

	public String getUrl() {
		return "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=#refresh_token.appid#&grant_type=refresh_token&refresh_token=#refresh_token.refreshToken#";
	}

	public String getMethod() {
		return "get";
	}


}
