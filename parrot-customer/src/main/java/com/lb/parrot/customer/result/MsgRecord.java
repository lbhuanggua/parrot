package com.lb.parrot.customer.result;

import com.alibaba.fastjson.annotation.JSONField;

public class MsgRecord {
	/**
	 * 完整客服帐号，格式为：帐号前缀@公众号微信号
	 */
	@JSONField(name = "worker")
	private String worker;
	/**
	 * 用户标识
	 */
	@JSONField(name = "openid")
	private String openid;
	/**
	 * 操作码，2002（客服发送信息），2003（客服接收消息）
	 */
	@JSONField(name = "opercode")
	private int opercode;
	/**
	 * 聊天记录
	 */
	@JSONField(name = "text")
	private String text;
	/**
	 * 操作时间，unix时间戳
	 */
	@JSONField(name = "time")
	private long time;

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getOpercode() {
		return opercode;
	}

	public void setOpercode(int opercode) {
		this.opercode = opercode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "MsgRecord [worker=" + worker + ", openid=" + openid
				+ ", opercode=" + opercode + ", text=" + text + ", time="
				+ time + "]";
	}

}
