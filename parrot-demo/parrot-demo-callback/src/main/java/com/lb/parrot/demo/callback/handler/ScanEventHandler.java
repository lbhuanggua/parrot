package com.lb.parrot.demo.callback.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lb.parrot.message.event.ScanEvent;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.WeChatReceiver;
import com.lb.parrot.support.handler.AbstractWeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;

/**
 * 用户已关注时的事件推送
 *
 */
@Component
public class ScanEventHandler extends AbstractWeChatHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(ScanEventHandler.class);
	
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
		return message instanceof ScanEvent;
	}

	public <T> void process(T message, WeChatContext context) {
		ScanEvent event = (ScanEvent) message;
		LOGGER.info("用户已关注时的事件推送,key:{}", event.getEventKey());
	}
	
}
