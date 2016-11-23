package com.lb.parrot.message.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class SendLocationInfo {

	@XStreamAlias("Location_X")
	private double locationX;
	
	@XStreamAlias("Location_Y")
	private double locationY;
	
	@XStreamAlias("Scale")
	private double scale;
	
	@XStreamAlias("Label")
	private String label;
	
	@XStreamAlias("Poiname")
	private String pointName;

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

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	
	
}
