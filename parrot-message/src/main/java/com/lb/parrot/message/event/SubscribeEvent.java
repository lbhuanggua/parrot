package com.lb.parrot.message.event;

import com.lb.parrot.support.common.WeChatEventMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 订阅事件模型
 *
 */
@XStreamAlias("xml")
public class SubscribeEvent extends CommonEvent{
    
	public SubscribeEvent(){
		super();
		setEvent(WeChatEventMode.SUBSCRIBE.getEvent());
	}
	
	@XStreamAlias("EventKey")
	private String eventKey;
	
	@XStreamAlias("Ticket")
	private String ticket;

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
}
