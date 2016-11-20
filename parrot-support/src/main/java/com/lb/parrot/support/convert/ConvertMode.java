package com.lb.parrot.support.convert;

/**
 * 
* <p>Title: 微信报文转换器的类型</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public enum ConvertMode {

	/**
     * 处理发送微信服务器的回复报文
     */
	SEND,
	/**
	 * 处理微信服务器的推送报文
	 */
	RECEIVE,
	/**
	 * 同时包含两种
	 */
	ALL
}
