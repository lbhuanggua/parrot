package com.lb.parrot.demo.callback.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lb.parrot.message.from.ImageMessage;
import com.lb.parrot.message.result.ImageReplyMessage;
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
public class ImageMessageHandler extends AbstractWeChatHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageMessageHandler.class);
	
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
		return message instanceof ImageMessage;
	}

	public <T> void process(T message, WeChatContext context) {
		ImageMessage mes = (ImageMessage) message;
		LOGGER.info("开发者微信号:{},接收方帐号:{},图片链接:{}", mes.getToUserName(), mes.getFromUserName(), mes.getPicUrl());
		ImageReplyMessage replyMessage= new ImageReplyMessage("OJEVhjsJ61fAZjYQwzUyJV_NXKOkEBmpffgKj_1kO_EI5ju2Rhc55kIZVHGjqyoF");
		replyMessage.setToUserName(mes.getFromUserName());
		replyMessage.setFromUserName(mes.getToUserName());
		context.setOutput(replyMessage);
		LOGGER.info("开发者微信号:{},接收方帐号:{},回复的消息内容:{}", replyMessage.getFromUserName(), replyMessage.getToUserName(), context.getOutput());
	}
	
}
