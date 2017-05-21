package com.lb.parrot.template.message;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class TemplateDataTheme implements Serializable{

	private static final long serialVersionUID = 1L;

	@JSONField(name = "value")
	private String value;

	@JSONField(name = "color")
	private String color;
	
	public TemplateDataTheme() {
		super();
	}
	
	public TemplateDataTheme(String value, String color) {
		super();
		this.value = value;
		this.color = color;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return JSON.toJSONString(this);
	}

}
