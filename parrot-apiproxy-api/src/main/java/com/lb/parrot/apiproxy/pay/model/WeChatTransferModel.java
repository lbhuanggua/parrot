package com.lb.parrot.apiproxy.pay.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WeChatTransferModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 设备号
	 */
	@XStreamAlias("device_info")
	private String deviceInfo;
	/**
	 * 商户订单号
	 */
	@XStreamAlias("partner_trade_no")
	private String partnerTradeNo;
	/**
	 * 用户openid
	 */
	@XStreamAlias("openid")
	private String openid;
	/**
	 * 校验用户姓名选项
	 */
	@XStreamAlias("check_name")
	private String checkName;
	/**
	 * 收款用户姓名
	 */
	@XStreamAlias("re_user_name")
	private String reUserName;
	/**
	 * 金额
	 */
	@XStreamAlias("amount")
	private Integer amount;
	/**
	 * 企业付款描述信息
	 */
	@XStreamAlias("desc")
	private String desc;
	/**
	 * 调用接口的机器Ip地址
	 */
	@XStreamAlias("spbill_create_ip")
	private String spbillCreateIp;
	

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getPartnerTradeNo() {
		return partnerTradeNo;
	}

	public void setPartnerTradeNo(String partnerTradeNo) {
		this.partnerTradeNo = partnerTradeNo;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getReUserName() {
		return reUserName;
	}

	public void setReUserName(String reUserName) {
		this.reUserName = reUserName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	@Override
	public String toString() {
		return "WeChatTransferModel [deviceInfo=" + deviceInfo
				+ ", partnerTradeNo=" + partnerTradeNo + ", openid=" + openid
				+ ", checkName=" + checkName + ", reUserName=" + reUserName
				+ ", amount=" + amount + ", desc=" + desc + ", spbillCreateIp="
				+ spbillCreateIp + "]";
	}

}
