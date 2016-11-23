package com.lb.parrot.message.result;

import com.lb.parrot.support.common.FromServerResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 通用回复消息<br>
 * 微信消息有三种模式：非加密、加密、兼容，兼容模式会同时包含前两者内容。
 *
 */
public class CommonReplyMessage implements FromServerResult{
	
	@XStreamAlias("ToUserName")
	private String toUserName;

	@XStreamAlias("FromUserName")
	private String fromUserName;
	
	@XStreamAlias("CreateTime")
	private int createTime;
	
	@XStreamAlias("MsgType")
	private String msgType;
	
	@XStreamAlias("Encrypt")
	private String encrypt;
	
	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	
}
