package com.lb.parrot.customer.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

public class KfaccountSessionMessage implements ToServerMessage {
	private static final long serialVersionUID = 1L;
	public KfaccountSessionMessage(String kfAccount, String openid) {
		super();
		this.kfAccount = kfAccount;
		this.openid = openid;
	}

	/**
	 * 完整客服帐号，格式为：帐号前缀@公众号微信号
	 */
	@JSONField(name = "kf_account")
	private String kfAccount;
	/**
	 * 粉丝的openid
	 */
	@JSONField(name = "openid")
	private String openid;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
