package com.lb.parrot.pay.result.transfer;

import com.lb.parrot.pay.result.pojo.TransfersBusinessResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class TransferResult extends TransfersBusinessResult{

	private static final long serialVersionUID = 1L;
	/**
	 * 商户订单号
	 */
	@XStreamAlias("partner_trade_no")
	private String partnerTradeNo;
	/**
	 * 微信订单号
	 */
	@XStreamAlias("payment_no")
	private String paymentNo;
	/**
	 * 微信支付成功时间
	 */
	@XStreamAlias("payment_time")
	private String paymentTime;

	public String getPartnerTradeNo() {
		return partnerTradeNo;
	}

	public void setPartnerTradeNo(String partnerTradeNo) {
		this.partnerTradeNo = partnerTradeNo;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}

}
