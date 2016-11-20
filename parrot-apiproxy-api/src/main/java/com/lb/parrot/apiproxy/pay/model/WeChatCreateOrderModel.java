package com.lb.parrot.apiproxy.pay.model;

import java.io.Serializable;


public class WeChatCreateOrderModel implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 设备号
	 */
	private String deviceInfo;

	/**
	 * 商品简要描述，限制32个字符
	 */
	private String body;

	/**
	 * 商品详细描述，限制8192个字符
	 */
	private String detail;

	/**
	 * 附加数据
	 */
	private String attach;

	/**
	 * 商品订单号
	 */
	private String outTradeNo;

	/**
	 * 货币类型
	 */
	private String feeType;

	/**
	 * 总金额，单位为分
	 */
	private int totalFee;

	/**
	 * 终端IP
	 */
	private String spbillCreateIp;

	/**
	 * 订单生成时间，格式为yyyyMMddHHmmss
	 */
	private String timeStart;

	/**
	 * 订单失效时间，格式为yyyyMMddHHmmss
	 */
	private String timeExpire;

	/**
	 * 商品标记
	 */
	private String goodsTag;

	/**
	 * 回调URL地址
	 */
	private String notifyUrl;

	/**
	 * 交易类型
	 */
	private String tradeType;

	/**
	 * 商品Id
	 */
	private String productId;

	/**
	 * 限定支付方式
	 */
	private String limitPay;

	/**
	 * 微信用户id
	 */
	private String openId;

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLimitPay() {
		return limitPay;
	}

	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Override
	public String toString() {
		return "CreateOrderModel [deviceInfo=" + deviceInfo + ", body=" + body
				+ ", detail=" + detail + ", attach=" + attach + ", outTradeNo="
				+ outTradeNo + ", feeType=" + feeType + ", totalFee="
				+ totalFee + ", spbillCreateIp=" + spbillCreateIp
				+ ", timeStart=" + timeStart + ", timeExpire=" + timeExpire
				+ ", goodsTag=" + goodsTag + ", notifyUrl=" + notifyUrl
				+ ", tradeType=" + tradeType + ", productId=" + productId
				+ ", limitPay=" + limitPay + ", openId=" + openId + "]";
	}

	

}
