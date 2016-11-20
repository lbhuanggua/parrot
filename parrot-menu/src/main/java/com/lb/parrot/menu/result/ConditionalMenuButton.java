package com.lb.parrot.menu.result;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.menu.button.conditoinal.MatchruleButton;

public class ConditionalMenuButton {

	@JSONField(name = "button")
	private List<ButtonResult> buttons;

	@JSONField(name = "matchrule")
	private MatchruleButton matchrule;

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

	public MatchruleButton getMatchrule() {
		return matchrule;
	}

	public void setMatchrule(MatchruleButton matchrule) {
		this.matchrule = matchrule;
	}

}
