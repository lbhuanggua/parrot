package com.lb.parrot.message.from;

import com.lb.parrot.support.common.FromServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 通用消息<br>
 * 微信消息有三种模式：非加密、加密、兼容，兼容模式会同时包含前两者内容。
 *
 */
public class CommonMessage implements FromServerMessage{

	@XStreamAlias("FromUserName")
	private String fromUserName;
	
	@XStreamAlias("MsgType")
	private String msgType;
	
	@XStreamAlias("CreateTime")
	private int createTime;
	
	@XStreamAlias("MsgId")
	private long msgId;
	
	@XStreamAlias("Encrypt")
	private String encrypt;
	
	@XStreamAlias("ToUserName")
	private String toUserName;
	
	@XStreamAlias("URL")
	private String url;

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
	
	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
