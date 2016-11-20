package com.lb.parrot.template.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

/**
 * 发送模板消息-返回值
 *
 */
public class SendTemplateResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "errcode")
	private String errCode;

	@JSONField(name = "errmsg")
	private String errMsg;

	@JSONField(name = "msgid")
	private String msgId;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@Override
	public String toString() {
		return "SendTemplateResult [errCode=" + errCode + ", errMsg=" + errMsg
				+ ", msgId=" + msgId + "]";
	}

}
