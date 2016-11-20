package com.lb.parrot.support.url;

/**
 * 
* <p>Title: 发送到微信服务器的消息抽象类</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public abstract class AbstractToServerUrl {
	
	/**
	 * 全局统一票据
	 */
	public String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public boolean isCert() {
		return false;
	}
}
