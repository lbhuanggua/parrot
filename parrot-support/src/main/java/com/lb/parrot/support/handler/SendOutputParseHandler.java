package com.lb.parrot.support.handler;

import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.util.ParserUtil;

/**
 * 
* <p>Title: 默认请求微信的结果处理</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public class SendOutputParseHandler extends AbstractWeChatHandler {

	public void init() {
	}

	public void destory() {
	}
	
	public SendOutputParseHandler() {
		setPriority(Integer.MIN_VALUE + 100);
	}

	public WeChatHandlerMode getWeChatHandlerMode() {
		return WeChatHandlerMode.SEND_OUPUT;
	}

	public <T> boolean isMatch(T message, WeChatContext context) {
		return message instanceof String;
	}

	public <T> void process(T message, WeChatContext context) throws WeChatSupportException{
		String content = (String) message;
		context.setOutput(ParserUtil.parse(content, ConvertMode.SEND));
	}
}
