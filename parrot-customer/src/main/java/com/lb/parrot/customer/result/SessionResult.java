package com.lb.parrot.customer.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

/**
 * 1、获取客户会话状态返回体
 *
 */
public class SessionResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	/**
	 * 完整客服账号，格式为：账号前缀@公众号微信号
	 */
	@JSONField(name = "kf_account")
	private String account;

	/**
	 * 会话接入的时间
	 */
	@JSONField(name = "createtime")
	private long createtime;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "KfaccountSessionResult [account=" + account + ", createtime="
				+ createtime + "]";
	}

}
