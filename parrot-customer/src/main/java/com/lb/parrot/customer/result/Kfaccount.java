package com.lb.parrot.customer.result;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 消息服务中提供的客服信息
 *
 */
public class Kfaccount {

	/**
	 * 完整客服账号，格式为：账号前缀@公众号微信号
	 */
	@JSONField(name = "kf_account")
	private String account;

	/**
	 * 客服工号
	 */
	@JSONField(name = "kf_id")
	private String id;

	/**
	 * 客服昵称
	 */
	@JSONField(name = "kf_nick")
	private String nick;

	/**
	 * 客服头像URL
	 */
	@JSONField(name = "kf_headimgurl")
	private String headimgurl;

	/**
	 * 如果客服帐号已绑定了客服人员微信号
	 */
	@JSONField(name = "kf_wx")
	private String wx;

	/**
	 * 如果客服帐号尚未绑定微信号，但是已经发起了一个绑定邀请，则此处显示绑定邀请的微信号
	 */
	@JSONField(name = "invite_wx")
	private String inviteWx;
	/**
	 * 如果客服帐号尚未绑定微信号，但是已经发起过一个绑定邀请，邀请的过期时间，为unix 时间戳
	 */
	@JSONField(name = "invite_expire_time")
	private String inviteExpireTime;
	/**
	 * 邀请的状态，有等待确认“waiting”，被拒绝“rejected”，过期“expired”
	 */
	@JSONField(name = "invite_status")
	private String inviteStatus;

	public String getInviteWx() {
		return inviteWx;
	}

	public void setInviteWx(String inviteWx) {
		this.inviteWx = inviteWx;
	}

	public String getInviteExpireTime() {
		return inviteExpireTime;
	}

	public void setInviteExpireTime(String inviteExpireTime) {
		this.inviteExpireTime = inviteExpireTime;
	}

	public String getInviteStatus() {
		return inviteStatus;
	}

	public void setInviteStatus(String inviteStatus) {
		this.inviteStatus = inviteStatus;
	}

	public String getWx() {
		return wx;
	}

	public void setWx(String wx) {
		this.wx = wx;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

}
