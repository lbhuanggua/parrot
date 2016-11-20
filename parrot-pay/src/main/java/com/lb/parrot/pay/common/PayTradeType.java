package com.lb.parrot.pay.common;

/**
 * 
* <p>Title: 微信支付交易类型枚举</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public enum PayTradeType {
	/**
	 * JSAPI--公众号支付
	 */
	JSAPI, 
	/**
	 * NATIVE--原生扫码支付
	 */
	NATIVE, 
	/**
	 * APP--app支付
	 */
	APP,
	/**
	 * MICROPAY--刷卡支付
	 */
	MICROPAY

}