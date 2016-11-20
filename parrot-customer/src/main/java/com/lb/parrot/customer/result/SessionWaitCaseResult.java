package com.lb.parrot.customer.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;
/**
 * 获取未接入会话列表返回体
 *
 */
public class SessionWaitCaseResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	/**
	 * 未接入会话数量
	 */
	@JSONField(name = "count")
	private long count;

	/**
	 * 未接入会话列表，最多返回100条数据，按照来访顺序
	 */
	@JSONField(name = "waitcaselist")
	private List<SessionUser> waitcaselist;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<SessionUser> getWaitcaselist() {
		return waitcaselist;
	}

	public void setWaitcaselist(List<SessionUser> waitcaselist) {
		this.waitcaselist = waitcaselist;
	}

	@Override
	public String toString() {
		return "WaitCaseResult [count=" + count + ", waitcaselist="
				+ waitcaselist + "]";
	}

}
