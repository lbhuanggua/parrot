package com.lb.parrot.pay.result.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class GetTransfersInfoBusinessResult extends PayReturnResult {

	private static final long serialVersionUID = 1L;

	/**
	 * 业务代码
	 */
	@XStreamAlias("result_code")
	private String resultCode;

	/**
	 * 错误代码
	 */
	@XStreamAlias("err_code")
	private String errorCode;
	
	/**
	 * 错误代码描述
	 */
	@XStreamAlias("err_code_des")
	private String errorCodeDes;


	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrorCodeDes() {
		return errorCodeDes;
	}

	public void setErrorCodeDes(String errorCodeDes) {
		this.errorCodeDes = errorCodeDes;
	}
	
}
