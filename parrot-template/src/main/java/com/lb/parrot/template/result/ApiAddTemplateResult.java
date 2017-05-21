package com.lb.parrot.template.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

public class ApiAddTemplateResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "errcode")
	private String errCode;

	@JSONField(name = "errmsg")
	private String errMsg;

	@JSONField(name = "template_id")
	private String templateId;

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

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
