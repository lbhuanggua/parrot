package com.lb.parrot.message.from;

import com.lb.parrot.support.common.WeChatMessageMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 地理位置消息
 *
 */
@XStreamAlias("xml")
public class LocationMessage extends CommonMessage{

	public LocationMessage(){
	   setMsgType(WeChatMessageMode.LOCATION.getType());
	}
	
	@XStreamAlias("Location_X")
	private double locationX;
	
	@XStreamAlias("Location_Y")
	private double locationY;
	
	@XStreamAlias("Scale")
	private int scale;
	
	@XStreamAlias("Label")
	private String label;

	public double getLocationX() {
		return locationX;
	}

	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	public double getLocationY() {
		return locationY;
	}

	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
