package com.lb.parrot.support.handler;

/**
 * 微信处理器的类型
 *
 */
public enum WeChatHandlerMode {
    /**
     * 处理发送操作的输入对象
     */
	SEND_INPUT,
	/**
	 * 处理发送操作的输出对象
	 */
	SEND_OUPUT,
	/**
	 * 处理接收操作
	 */
	RECEIVE
}
