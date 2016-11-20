package com.lb.parrot.support.result;


public class JsApiSignature {

	/**
	 * 公众号的唯一标识
	 */
	private String appId;
	/**
	 * 生成签名的时间戳
	 */
	private long timestamp;
	/**
	 * 生成签名的随机串
	 */
	private String nonceStr;
	/**
	 * 签名
	 */
	private String signature;

	private String url;

	public JsApiSignature(){
		super();
	}
	
	public JsApiSignature(String appId, long timestamp, String nonceStr,
			String signature, String url) {
		super();
		this.appId = appId;
		this.timestamp = timestamp;
		this.nonceStr = nonceStr;
		this.signature = signature;
		this.url = url;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "JsApiSignature [appId=" + appId + ", timestamp=" + timestamp
				+ ", nonceStr=" + nonceStr + ", signature=" + signature
				+ ", url=" + url + "]";
	}

}
