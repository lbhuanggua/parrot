package com.lb.parrot.customer.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

/**
 * 1、添加客服帐号 POST消息体
 * 2、设置客服信息 POST消息体
 *
 */
public class KfaccountMessage implements ToServerMessage {
	private static final long serialVersionUID = 1L;
	public KfaccountMessage(String kfAccount, String nickname) {
		super();
		this.kfAccount = kfAccount;
		this.nickname = nickname;
	}

	public KfaccountMessage(String kfAccount, String nickname, String password) {
		super();
		this.kfAccount = kfAccount;
		this.nickname = nickname;
		this.password = password;
	}

	/**
	 * 完整客服帐号，格式为：帐号前缀@公众号微信号，帐号前缀最多10个字符，必须是英文、数字字符或者下划线，后缀为公众号微信号，长度不超过30个字符
	 */
	@JSONField(name = "kf_account")
	private String kfAccount;
	/**
	 * 客服昵称，最长16个字
	 */
	@JSONField(name = "nickname")
	private String nickname;

	@JSONField(name = "password")
	private String password;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
