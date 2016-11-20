package com.lb.parrot.pay.result.red;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("hbinfo")
public class RedPackHB {
	/**
	 * 领取红包的Openid
	 */
	@XStreamAlias("openid")
	private String openId;
	/**
	 * 红包金额，单位为分
	 */
	@XStreamAlias("amount")
	private int amount;
	/**
	 * 领取红包时间
	 */
	@XStreamAlias("rcv_time")
	private String rcvTime;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRcvTime() {
		return rcvTime;
	}

	public void setRcvTime(String rcvTime) {
		this.rcvTime = rcvTime;
	}

}
