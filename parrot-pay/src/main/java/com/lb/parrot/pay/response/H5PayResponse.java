package com.lb.parrot.pay.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.response.WeChatResponse;

/**
 * 
* <p>Title: </p>
* <p>Description: H5支付提交参数</p>
* @author lbhuanggua
* @date 2016年10月19日
 */
public class H5PayResponse implements WeChatResponse {

	private static final long serialVersionUID = 1L;

	private String appId;

	private String timeStamp;
    
	@JSONField(name = "package")
	private String prepayId;
	
	private String nonceStr;
	
	private String signType;
	
	private String paySign;

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
	
}
