package com.lb.parrot.message.event;

import com.lb.parrot.support.common.WeChatEventMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class ScanAlertEvent extends CommonEvent{

	public ScanAlertEvent(){
		super();
		setEvent(WeChatEventMode.SCANCODE_WAITMSG.getEvent());
	}
	
	@XStreamAlias("EventKey")
	private String eventKey;
	
	@XStreamAlias("ScanCodeInfo")
	private ScanCodeInfo scanCodeInfo;

	public ScanCodeInfo getScanCodeInfo() {
		return scanCodeInfo;
	}

	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		this.scanCodeInfo = scanCodeInfo;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
	
}
