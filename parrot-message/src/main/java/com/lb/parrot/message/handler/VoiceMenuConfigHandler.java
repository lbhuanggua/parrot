package com.lb.parrot.message.handler;

import com.lb.parrot.message.from.VoiceMessage;
import com.lb.parrot.message.result.TextReplyMessage;

/**
 * 微信菜单处理器(语音消息)
 * 
 */
public class VoiceMenuConfigHandler{

	protected <T> String getContent(T message) {
		VoiceMessage voiceMessage = (VoiceMessage) message;
		return voiceMessage.getRecognition();

	}

	@SuppressWarnings("unchecked")
	protected <T, OUTPUT> OUTPUT wrapperReplyMessage(T message, String content) {
		VoiceMessage voiceMessage = (VoiceMessage) message;
		
		TextReplyMessage replyMessage= new TextReplyMessage();
		replyMessage.setContent(content);
		replyMessage.setToUserName(voiceMessage.getFromUserName());
		replyMessage.setFromUserName(voiceMessage.getToUserName());
		return (OUTPUT)replyMessage;
	}

	protected <T> boolean isMatchType(T message) {
		return message instanceof VoiceMessage;
	}

}
