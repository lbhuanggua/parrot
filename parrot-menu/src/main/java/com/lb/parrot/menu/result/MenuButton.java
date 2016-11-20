package com.lb.parrot.menu.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class MenuButton{

	@JSONField(name = "button")
	private List<ButtonResult> buttons;

	@JSONField(name = "menuid")
	private String menuid;

	public List<ButtonResult> getButtons() {
		return buttons;
	}

	public void setButtons(List<ButtonResult> buttons) {
		this.buttons = buttons;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

}
