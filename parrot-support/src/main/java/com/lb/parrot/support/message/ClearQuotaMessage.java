package com.lb.parrot.support.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;


public class ClearQuotaMessage implements ToServerMessage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JSONField(name = "appid")
	private String appid;
	
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	
}
