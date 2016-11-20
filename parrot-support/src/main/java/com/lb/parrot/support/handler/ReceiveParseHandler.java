package com.lb.parrot.support.handler;

import java.io.IOException;
import java.io.InputStream;

import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.util.ParserUtil;
import com.lb.parrot.support.util.StreamUtil;

/**
 * 
* <p>Title: 默认微信消息转换</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public class ReceiveParseHandler extends AbstractWeChatHandler {

	public void init() {
	}

	public void destory() {
	}
	
	public WeChatHandlerMode getWeChatHandlerMode() {
		return WeChatHandlerMode.RECEIVE;
	}

	public <T> boolean isMatch(T message,WeChatContext context) {
		return message instanceof String || message instanceof InputStream;
	}

	public <T> void process(T message, WeChatContext context) throws WeChatSupportException {
		if(message instanceof String){
		   String content =(String) message;
		   parseString(content,context);
		}else if(message instanceof InputStream){
			InputStream inputStream =(InputStream) message;
			try {
				parseString(StreamUtil.readText(inputStream, "UTF-8", false),context);
			} catch (IOException e) {
				throw new WeChatSupportException(e.getMessage(), e);
			}
		}
		
	}
	
	private void parseString(String content, WeChatContext context) throws WeChatSupportException{
		context.setInput(ParserUtil.parse(content, ConvertMode.RECEIVE));
	}
	
	/**
	 * 优先级高
	 */
	public int getPriority() {
		return Integer.MIN_VALUE + 100;
	}

}
