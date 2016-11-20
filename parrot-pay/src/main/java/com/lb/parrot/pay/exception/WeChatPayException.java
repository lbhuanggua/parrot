package com.lb.parrot.pay.exception;

import com.lb.parrot.support.exception.WeChatAbstractException;

/**
 * 
* <p>Title: 支付异常类</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年10月19日
 */
public class WeChatPayException extends WeChatAbstractException {


	private static final long serialVersionUID = 1L;
	
	public WeChatPayException(String errorMsg) {
		super(errorMsg);
	}
	
	public WeChatPayException(String errorMsg, Throwable cause) {
		super(errorMsg, cause);
	}
	
	public WeChatPayException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

	public WeChatPayException(String errorCode, String errorMsg, Throwable cause) {
		super(errorCode, errorMsg, cause);
	}
}
