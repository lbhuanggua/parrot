package com.lb.parrot.apiproxy.pay.model;

import java.io.Serializable;

import com.lb.parrot.pay.common.BillType;

public class WeChatDownBillModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 设备号
	 */
	private String deviceInfo;

	/**
	 * 对账单日期
	 */
	private String billDate;
	/**
	 * 账单类型
	 */
	private String billType;
	/**
	 * 压缩账单
	 */
	private String tarType;

	public WeChatDownBillModel(String billDate) {
		super();
		this.billDate = billDate;
		this.billType = BillType.ALL.name();
	}
	
	public WeChatDownBillModel(String deviceInfo, String billDate,
			String billType) {
		super();
		this.deviceInfo = deviceInfo;
		this.billDate = billDate;
		this.billType = billType;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getTarType() {
		return tarType;
	}

	public void setTarType(String tarType) {
		this.tarType = tarType;
	}

	@Override
	public String toString() {
		return "WeChatDownBillModel [deviceInfo=" + deviceInfo + ", billDate="
				+ billDate + ", billType=" + billType + ", tarType=" + tarType
				+ "]";
	}

}
