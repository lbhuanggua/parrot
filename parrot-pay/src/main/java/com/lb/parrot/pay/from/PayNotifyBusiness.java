package com.lb.parrot.pay.from;

import com.lb.parrot.pay.from.pojo.PayNotifyReturn;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class PayNotifyBusiness extends PayNotifyReturn {

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
	 * 商户子账号
	 */
	@XStreamAlias("sub_mch_id")
	private String subMchId;
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
	 * 错误代码
	 */
	@XStreamAlias("err_code")
	private String errorCode;
	/**
	 * 错误代码描述
	 */
	@XStreamAlias("err_code_des")
	private String errorCodeDes;
	/**
	 * 用户标识
	 */
	@XStreamAlias("openid")
	private String openId;
	/**
	 * 是否关注公众账号
	 */
	@XStreamAlias("is_subscribe")
	private String isSubscribe;
	/**
	 * 交易类型
	 */
	@XStreamAlias("trade_type")
	private String tradeType;
	/**
	 * 付款银行
	 */
	@XStreamAlias("bank_type")
	private String bankType;
	/**
	 * 订单金额
	 */
	@XStreamAlias("total_fee")
	private Integer totalFee;
	/**
	 * 应结订单金额
	 */
	@XStreamAlias("settlement_total_fee")
	private Integer settlementTotalFee;
	/**
	 * 货币种类
	 */
	@XStreamAlias("fee_type")
	private String feeType;
	/**
	 * 现金支付金额
	 */
	@XStreamAlias("cash_fee")
	private Integer cashFee;
	/**
	 * 现金支付货币类型
	 */
	@XStreamAlias("cash_fee_type")
	private String cashFeeType;
	/**
	 * 代金券金额
	 */
	@XStreamAlias("coupon_fee")
	private Integer couponFee;
	/**
	 * 代金券使用数量
	 */
	@XStreamAlias("coupon_count")
	private Integer couponCount;
	/**
	 * 微信支付订单号
	 */
	@XStreamAlias("transaction_id")
	private String transactionId;
	/**
	 * 商户订单号
	 */
	@XStreamAlias("out_trade_no")
	private String outTradeNo;
	/**
	 * 商家数据包
	 */
	@XStreamAlias("attach")
	private String attach;
	/**
	 * 支付完成时间
	 */
	@XStreamAlias("time_end")
	private String timeEnd;

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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getSettlementTotalFee() {
		return settlementTotalFee;
	}

	public void setSettlementTotalFee(Integer settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public Integer getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Integer couponFee) {
		this.couponFee = couponFee;
	}

	public Integer getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
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

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	
	
	
}
