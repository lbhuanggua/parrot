package com.lb.parrot.message.handler;

import com.lb.parrot.message.from.TextMessage;
import com.lb.parrot.message.result.TextReplyMessage;

/**
 * 微信菜单处理器(文本消息)
 *
 */
public class TextMenuConfigHandler {

	protected <T> String getContent(T message) {
		TextMessage textMessage = (TextMessage) message;
		return textMessage.getContent();
	}

	@SuppressWarnings("unchecked")
	protected <T, OUTPUT> OUTPUT wrapperReplyMessage(
			T message, String content) {
		TextMessage textMessage = (TextMessage) message;
		
		TextReplyMessage replyMessage= new TextReplyMessage();
		replyMessage.setContent(content);
		replyMessage.setToUserName(textMessage.getFromUserName());
		replyMessage.setFromUserName(textMessage.getToUserName());
		return (OUTPUT)replyMessage;
	}

	protected <T> boolean isMatchType(T message) {
		return message instanceof TextMessage;
	}

}
