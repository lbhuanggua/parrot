package com.lb.parrot.message.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class ScanCodeInfo {

	@XStreamAlias("ScanType")
	private String scanType;
	
	@XStreamAlias("ScanResult")
	private String scanResult;

	public String getScanType() {
		return scanType;
	}

	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	public String getScanResult() {
		return scanResult;
	}

	public void setScanResult(String scanResult) {
		this.scanResult = scanResult;
	}
	
	
}
