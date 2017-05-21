package com.lb.parrot.template.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

/**
 * 获取模板列表-返回值
 *
 */
public class TemplateResult implements ToServerResult {
	
	private static final long serialVersionUID = 1L;
	
	@JSONField(name = "template_list")
	private List<TemplateClass> templateList;

	public List<TemplateClass> getTemplateList() {
		return templateList;
	}

	public void setTemplateList(List<TemplateClass> templateList) {
		this.templateList = templateList;
	}

}
