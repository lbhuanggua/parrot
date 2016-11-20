package com.lb.parrot.apiproxy.pay.model;

import java.io.Serializable;

public class WeChatRefundQueryModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 设备号
	 */
	private String deviceInfo;

	/**
	 * 微信订单号，优先使用
	 */
	private String transactionId;

	/**
	 * 商品订单号
	 */
	private String outTradeNo;

	/**
	 * 商户退款单号
	 */
	private String outRefundNo;

	/**
	 * 微信退款单号
	 */
	private String refundId;

	public WeChatRefundQueryModel(String outRefundNo) {
		super();
		this.outRefundNo = outRefundNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	@Override
	public String toString() {
		return "RefundQueryModel [deviceInfo=" + deviceInfo
				+ ", transactionId=" + transactionId + ", outTradeNo="
				+ outTradeNo + ", outRefundNo=" + outRefundNo + ", refundId="
				+ refundId + "]";
	}

}
