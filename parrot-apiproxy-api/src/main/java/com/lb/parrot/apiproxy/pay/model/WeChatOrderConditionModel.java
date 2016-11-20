package com.lb.parrot.apiproxy.pay.model;

import java.io.Serializable;

public class WeChatOrderConditionModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 微信订单号，优先使用
	 */
	private String transactionId;

	/**
	 * 商品订单号
	 */
	private String outTradeNo;
	
	public WeChatOrderConditionModel(String outTradeNo) {
		super();
		this.outTradeNo = outTradeNo;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "OrderQueryModel [transactionId=" + transactionId
				+ ", outTradeNo=" + outTradeNo + "]";
	}

}
