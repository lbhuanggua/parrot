package com.lb.parrot.message.event;

import com.lb.parrot.support.common.WeChatEventMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class SelectLocationEvent extends CommonEvent{

	public SelectLocationEvent(){
		super();
		setEvent(WeChatEventMode.LOCATION_SELECT.getEvent());
	}
	
	@XStreamAlias("EventKey")
	private String eventKey;
	
	@XStreamAlias("SendLocationInfo")
	private SendLocationInfo sendLocationInfo;

	public SendLocationInfo getSendLocationInfo() {
		return sendLocationInfo;
	}

	public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
		this.sendLocationInfo = sendLocationInfo;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
}
