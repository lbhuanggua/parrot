package com.lb.parrot.message.event;

import com.lb.parrot.support.common.WeChatEventMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * <p>
 * Title: 自定义菜单事件
 * </p>
 * <p>
 * Description: 点击菜单拉取消息时的事件推送
 * </p>
 * 
 * @author lbhuanggua
 * @date 2016年10月17日
 */

@XStreamAlias("xml")
public class ClickEvent extends CommonEvent{
	
	public ClickEvent(){
		super();
		setEvent(WeChatEventMode.CLICK.getEvent());
	}

	@XStreamAlias("EventKey")
	private String eventKey;
	
	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}
