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
public class WeChatSupportException extends WeChatAbstractException {

	private static final long serialVersionUID = -1869915687146573594L;
	
	public WeChatSupportException(String errorMsg) {
		super(errorMsg);
	}
	
	public WeChatSupportException(String errorMsg, Throwable cause) {
		super(errorMsg, cause);
	}
	
	public WeChatSupportException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

	public WeChatSupportException(String errorCode, String errorMsg, Throwable cause) {
		super(errorCode, errorMsg, cause);
	}

}
