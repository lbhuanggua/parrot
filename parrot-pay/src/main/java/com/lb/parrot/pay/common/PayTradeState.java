package com.lb.parrot.pay.common;

/**
 * 
* <p>Title: 微信支付交易状态枚举</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public enum PayTradeState {
	/**
	 * SUCCESS—支付成功
	 */
	SUCCESS, 
	/**
	 * REFUND—转入退款
	 */
	REFUND, 
	/**
	 * NOTPAY—未支付
	 */
	NOTPAY,
	/**
	 * CLOSED—已关闭
	 */
	CLOSED,
	/**
	 * REVOKED—已撤销（刷卡支付）
	 */
	REVOKED,
	/**
	 * USERPAYING--用户支付中
	 */
	USERPAYING,
	/**
	 * PAYERROR--支付失败(其他原因，如银行返回失败)
	 */
	PAYERROR
}
