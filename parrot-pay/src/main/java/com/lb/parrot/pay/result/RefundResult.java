package com.lb.parrot.pay.result;

import com.lb.parrot.pay.result.pojo.PayBusinessResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class RefundResult extends PayBusinessResult{

	private static final long serialVersionUID = 1L;

	/**
	 * 商户订单号
	 */
	@XStreamAlias("out_trade_no")
	private String outTradeNo;

	/**
	 * 微信订单号
	 */
	@XStreamAlias("transaction_id")
	private String transactionId;

	/**
	 * 商户退款单号
	 */
	@XStreamAlias("out_refund_no")
	private String outRefundNo;

	/**
	 * 微信退款号
	 */
	@XStreamAlias("refund_id")
	private String refundId;

	/**
	 * 退款渠道
	 */
	@XStreamAlias("refund_channel")
	private String refundChannel;

	/**
	 * 申请退款金额，单位为分
	 */
	@XStreamAlias("refund_fee")
	private int refundFee;

	/**
	 * 退款金额，单位为分 (去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额)
	 */
	@XStreamAlias("settlement_refund_fee")
	private int settlementRefundFee;

	/**
	 * 总金额，单位为分
	 */
	@XStreamAlias("total_fee")
	private int totalFee;

	/**
	 * 应结订单金额，单位为分
	 */
	@XStreamAlias("settlement_total_fee")
	private int settlementTotalFee;

	/**
	 * 应结订单金额，单位为分
	 */
	@XStreamAlias("fee_type")
	private String feeType;

	/**
	 * 现金支付金额
	 */
	@XStreamAlias("cash_fee")
	private int cashFee;

	/**
	 * 现金退款金额
	 */
	@XStreamAlias("cash_refund_fee")
	private int cashRefundFee;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
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

	public String getRefundChannel() {
		return refundChannel;
	}

	public void setRefundChannel(String refundChannel) {
		this.refundChannel = refundChannel;
	}

	public int getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(int refundFee) {
		this.refundFee = refundFee;
	}

	public int getSettlementRefundFee() {
		return settlementRefundFee;
	}

	public void setSettlementRefundFee(int settlementRefundFee) {
		this.settlementRefundFee = settlementRefundFee;
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

	public int getCashRefundFee() {
		return cashRefundFee;
	}

	public void setCashRefundFee(int cashRefundFee) {
		this.cashRefundFee = cashRefundFee;
	}

}
