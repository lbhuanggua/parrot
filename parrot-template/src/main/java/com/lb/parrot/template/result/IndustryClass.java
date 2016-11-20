package com.lb.parrot.template.result;

import com.alibaba.fastjson.annotation.JSONField;

public class IndustryClass {

	@JSONField(name = "first_class")
	private String firstClass;

	@JSONField(name = "second_class")
	private String secondClass;

	public String getFirstClass() {
		return firstClass;
	}

	public void setFirstClass(String firstClass) {
		this.firstClass = firstClass;
	}

	public String getSecondClass() {
		return secondClass;
	}

	public void setSecondClass(String secondClass) {
		this.secondClass = secondClass;
	}

}
