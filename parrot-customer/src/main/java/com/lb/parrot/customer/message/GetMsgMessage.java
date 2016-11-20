package com.lb.parrot.customer.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

public class GetMsgMessage implements ToServerMessage {

	private static final long serialVersionUID = 1L;
	/**
	 * 起始时间，unix时间戳
	 */
	@JSONField(name = "starttime")
	private long starttime;
	/**
	 * 结束时间，unix时间戳，每次查询时段不能超过24小时
	 */
	@JSONField(name = "endtime")
	private long endtime;
	/**
	 * 消息id顺序从小到大，从1开始
	 */
	@JSONField(name = "msgid")
	private long msgid;
	/**
	 * 每次获取条数，最多10000条
	 */
	@JSONField(name = "number")
	private long number;

	public long getStarttime() {
		return starttime;
	}

	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}

	public long getEndtime() {
		return endtime;
	}

	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}

	public long getMsgid() {
		return msgid;
	}

	public void setMsgid(long msgid) {
		this.msgid = msgid;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
