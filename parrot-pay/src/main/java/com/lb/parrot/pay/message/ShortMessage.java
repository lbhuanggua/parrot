package com.lb.parrot.pay.message;

import com.lb.parrot.pay.common.AbstactPaySignature;
import com.lb.parrot.support.common.ToServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ShortMessage extends AbstactPaySignature implements ToServerMessage {
	
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
	 * URL链接
	 */
	@XStreamAlias("long_url")
	private String longUrl;

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
	 * 签名类型
	 */
	@XStreamAlias("sign_type")
	private String signType;

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

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}
	
}
