package com.lb.parrot.pay.message;

import com.lb.parrot.pay.common.AbstactPaySignature;
import com.lb.parrot.support.common.ToServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class DownLoadBillMessage extends AbstactPaySignature implements ToServerMessage {
	
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
	 * 签名类型
	 */
	@XStreamAlias("sign_type")
	private String signType;
	/**
	 * 对账单日期 	下载对账单的日期，格式：20140603
	 */
	@XStreamAlias("bill_date")
	private String billDate;
	/**
	 * 账单类型 :
		ALL，返回当日所有订单信息，默认值
		SUCCESS，返回当日成功支付的订单
		REFUND，返回当日退款订单
	 */
	@XStreamAlias("bill_type")
	private String billType;
	/**
	 * 压缩账单:非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
	 */
	@XStreamAlias("tar_type")
	private String tarType;
	
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

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getTarType() {
		return tarType;
	}

	public void setTarType(String tarType) {
		this.tarType = tarType;
	}
	
	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

}
