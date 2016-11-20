package com.lb.parrot.apiproxy.pay.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WeChatGroupRedPackModel implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 商户订单号
	 */
	@XStreamAlias("mch_billno")
	private String mchBillno;
	/**
	 * 商户名称
	 */
	@XStreamAlias("send_name")
	private String sendName;
	/**
	 * 用户openid
	 */
	@XStreamAlias("re_openid")
	private String reOpenid;
	/**
	 * 付款金额
	 */
	@XStreamAlias("total_amount")
	private int totalAmount;
	/**
	 * 红包发放总人数
	 */
	@XStreamAlias("total_num")
	private int totalNum;
	/**
	 * 红包金额设置方式 ALL_RAND—全部随机,商户指定总金额和红包发放总人数，由微信支付随机计算出各红包金额
	 */
	@XStreamAlias("amt_type")
	private String amtType;
	/**
	 * 红包祝福语
	 */
	@XStreamAlias("wishing")
	private String wishing;
	/**
	 * 活动名称
	 */
	@XStreamAlias("act_name")
	private String actName;
	/**
	 * 备注
	 */
	@XStreamAlias("remark")
	private String remark;
	/**
	 * 场景id PRODUCT_1:商品促销 PRODUCT_2:抽奖 PRODUCT_3:虚拟物品兑奖 PRODUCT_4:企业内部福利
	 * PRODUCT_5:渠道分润 PRODUCT_6:保险回馈 PRODUCT_7:彩票派奖 PRODUCT_8:税务刮奖
	 */
	@XStreamAlias("scene_id")
	private String sceneId;
	/**
	 * 活动信息
	 */
	@XStreamAlias("risk_info")
	private String riskInfo;

	/**
	 * 资金授权商户号
	 */
	@XStreamAlias("consume_mch_id")
	private String consumeMchId;

	/**
	 * Ip地址
	 */
	@XStreamAlias("client_ip")
	private String clientIp;

	public String getMchBillno() {
		return mchBillno;
	}

	public void setMchBillno(String mchBillno) {
		this.mchBillno = mchBillno;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getReOpenid() {
		return reOpenid;
	}

	public void setReOpenid(String reOpenid) {
		this.reOpenid = reOpenid;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public String getAmtType() {
		return amtType;
	}

	public void setAmtType(String amtType) {
		this.amtType = amtType;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSceneId() {
		return sceneId;
	}

	public void setSceneId(String sceneId) {
		this.sceneId = sceneId;
	}

	public String getRiskInfo() {
		return riskInfo;
	}

	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

	public String getConsumeMchId() {
		return consumeMchId;
	}

	public void setConsumeMchId(String consumeMchId) {
		this.consumeMchId = consumeMchId;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	@Override
	public String toString() {
		return "WeChatGroupRedPackModel [mchBillno=" + mchBillno
				+ ", sendName=" + sendName + ", reOpenid=" + reOpenid
				+ ", totalAmount=" + totalAmount + ", totalNum=" + totalNum
				+ ", amtType=" + amtType + ", wishing=" + wishing
				+ ", actName=" + actName + ", remark=" + remark + ", sceneId="
				+ sceneId + ", riskInfo=" + riskInfo + ", consumeMchId="
				+ consumeMchId + ", clientIp=" + clientIp + "]";
	}

}
