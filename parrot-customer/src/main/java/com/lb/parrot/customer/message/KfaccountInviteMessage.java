package com.lb.parrot.customer.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

/**
 * 邀请绑定客服帐号POST消息体
 *
 */
public class KfaccountInviteMessage implements ToServerMessage {
	private static final long serialVersionUID = 1L;
	/**
	 * 完整客服帐号，格式为：帐号前缀@公众号微信号
	 */
	@JSONField(name = "kf_account")
	private String kfAccount;
	/**
	 * 接收绑定邀请的客服微信号
	 */
	@JSONField(name = "invite_wx")
	private String invitewx;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	public String getInvitewx() {
		return invitewx;
	}

	public void setInvitewx(String invitewx) {
		this.invitewx = invitewx;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
