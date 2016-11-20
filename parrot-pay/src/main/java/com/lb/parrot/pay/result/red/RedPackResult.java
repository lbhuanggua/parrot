package com.lb.parrot.pay.result.red;

import com.lb.parrot.pay.result.pojo.PayRedPackBusinessResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("xml")
public class RedPackResult extends PayRedPackBusinessResult{

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
	 * 公众账号appid
	 */
	@XStreamAlias("wxappid")
	private String appid;
	/**
	 * 用户openid
	 */
	@XStreamAlias("re_openid")
	private String openid;
	/**
	 * 付款金额
	 */
	@XStreamAlias("total_amount")
	private Integer totalAmount;
	/**
	 * 微信单号
	 */
	@XStreamAlias("send_listid")
	private String sendListId;

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

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSendListId() {
		return sendListId;
	}

	public void setSendListId(String sendListId) {
		this.sendListId = sendListId;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
