package com.lb.parrot.support.common;

/**
 * 
* <p>Title: 发送到微信服务器的通信对象</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public interface ToServerUrl {
	/**
	 * 获取微信通讯的URL键值
	 * @return
	 */
	String getKey();
	/**
	 * 获取微信通讯的URL
	 * @return
	 */
	String getUrl();
	/**
	 * 获取微信通讯的URL的method
	 * @return
	 */
	String getMethod();
	/**
	 * 是否需要证书
	 * @return
	 */
	boolean isCert();
	/**
	 * 设置票据
	 * @param accessToken
	 */
	void setAccessToken(String accessToken);
}
