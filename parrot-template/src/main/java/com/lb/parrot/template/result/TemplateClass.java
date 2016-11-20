package com.lb.parrot.template.result;

import com.alibaba.fastjson.annotation.JSONField;

public class TemplateClass {

	/**
	 * 模板ID
	 */
	@JSONField(name = "template_id")
	private String templateId;

	/**
	 * 模板标题
	 */
	@JSONField(name = "title")
	private String title;

	/**
	 * 模板所属行业的一级行业
	 */
	@JSONField(name = "primary_industry")
	private String primaryIndustry;

	/**
	 * 模板所属行业的二级行业
	 */
	@JSONField(name = "deputy_industry")
	private String deputyIndustry;

	/**
	 * 模板内容
	 */
	@JSONField(name = "content")
	private String content;

	/**
	 * 模板示例
	 */
	@JSONField(name = "example")
	private String example;

}
