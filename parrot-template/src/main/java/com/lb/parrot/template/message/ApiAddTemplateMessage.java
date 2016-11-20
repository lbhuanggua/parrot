package com.lb.parrot.template.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerMessage;

/**
 * 获得模板ID
 */
public class ApiAddTemplateMessage implements ToServerMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
	 */
	@JSONField(name = "template_id_short")
	private String templateIdShort;

	public String getTemplateIdShort() {
		return templateIdShort;
	}

	public void setTemplateIdShort(String templateIdShort) {
		this.templateIdShort = templateIdShort;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
