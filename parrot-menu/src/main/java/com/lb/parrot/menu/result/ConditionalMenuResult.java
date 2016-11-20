package com.lb.parrot.menu.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.ToServerResult;

public class ConditionalMenuResult implements ToServerResult {
	private static final long serialVersionUID = 1L;
	@JSONField(name = "menu")
	private MenuButton menu;

	@JSONField(name = "conditionalmenu")
	private List<ConditionalMenuButton> conditionalmenu;

	public MenuButton getMenu() {
		return menu;
	}

	public void setMenu(MenuButton menu) {
		this.menu = menu;
	}

	public List<ConditionalMenuButton> getConditionalmenu() {
		return conditionalmenu;
	}

	public void setConditionalmenu(List<ConditionalMenuButton> conditionalmenu) {
		this.conditionalmenu = conditionalmenu;
	}

}
