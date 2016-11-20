package com.lb.parrot.support.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

public class JsApiTicket extends AbstractToServerResult implements ToServerResult {

	private static final long serialVersionUID = 1L;
	
	String ticket;

	@JSONField(name = "expires_in")
	long expiresIn;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

}
