package com.lb.parrot.pay.result.red;

import com.lb.parrot.pay.result.pojo.PayRedPackBusinessResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class RedPackInfoResult extends PayRedPackBusinessResult{

	private static final long serialVersionUID = 1L;
	/**
	 * 商品订单号
	 */
	@XStreamAlias("mch_billno")
	private String mchBillno;
	/**
	 * 商户号
	 */
	@XStreamAlias("mch_id")
	private String mchId;
	/**
	 * 红包订单Id
	 */
	@XStreamAlias("detail_id")
	private String detailId;
	/**
	 * 红包状态 SENDING:发放中 SENT:已发放待领取 FAILED：发放失败 RECEIVED:已领取 RFUND_ING:退款中
	 * REFUND:已退款
	 */
	@XStreamAlias("status")
	private String status;
	/**
	 * 发放类型
	 */
	@XStreamAlias("send_type")
	private String sendType;
	/**
	 * 红包类型
	 */
	@XStreamAlias("hb_type")
	private String hbType;
	/**
	 * 红包金额，单位为分
	 */
	@XStreamAlias("total_amount")
	private Integer totalAmount;
	/**
	 * 红包发放人数
	 */
	@XStreamAlias("total_num")
	private Integer totalNum;
	/**
	 * 失败原因
	 */
	@XStreamAlias("reason")
	private String reason;
	
	/**
	 * 红包发送时间
	 */
	@XStreamAlias("send_time")
	private String sendTime;
	/**
	 * 红包退款时间
	 */
	@XStreamAlias("refund_time")
	private String refundTime;
	/**
	 * 红包退款金额
	 */
	@XStreamAlias("refund_amount")
	private Integer refundAmount;
	/**
	 * 祝福语
	 */
	@XStreamAlias("wishing")
	private String wishing;
	/**
	 * 活动描述
	 */
	@XStreamAlias("remark")
	private String remark;
	/**
	 * 活动描述
	 */
	@XStreamAlias("act_name")
	private String actName;

	/**
	 * 红包获取列表
	 */
	@XStreamAlias("hblist")
	private RedPackHBList hblist;

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

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getHbType() {
		return hbType;
	}

	public void setHbType(String hbType) {
		this.hbType = hbType;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}

	public Integer getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Integer refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public RedPackHBList getHblist() {
		return hblist;
	}

	public void setHblist(RedPackHBList hblist) {
		this.hblist = hblist;
	}

}
