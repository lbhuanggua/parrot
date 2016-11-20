package com.lb.parrot.customer.result;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 在线客服信息
 *
 */
public class KfaccountOnline {

	/**
	 * 完整客服帐号，格式为：帐号前缀@公众号微信号
	 */
	@JSONField(name = "kf_account")
	private String account;

	/**
	 * 客服在线状态，目前为：1、web 在线
	 */
	@JSONField(name = "status")
	private String status;

	/**
	 * 客服编号
	 */
	@JSONField(name = "kf_id")
	private String id;

	/**
	 * 客服当前正在接待的会话数
	 */
	@JSONField(name = "accepted_case")
	private String acceptedCase;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAcceptedCase() {
		return acceptedCase;
	}

	public void setAcceptedCase(String acceptedCase) {
		this.acceptedCase = acceptedCase;
	}

	@Override
	public String toString() {
		return "KfAccountOnline [account=" + account + ", status=" + status
				+ ", id=" + id + ", acceptedCase=" + acceptedCase + "]";
	}

}
