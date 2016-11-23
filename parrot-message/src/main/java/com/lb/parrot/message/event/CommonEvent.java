package com.lb.parrot.message.event;

import com.lb.parrot.support.common.FromServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
* <p>Title:  微信服务器推送事件</p>
* <p>Description:  微信服务器推送事件</p>
* @author lbhuanggua
* @date 2016年10月17日
 */
public class CommonEvent implements FromServerMessage{

	public CommonEvent(){
		setMsgType("event");
	}
	
	@XStreamAlias("FromUserName")
	private String fromUserName;
	
	@XStreamAlias("MsgType")
	private String msgType;
	
	@XStreamAlias("CreateTime")
	private int createTime;
	
	@XStreamAlias("ToUserName")
	private String toUserName;
	
	@XStreamAlias("Event")
	private String event;

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

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}
