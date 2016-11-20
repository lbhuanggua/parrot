package com.lb.parrot.pay.common;

/**
 * 
* <p>Title: 账单类型</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public enum BillType {
	
	/**
     * 返回当日所有订单信息，默认值
     */
	ALL,
	/**
	 * 返回当日成功支付的订单
	 */
	SUCCESS,
	/**
	 * 返回当日退款订单
	 */
	REFUND

	
}