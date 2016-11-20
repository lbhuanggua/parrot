package com.lb.parrot.pay.message;

import com.lb.parrot.pay.common.AbstactPaySignature;
import com.lb.parrot.support.common.ToServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class SendRedPackMessage extends AbstactPaySignature implements
		ToServerMessage {
	private static final long serialVersionUID = 1L;
	/**
	 * 随机字符串
	 */
	@XStreamAlias("nonce_str")
	private String nonceStr;
	/**
	 * 签名
	 */
	@XStreamAlias("sign")
	private String signature;
	/**
	 * 商户订单号
	 */
	@XStreamAlias("mch_billno")
	private String mchBillno;
	/**
	 * 商户号
	 */
	@XStreamAlias("mch_id")
	private String mchId;
	/**
	 * 公众账号appid
	 */
	@XStreamAlias("wxappid")
	private String appId;
	/**
	 * 商户名称
	 */
	@XStreamAlias("send_name")
	private String sendName;
	/**
	 * 用户openid
	 */
	@XStreamAlias("re_openid")
	private String openid;
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
	 * 红包祝福语
	 */
	@XStreamAlias("wishing")
	private String wishing;
	/**
	 * Ip地址
	 */
	@XStreamAlias("client_ip")
	private String clientIp;
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

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getMchBillno() {
		return mchBillno;
	}

	public void setMchBillno(String mchBillno) {
		this.mchBillno = mchBillno;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
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

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
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


}
