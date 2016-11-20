package com.lb.parrot.pay.message;

import com.lb.parrot.pay.common.AbstactPaySignature;
import com.lb.parrot.support.common.ToServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class GetTransferInfoMessage extends AbstactPaySignature implements ToServerMessage {
	
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
	@XStreamAlias("partner_trade_no")
	private String partnerTradeNo;
	/**
	 * 商户号
	 */
	@XStreamAlias("mch_id")
	private String mchId;
	/**
	 * 公众账号ID
	 */
	@XStreamAlias("appid")
	private String appId;
	
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

	public String getPartnerTradeNo() {
		return partnerTradeNo;
	}

	public void setPartnerTradeNo(String partnerTradeNo) {
		this.partnerTradeNo = partnerTradeNo;
	}

	@Override
	public String getSignature() {
		return signature;
	}

	@Override
	public void setSignature(String signature) {
		this.signature = signature;
	}

}
