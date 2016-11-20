package com.lb.parrot.support.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

public class Oauth2Token extends AbstractToServerResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	/**
	 * 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 */
	@JSONField(name = "access_token")
	String accessToken;
	/**
	 * access_token接口调用凭证超时时间，单位（秒）
	 */
	@JSONField(name = "expires_in")
	long expiresIn;
	/**
	 * 用户刷新access_token
	 */
	@JSONField(name = "refresh_token")
	String refreshToken;
	/**
	 * 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
	 */
	@JSONField(name = "openid")
	String openId;
	/**
	 * 用户授权的作用域，使用逗号（,）分隔
	 */
	@JSONField(name = "scope")
	String scope;

	@JSONField(name = "unionid")
	String unionId;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	@Override
	public String toString() {
		return "Oauth2Token [accessToken=" + accessToken + ", expiresIn="
				+ expiresIn + ", refreshToken=" + refreshToken + ", openId="
				+ openId + ", scope=" + scope + ", unionId=" + unionId + "]";
	}
	
	
	
}
