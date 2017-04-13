package com.lb.parrot.apiproxy.message.api;

import com.lb.parrot.template.exception.WeChatTemplateException;
import com.lb.parrot.template.message.SendTemplateMessage;
import com.lb.parrot.template.result.SendTemplateResult;

public interface WeChatTemplateBean {

	/**
	 * 发送模板消息
	 * @param accessToken
	 * @param message
	 * @return
	 * @throws WeChatTemplateException
	 */
	SendTemplateResult send(String accessToken, SendTemplateMessage message) throws WeChatTemplateException;

}
