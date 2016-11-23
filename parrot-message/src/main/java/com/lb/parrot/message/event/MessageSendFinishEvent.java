package com.lb.parrot.message.event;

import com.lb.parrot.support.common.WeChatEventMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 群发消息发送结束事件
 *
 */
@XStreamAlias("xml")
public class MessageSendFinishEvent extends CommonEvent{

	public MessageSendFinishEvent(){
		super();
		setEvent(WeChatEventMode.MASS_SEND_JOB_FINISH.getEvent());
	}
	@XStreamAlias("MsgID")
	private String msgId;
	
	@XStreamAlias("Status")
	private String status;
	
	@XStreamAlias("TotalCount")
	private int totalCount;
	
	@XStreamAlias("FilterCount")
	private int filterCount;
	
	@XStreamAlias("SentCount")
	private int sentCount;
	
	@XStreamAlias("ErrorCount")
	private int errorCount;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getFilterCount() {
		return filterCount;
	}

	public void setFilterCount(int filterCount) {
		this.filterCount = filterCount;
	}

	public int getSentCount() {
		return sentCount;
	}

	public void setSentCount(int sentCount) {
		this.sentCount = sentCount;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}
	
}
