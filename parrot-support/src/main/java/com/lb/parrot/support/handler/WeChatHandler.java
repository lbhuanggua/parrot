package com.lb.parrot.support.handler;

import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.exception.WeChatSupportException;

public interface WeChatHandler extends Comparable<WeChatHandler>{
	
	int getPriority();

	void setPriority(int priority);

	WeChatHandlerMode getWeChatHandlerMode();

	/**
	 * 是否匹配对象和上下文
	 * 
	 * @param <T>
	 * @param message
	 * @return
	 */
	<T> boolean isMatch(T message, WeChatContext context);

	/**
	 * 处理对象
	 * 
	 * @param <T>
	 * @param message
	 * @param context
	 */
	<T> void process(T message, WeChatContext context) throws WeChatSupportException;
}
