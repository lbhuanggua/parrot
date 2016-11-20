package com.lb.parrot.customer.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

/**
 * 聊天记录返回体
 */
public class MsgListResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "recordlist")
	private List<MsgRecord> recordlist;

	@JSONField(name = "number")
	private long number;

	@JSONField(name = "msgid")
	private long msgid;

	public List<MsgRecord> getRecordlist() {
		return recordlist;
	}

	public void setRecordlist(List<MsgRecord> recordlist) {
		this.recordlist = recordlist;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getMsgid() {
		return msgid;
	}

	public void setMsgid(long msgid) {
		this.msgid = msgid;
	}

	@Override
	public String toString() {
		return "MsgListResult [recordlist=" + recordlist + ", number=" + number
				+ ", msgid=" + msgid + "]";
	}

}
