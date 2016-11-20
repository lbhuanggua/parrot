package com.lb.parrot.template.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

/**
 * 删除模板
 *
 */
public class DelPrivateTemplateMessage implements ToServerMessage {
	private static final long serialVersionUID = 1L;
	/**
	 * 公众帐号下模板消息ID
	 */
	@JSONField(name = "template_id")
	private String templateId;

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
