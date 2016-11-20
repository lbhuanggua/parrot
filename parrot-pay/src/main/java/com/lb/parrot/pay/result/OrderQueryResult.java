package com.lb.parrot.pay.result;

import com.lb.parrot.pay.result.pojo.PayBusinessResult;
import com.lb.parrot.pay.result.pojo.ToServerPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
* <p>Title: 查询订单结果模型</p>
* <p>Description: return_code 和result_code都为SUCCESS的时候有返回</p>
* @author lbhuanggua
* @date 2016年05月20日
 */
@XStreamAlias("xml")
public class OrderQueryResult extends PayBusinessResult implements ToServerPayResult{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 设备号
	 */
	@XStreamAlias("device_info")
	private String deviceInfo;
	
	/**
	 * 用户标识
	 */
	@XStreamAlias("openid")
	private String openId;
	
	/**
	 * 是否关注
	 */
	@XStreamAlias("is_subscribe")
	private String isSubscribe;
	
	/**
	 * 交易类型
	 */
	@XStreamAlias("trade_type")
	private String tradeType;
	
	/**
	 * 交易状态
	 */
	@XStreamAlias("trade_state")
	private String tradeState;
	
	/**
	 * 付款银行类型
	 */
	@XStreamAlias("bank_type")
	private String bankType;
	
	/**
	 * 总金额，单位为分
	 */
	@XStreamAlias("total_fee")
	private int totalFee;
	
	/**
	 * 应结订单金额
	 */
	@XStreamAlias("settlement_total_fee")
	private int settlementTotalFee;
	
	/**
	 * 货币类型
	 */
	@XStreamAlias("fee_type")
	private String feeType;
	
	/**
	 * 现金支付金额
	 */
	@XStreamAlias("cash_fee")
	private int cashFee;
	
	/**
	 * 现金支付货币类型
	 */
	@XStreamAlias("cash_fee_type")
	private String cashFeeType;
	
	/**
	 * 代金券金额
	 */
	@XStreamAlias("coupon_fee")
	private int couponFee;
	
	/**
	 * 代金券使用数量
	 */
	@XStreamAlias("coupon_count")
	private int couponCount;
	
	/**
	 * 代金券类型
	 */
	//@XStreamAlias("coupon_type_$n")
	//private String coupon_type_$n;
	
	/**
	 * 代金券ID
	 */
	//@XStreamAlias("coupon_id_$n")
	//private String coupon_id_$n;
	
	/**
	 * 单个代金券支付金额
	 */
	//@XStreamAlias("coupon_fee_$n")
	//private String coupon_fee_$n;
	
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
	 * 附加数据
	 */
	@XStreamAlias("attach")
	private String attach;
	
	/**
	 * 支付完成时间，格式为yyyyMMddHHmmss
	 */
	@XStreamAlias("time_end")
	private String timeEnd;
	
	/**
	 * 交易状态描述
	 */
	@XStreamAlias("trade_state_desc")
	private String tradeStateDesc;

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
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

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public int getSettlementTotalFee() {
		return settlementTotalFee;
	}

	public void setSettlementTotalFee(int settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public int getCashFee() {
		return cashFee;
	}

	public void setCashFee(int cashFee) {
		this.cashFee = cashFee;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public int getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(int couponFee) {
		this.couponFee = couponFee;
	}

	public int getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(int couponCount) {
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

	public String getTradeStateDesc() {
		return tradeStateDesc;
	}

	public void setTradeStateDesc(String tradeStateDesc) {
		this.tradeStateDesc = tradeStateDesc;
	}
	
}
