package com.lb.parrot.demo.callback.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lb.parrot.message.event.LocationEvent;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.WeChatReceiver;
import com.lb.parrot.support.handler.AbstractWeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;

@Component
public class LocationEventHandler extends AbstractWeChatHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(LocationEventHandler.class);
	
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
		return message instanceof LocationEvent;
	}

	public <T> void process(T message, WeChatContext context) {
		LocationEvent event = (LocationEvent) message;
		LOGGER.debug("开发者微信号:{},发送方帐号:{},纬度:{},经度:{},精度:{}", event.getFromUserName(), event.getToUserName(), event.getLatitude(), event.getLongitude(), event.getPrecision());
	}
	
}
