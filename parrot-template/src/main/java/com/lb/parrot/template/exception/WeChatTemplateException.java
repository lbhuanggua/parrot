package com.lb.parrot.template.exception;

import com.lb.parrot.support.exception.WeChatAbstractException;


public class WeChatTemplateException extends WeChatAbstractException {


	private static final long serialVersionUID = 1L;
	
	public WeChatTemplateException(String errorMsg) {
		super(errorMsg);
	}
	
	public WeChatTemplateException(String errorMsg, Throwable cause) {
		super(errorMsg, cause);
	}
	
	public WeChatTemplateException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

	public WeChatTemplateException(String errorCode, String errorMsg, Throwable cause) {
		super(errorCode, errorMsg, cause);
	}
}
