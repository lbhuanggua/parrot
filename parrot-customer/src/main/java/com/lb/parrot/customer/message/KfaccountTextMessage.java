package com.lb.parrot.customer.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

public class KfaccountTextMessage implements ToServerMessage {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "touser")
	private String touser;

	@JSONField(name = "msgtype")
	private String msgtype;

	@JSONField(name = "text")
	private TextContent text;
	
	public KfaccountTextMessage(String touser, String msgtype, TextContent text) {
		super();
		this.touser = touser;
		this.msgtype = msgtype;
		this.text = text;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public TextContent getText() {
		return text;
	}

	public void setText(TextContent text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
