package com.lb.parrot.customer.message;

import com.alibaba.fastjson.annotation.JSONField;

public class TextContent{

	@JSONField(name = "content")
	private String content;

	public TextContent(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
