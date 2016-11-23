package com.lb.parrot.demo.callback.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lb.parrot.message.from.TextMessage;
import com.lb.parrot.message.result.TextReplyMessage;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.WeChatReceiver;
import com.lb.parrot.support.handler.AbstractWeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;

/**
 * 接收消息-接收普通消息
 * 发送消息-被动回复消息
 *
 */
@Component
public class TextMessageHandler extends AbstractWeChatHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(TextMessageHandler.class);
	
	@Autowired
	WeChatReceiver weChatReceiver;

	@PostConstruct  
	public void init() {   
		weChatReceiver.addReceiverHandler(this);
	}   
	
	@PreDestroy  
	public void destory() {  
		weChatReceiver.removeReceiverHandler(this);
	}   
	
	public WeChatHandlerMode getWeChatHandlerMode() {
		return WeChatHandlerMode.RECEIVE;
	}

	public <T> boolean isMatch(T message, WeChatContext context) {
		return message instanceof TextMessage;
	}

	public <T> void process(T message, WeChatContext context) {
		TextMessage textMessage = (TextMessage) message;
		LOGGER.debug("开发者微信号:{},发送方帐号:{},接收消息内容:{}", textMessage.getToUserName(), textMessage.getFromUserName(), textMessage.getContent());
		if(textMessage.getContent() != null){
			TextReplyMessage textReplyMessage= new TextReplyMessage();
			if(textMessage.getContent().trim().equals("1")){
				textReplyMessage.setContent("还你1");
				textReplyMessage.setToUserName(textMessage.getFromUserName());
				textReplyMessage.setFromUserName(textMessage.getToUserName());
			}
			LOGGER.debug("开发者微信号:{},发送方帐号:{},回复内容:{}", textReplyMessage.getFromUserName(), textReplyMessage.getToUserName(), textReplyMessage.getContent());
			context.setOutput(textReplyMessage);
		}
	}
	
}
