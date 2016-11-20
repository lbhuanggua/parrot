package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;

/**
 * 附：检验授权凭证（access_token）是否有效
 * https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID
 */
public class GetAuthOauth2TokenUrl extends AbstractToServerUrl implements
		ToServerUrl {
	
	/**
	 * 用户的唯一标识
	 */
	public String openid;

	public GetAuthOauth2TokenUrl(String accessToken, String openid) {
		super.setAccessToken(accessToken);
		this.openid = openid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getKey() {
		return "auth_access_token";
	}

	public String getUrl() {
		return "https://api.weixin.qq.com/sns/auth?access_token=#auth_access_token.accessToken#&openid=#auth_access_token.openid#";
	}

	public String getMethod() {
		return "get";
	}

}
