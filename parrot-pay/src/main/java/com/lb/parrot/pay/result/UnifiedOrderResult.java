package com.lb.parrot.pay.result;

import com.lb.parrot.pay.result.pojo.PayBusinessResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class UnifiedOrderResult extends PayBusinessResult{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 交易类型
	 */
	@XStreamAlias("trade_type")
	private String tradeType;
	
	/**
	 * 预支付会话Id
	 */
	@XStreamAlias("prepay_id")
	private String prepayId;
	
	/**
	 * 二维码URL
	 */
	@XStreamAlias("code_url")
	private String codeUrl;


	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}
	

}
