package com.lb.parrot.pay.message;

import com.lb.parrot.pay.common.AbstactPaySignature;
import com.lb.parrot.support.common.ToServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RefundQueryMessage extends AbstactPaySignature implements
		ToServerMessage {
	private static final long serialVersionUID = 1L;
	/**
	 * 公众账号ID
	 */
	@XStreamAlias("appid")
	private String appId;

	/**
	 * 商户号
	 */
	@XStreamAlias("mch_id")
	private String mchId;

	/**
	 * 设备号
	 */
	@XStreamAlias("device_info")
	private String deviceInfo;

	/**
	 * 随机字符串
	 */
	@XStreamAlias("nonce_str")
	private String nonceStr;

	/**
	 * 签名
	 */
	@XStreamAlias("sign")
	private String signature;

	/**
	 * 微信订单号
	 */
	@XStreamAlias("transaction_id")
	private String transactionId;
	/**
	 * 商户订单号
	 */
	@XStreamAlias("out_trade_no")
	private String outTradeNo;
	/**
	 * 商户退款单号
	 */
	@XStreamAlias("out_refund_no")
	private String outRefundNo;
	/**
	 * 微信退款单号
	 */
	@XStreamAlias("refund_id")
	private String refundId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
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

}
