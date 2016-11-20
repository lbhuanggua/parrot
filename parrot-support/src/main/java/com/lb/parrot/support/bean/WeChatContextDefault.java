package com.lb.parrot.support.bean;

import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.context.impl.ContextImpl;

/**
 * 
* <p>Title: 默认的微信上下文实现</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public class WeChatContextDefault extends ContextImpl implements WeChatContext {

	private static final long serialVersionUID = 1L;

	public <INPUT> INPUT getInput() {
		return get(DEFAULT_INPUT_NAME);
	}

	public <OUTPUT> OUTPUT getOutput() {
		return get(DEFAULT_OUTPUT_NAME);
	}

	public <INPUT> void setInput(INPUT input) {
		put(DEFAULT_INPUT_NAME, input);
	}

	public <OUTPUT> void setOutput(OUTPUT output) {
		put(DEFAULT_OUTPUT_NAME, output);
	}

}
