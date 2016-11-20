package com.lb.parrot.pay.message;

import com.lb.parrot.pay.common.AbstactPaySignature;
import com.lb.parrot.support.common.ToServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class GetRedPackInfoMessage extends AbstactPaySignature implements
		ToServerMessage {
	private static final long serialVersionUID = 1L;
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
	 * 商户订单号
	 */
	@XStreamAlias("mch_billno")
	private String mchBillno;
	/**
	 * 商户号
	 */
	@XStreamAlias("mch_id")
	private String mchId;
	/**
	 * 公众账号appid
	 */
	@XStreamAlias("appid")
	private String appid;
	/**
	 * 订单类型:MCHT:通过商户订单号获取红包信息。
	 */
	@XStreamAlias("bill_type")
	private String billType;

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getMchBillno() {
		return mchBillno;
	}

	public void setMchBillno(String mchBillno) {
		this.mchBillno = mchBillno;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

}
