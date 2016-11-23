package com.lb.parrot.message.event;

import com.lb.parrot.support.common.WeChatEventMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 自定义菜单事件<br>
 * 点击菜单跳转链接时的事件推送 
 *
 */
@XStreamAlias("xml")
public class ViewEvent extends CommonEvent{
	
	public ViewEvent(){
		super();
		setEvent(WeChatEventMode.VIEW.getEvent());
	}

	@XStreamAlias("EventKey")
	private String eventKey;
	
	@XStreamAlias("MenuId")
	private String menuId;
	
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}
