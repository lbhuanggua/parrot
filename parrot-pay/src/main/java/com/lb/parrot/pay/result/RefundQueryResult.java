package com.lb.parrot.pay.result;

import com.lb.parrot.pay.result.pojo.PayBusinessResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class RefundQueryResult extends PayBusinessResult {

	private static final long serialVersionUID = 1L;
	/**
	 * 微信订单号
	 */
	@XStreamAlias("transaction_id")
	private String transactionId;
	/**
	 * 商户订单号
	 */
	@XStreamAlias("out_trade_no")
	private String outTradeNo;
	/**
	 * 订单金额
	 */
	@XStreamAlias("total_fee")
	private int totalFee;
	/**
	 * 应结订单金额，单位为分
	 */
	@XStreamAlias("settlement_total_fee")
	private int settlementTotalFee;
	/**
	 * 货币种类
	 */
	@XStreamAlias("fee_type")
	private String feeType;
	/**
	 * 现金支付金额
	 */
	@XStreamAlias("cash_fee")
	private int cashFee;
	/**
	 * 退款笔数
	 */
	@XStreamAlias("refund_count")
	private int refundCount;
	/**
	 * 退款资金来源
	 */
	@XStreamAlias("refund_account")
	private int refundAccount;

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

	public int getRefundCount() {
		return refundCount;
	}

	public void setRefundCount(int refundCount) {
		this.refundCount = refundCount;
	}

	public int getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(int refundAccount) {
		this.refundAccount = refundAccount;
	}

}
