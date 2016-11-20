package com.lb.parrot.support.handler;

import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.result.ErrorResult;

/**
 * 
* <p>Title: 错误结果处理器</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public class ErrorResultHandler extends AbstractWeChatHandler{


	public void init() {
	}

	public void destory() {
	}
	
	public WeChatHandlerMode getWeChatHandlerMode() {
		return WeChatHandlerMode.SEND_OUPUT;
	}

	public <T> boolean isMatch(T message, WeChatContext context) {
		return message instanceof ErrorResult;
	}

	public <T> void process(T message, WeChatContext context) {
		ErrorResult result = (ErrorResult) message;
		LOGGER.error("errcode:{0},errmsg:{1},input:{2}", result.getErrCode(),result.getErrMsg(),context.getInput());
	}

}
