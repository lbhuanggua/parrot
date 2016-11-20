package com.lb.parrot.menu.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class ButtonResult {

	@JSONField(name = "type")
	private String type;

	@JSONField(name = "name")
	private String name;

	@JSONField(name = "key")
	private String key;

	@JSONField(name = "url")
	private String url;

	@JSONField(name = "sub_button")
	private List<ButtonResult> subButton;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<ButtonResult> getSubButton() {
		return subButton;
	}

	public void setSubButton(List<ButtonResult> subButton) {
		this.subButton = subButton;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
