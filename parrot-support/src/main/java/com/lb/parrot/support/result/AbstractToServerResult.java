package com.lb.parrot.support.result;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* <p>Title: 发送到微信服务器的消息的响应结果抽象类</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public abstract class AbstractToServerResult {
	
	@JSONField(name = "errcode")
	String errCode;

	@JSONField(name = "errmsg")
	String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
