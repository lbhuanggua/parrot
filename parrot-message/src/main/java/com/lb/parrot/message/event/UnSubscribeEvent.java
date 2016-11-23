package com.lb.parrot.message.event;

import com.lb.parrot.support.common.WeChatEventMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 取消订阅事件模型
 *
 */
@XStreamAlias("xml")
public class UnSubscribeEvent extends CommonEvent{

	public UnSubscribeEvent(){
		super();
		setEvent(WeChatEventMode.UNSUBSCRIBE.getEvent());
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
