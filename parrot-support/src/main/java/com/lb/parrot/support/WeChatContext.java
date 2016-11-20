package com.lb.parrot.support;

import com.lb.parrot.support.context.Context;

/**
 * 
* <p>Title: 微信上下文</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public interface WeChatContext extends Context{
	
	public static final String DEFAULT_INPUT_NAME = "_default_wechat_input";

	public static final String DEFAULT_OUTPUT_NAME = "_default_wechat_output";
	
	/**
	 * 获取微信输入消息
	 * @param <INPUT>
	 * @return
	 */
	<INPUT> INPUT getInput();
	
	/**
	 * 设置微信输入消息
	 * @param <INPUT>
	 * @param input
	 */
	<INPUT> void setInput(INPUT input);
	
	/**
	 * 获取微信输出结果
	 * @param <OUTPUT>
	 * @return
	 */
	<OUTPUT> OUTPUT getOutput();
	
	/**
	 * 设置微信输出结果
	 * @param <OUTPUT>
	 * @param output
	 */
	<OUTPUT> void setOutput(OUTPUT output);
	
}
