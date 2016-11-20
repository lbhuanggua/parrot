package com.lb.parrot.support.exception;

/**
 * 
 * <p>
 * Title: 微信服务反馈标准异常
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author lbhuanggua
 * @date 2016年05月19日
 */
public class WeChatAbstractException extends RuntimeException {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 2847270337679322656L;
	/**
	 * 错误代码
	 */
	protected String errorCode;
	/**
	 * 错误信息
	 */
	protected String errorMsg;
	
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public WeChatAbstractException() {
		super();
	}

	public WeChatAbstractException(String message) {
		super(message);
	}
	
	public WeChatAbstractException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeChatAbstractException(Throwable cause) {
		super(cause);
	}
	
	public WeChatAbstractException(String errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public WeChatAbstractException(String errorCode, String errorMsg, Throwable cause) {
		super(errorMsg, cause);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	@Override
    public String getMessage() {
        if (this.errorMsg == null || "".equals(this.errorMsg)) {
            return super.getMessage();
        }
		return "errorCode:" + this.errorCode == null ? "" : this.errorCode + ",errorMsg:" + this.errorMsg;
    }

}
