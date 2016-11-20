package com.lb.parrot.apiproxy.template.api;

import com.lb.parrot.template.exception.WeChatTemplateException;
import com.lb.parrot.template.message.SendTemplateMessage;
import com.lb.parrot.template.result.SendTemplateResult;

public interface WeChatTemplateBean {
	
	/**
	 * 发送模板消息
	 * @param message
	 * @return
	 * @throws WeChatTemplateException
	 */
	SendTemplateResult send(SendTemplateMessage message) throws WeChatTemplateException;

}
