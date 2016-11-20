package com.lb.parrot.menu.button;

/**
 * 一级菜单按钮
 *
 */
public class CommonButton {
	
	public CommonButton() {}

	public CommonButton(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
