package com.lb.parrot.support.exception;

/**
 * 
 * <p>
 * Title: 微信服务反馈基础异常
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author lbhuanggua
 * @date 2016年05月19日
 */
public class WeChatUserException extends WeChatAbstractException {

	private static final long serialVersionUID = -1869915687146573594L;
	
	public WeChatUserException(String errorMsg) {
		super(errorMsg);
	}
	
	public WeChatUserException(String errorMsg, Throwable cause) {
		super(errorMsg, cause);
	}
	
	public WeChatUserException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

	public WeChatUserException(String errorCode, String errorMsg, Throwable cause) {
		super(errorCode, errorMsg, cause);
	}

}
