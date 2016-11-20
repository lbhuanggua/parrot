package com.lb.parrot.support.convert;

import com.lb.parrot.support.exception.WeChatSupportException;

public interface Convert extends Comparable<Convert> {

	/**
	 * 获得优先级
	 * 
	 * @return
	 */
	int getPriority();

	/**
	 * 设置优先级
	 * 
	 * @param priority
	 */
	void setPriority(int priority);

	/**
	 * 获得报文的状态
	 * 
	 * @return
	 */
	ConvertMode getConvertMode();

	/**
	 * 获得结果类型
	 * 
	 * @return
	 */
	Class<?> getClazzType();

	/**
	 * 判断转换接口能否处理输入信息（微信报文会出现不同类型报文字段一致的情况，需要根据上下文判断）
	 * 
	 * @param <INPUT>
	 * @param input
	 * @return
	 */
	<INPUT> boolean isMatch(INPUT input);

	/**
	 * 转换消息（微信报文会出现不同类型报文字段一致的情况，需要根据上下文判断）
	 * 
	 * @param input
	 * @return
	 */
	<OUTPUT, INPUT> OUTPUT convert(INPUT input) throws WeChatSupportException;

}
