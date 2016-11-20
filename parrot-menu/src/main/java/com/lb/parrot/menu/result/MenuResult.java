package com.lb.parrot.menu.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

public class MenuResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "menu")
	private MenuButton menu;

	public MenuButton getMenu() {
		return menu;
	}

	public void setMenu(MenuButton menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "MenuResult [menu=" + menu + "]";
	}

}
