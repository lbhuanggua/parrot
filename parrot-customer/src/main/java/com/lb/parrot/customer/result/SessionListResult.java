package com.lb.parrot.customer.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

/**
 * 获取客服会话列表返回体
 *
 */
public class SessionListResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "sessionlist")
	private List<SessionUser> sessionlist;

	public List<SessionUser> getSessionlist() {
		return sessionlist;
	}

	public void setSessionlist(List<SessionUser> sessionlist) {
		this.sessionlist = sessionlist;
	}

	@Override
	public String toString() {
		return "SessionListResult [sessionlist=" + sessionlist + "]";
	}

}
