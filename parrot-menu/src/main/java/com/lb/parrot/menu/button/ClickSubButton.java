package com.lb.parrot.menu.button;

import com.lb.parrot.support.common.WeChatEventMode;

/**
 * click：点击推事件。用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event
 * 的结构给开发者（参考消息接口指南），并且带上按钮中开发者填写的key值，开发者可以通过自定义的key值与用户进行交互
 *
 */
public class ClickSubButton extends CommonSubButton {

	public ClickSubButton() {
		this(null, null);
	}

	public ClickSubButton(String name) {
		this(name, null);
	}

	public ClickSubButton(String name, String key) {
		super(name, WeChatEventMode.CLICK.getEvent().toLowerCase());
		this.key = key;
	}

	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
