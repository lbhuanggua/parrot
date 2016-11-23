package com.lb.parrot.demo.callback.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lb.parrot.message.event.SubscribeEvent;
import com.lb.parrot.message.result.TextReplyMessage;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.WeChatReceiver;
import com.lb.parrot.support.handler.AbstractWeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;

/**
 * 用户未关注时，进行关注后的事件推送
 *
 */
@Component
public class SubscribeEventHandler extends AbstractWeChatHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(SubscribeEventHandler.class);
	
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
		return message instanceof SubscribeEvent;
	}

	public <T> void process(T message, WeChatContext context) {
		SubscribeEvent event = (SubscribeEvent) message;
		TextReplyMessage textReplyMessage= new TextReplyMessage();
		LOGGER.info("EventKey:{},Ticket:{}", event.getEventKey(), event.getTicket());
		textReplyMessage.setContent("content");
		textReplyMessage.setFromUserName(event.getToUserName());
		textReplyMessage.setToUserName(event.getFromUserName());
		context.setOutput(textReplyMessage);
		LOGGER.info("开发者微信号:{},接收方帐号:{},回复的消息内容:{}", textReplyMessage.getFromUserName(), textReplyMessage.getToUserName(), textReplyMessage.getContent());
	}
	
}
