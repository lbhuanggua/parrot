package com.lb.parrot.pay.result.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class PayBusinessResult extends PayReturnResult {

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
	 * 业务代码
	 */
	@XStreamAlias("result_code")
	private String resultCode;
	
	/**
	 * 业务结果描述
	 */
	@XStreamAlias("result_msg")
	private String result_msg;

	/**
	 * 错误代码
	 */
	@XStreamAlias("err_code")
	private String errorCode;
	
	/**
	 * 错误代码描述
	 */
	@XStreamAlias("err_code_des")
	private String errorCodeDes;

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

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrorCodeDes() {
		return errorCodeDes;
	}

	public void setErrorCodeDes(String errorCodeDes) {
		this.errorCodeDes = errorCodeDes;
	}
	
}
