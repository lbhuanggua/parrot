package com.lb.parrot.apiproxy.pay.model;

import java.io.Serializable;

public class WeChatRefundModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 设备号
	 */
	private String deviceInfo;

	/**
	 * 微信订单号
	 */
	private String transactionId;

	/**
	 * 商户订单号
	 */
	private String outTradeNo;

	/**
	 * 商户退款单号
	 */
	private String outRefundNo;

	/**
	 * 订单金额
	 */
	private String totalFee;

	/**
	 * 退款金额
	 */
	private String refundFee;

	/**
	 * 货币种类
	 */
	private String refundFeeType;

	/**
	 * 操作员
	 */
	private String opUserId;

	/**
	 * 退款资金来源
	 */
	private String refundAccount;

	public WeChatRefundModel(String deviceInfo, String transactionId,
			String outTradeNo, String outRefundNo, String totalFee,
			String refundFee, String opUserId) {
		super();
		this.deviceInfo = deviceInfo;
		this.transactionId = transactionId;
		this.outTradeNo = outTradeNo;
		this.outRefundNo = outRefundNo;
		this.totalFee = totalFee;
		this.refundFee = refundFee;
		this.opUserId = opUserId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
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

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(String refundFee) {
		this.refundFee = refundFee;
	}

	public String getRefundFeeType() {
		return refundFeeType;
	}

	public void setRefundFeeType(String refundFeeType) {
		this.refundFeeType = refundFeeType;
	}

	public String getOpUserId() {
		return opUserId;
	}

	public void setOpUserId(String opUserId) {
		this.opUserId = opUserId;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}

	@Override
	public String toString() {
		return "RefundModel [deviceInfo=" + deviceInfo + ", transactionId="
				+ transactionId + ", outTradeNo=" + outTradeNo
				+ ", outRefundNo=" + outRefundNo + ", totalFee=" + totalFee
				+ ", refundFee=" + refundFee + ", refundFeeType="
				+ refundFeeType + ", opUserId=" + opUserId + ", refundAccount="
				+ refundAccount + "]";
	}

}
