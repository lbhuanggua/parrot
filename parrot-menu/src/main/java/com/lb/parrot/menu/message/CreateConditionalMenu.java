package com.lb.parrot.menu.message;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.menu.button.CommonButton;
import com.lb.parrot.menu.button.conditoinal.MatchruleButton;
import com.lb.parrot.support.common.ToServerMessage;

/**
 * 创建微信自定义菜单
 *
 */
public class CreateConditionalMenu implements ToServerMessage {

	private static final long serialVersionUID = 1L;
	
	@JSONField(name = "button")
	private List<CommonButton> buttons;

	public List<CommonButton> getButtons() {
		if (buttons == null) {
			buttons = new ArrayList<CommonButton>();
		}
		return buttons;
	}

	public void setButtons(List<CommonButton> buttons) {
		this.buttons = buttons;
	}

	@JSONField(name = "matchrule")
	private MatchruleButton matchruleButton;

	public MatchruleButton getMatchruleButton() {
		return matchruleButton;
	}

	public void setMatchruleButton(MatchruleButton matchruleButton) {
		this.matchruleButton = matchruleButton;
	}

	public void addButton(CommonButton button) {
		getButtons().add(button);
	}

	public void removeButton(CommonButton button) {
		getButtons().remove(button);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
