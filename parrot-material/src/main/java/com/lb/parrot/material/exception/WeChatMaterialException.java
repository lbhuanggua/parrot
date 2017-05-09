package com.lb.parrot.material.exception;

import com.lb.parrot.support.exception.WeChatAbstractException;


public class WeChatMaterialException extends WeChatAbstractException {


	private static final long serialVersionUID = 1L;
	
	public WeChatMaterialException(String errorMsg) {
		super(errorMsg);
	}
	
	public WeChatMaterialException(String errorMsg, Throwable cause) {
		super(errorMsg, cause);
	}
	
	public WeChatMaterialException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

	public WeChatMaterialException(String errorCode, String errorMsg, Throwable cause) {
		super(errorCode, errorMsg, cause);
	}
}
