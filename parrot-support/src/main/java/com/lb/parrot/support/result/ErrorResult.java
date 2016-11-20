package com.lb.parrot.support.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

public class ErrorResult implements ToServerResult {

	private static final long serialVersionUID = 1L;
	
	@JSONField(name = "errcode")
	String errCode;

	@JSONField(name = "errmsg")
	String errMsg;

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

	@Override
	public String toString() {
		return "ErrorResult [errCode=" + errCode + ", errMsg=" + errMsg + "]";
	}
	
}
