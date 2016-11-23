package com.lb.parrot.demo.callback.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lb.parrot.message.event.ViewEvent;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.WeChatReceiver;
import com.lb.parrot.support.handler.AbstractWeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;

/**
 * 自定义菜单事件<br>
 * 点击菜单跳转链接时的事件推送
 *
 */
@Component
public class ViewEventHandler extends AbstractWeChatHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ViewEventHandler.class);

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
		return message instanceof ViewEvent;
	}

	public <T> void process(T message, WeChatContext context) {
		ViewEvent event = (ViewEvent) message;
		LOGGER.info("用户微信OPENID:{},回复的消息内容:{}", event.getFromUserName(), event.getEventKey());
	}

}
