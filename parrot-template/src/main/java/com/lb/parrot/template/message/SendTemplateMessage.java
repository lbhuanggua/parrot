package com.lb.parrot.template.message;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

/**
 * 发送模板消息
 */
public class SendTemplateMessage implements ToServerMessage {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "touser")
	private String touser;

	@JSONField(name = "template_id")
	private String templateId;

	@JSONField(name = "url")
	private String url;

	@JSONField(name = "data")
	private Map<String, TemplateDataTheme> data;
	
	public SendTemplateMessage() {
		super();
	}
	
	public SendTemplateMessage(String touser, String templateId, String url,
			Map<String, TemplateDataTheme> data) {
		super();
		this.touser = touser;
		this.templateId = templateId;
		this.url = url;
		this.data = data;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, TemplateDataTheme> getData() {
		return data;
	}

	public void setData(Map<String, TemplateDataTheme> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
