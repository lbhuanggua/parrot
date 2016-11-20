package com.lb.parrot.support.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

public class AccessToken extends AbstractToServerResult implements ToServerResult {

	private static final long serialVersionUID = 1L;
	
	@JSONField(name = "access_token")
	private String accessToken;

	@JSONField(name = "expires_in")
	private long expiresIn;

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

	@Override
	public String toString() {
		return "AccessToken [accessToken=" + accessToken + ", expiresIn="
				+ expiresIn + "]";
	}

}
