package com.lb.parrot.message.event;

import com.lb.parrot.support.common.WeChatEventMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 上报地理位置事件
 */
@XStreamAlias("xml")
public class LocationEvent extends CommonEvent{
	
	public LocationEvent(){
		super();
		setEvent(WeChatEventMode.LOCATION.getEvent());
	}

	@XStreamAlias("Latitude")
	private double latitude;
	
	@XStreamAlias("Longitude")
	private double longitude;
	
	@XStreamAlias("Precision")
	private double precision;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}
	
}
