package com.lb.parrot.pay.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lb.parrot.pay.common.PaySignature;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.WeChatSender;
import com.lb.parrot.support.handler.AbstractWeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;
import com.lb.parrot.support.util.StringUtil;

/**
 * 
* <p>Title: 支付自动签名处理器</p>
* <p>Description: 支付自动签名处理器</p>
* @author lbhuanggua
* @date 2016年10月19日
 */
@Component
public class CreateSignatureHandler extends AbstractWeChatHandler{

	@Autowired
	WeChatClient weChatClient;
	
	@Autowired
	WeChatSender weChatSender;

	
	@PostConstruct  
	public void init() {   
		weChatSender.addSendHandler(this);
	}   
	
	@PreDestroy  
	public void destory() {  
		weChatSender.removeSendHandler(this);
	}   

	public WeChatHandlerMode getWeChatHandlerMode() {
		return WeChatHandlerMode.SEND_INPUT;
	}

	public <T> boolean isMatch(T message, WeChatContext context) {
		return message instanceof PaySignature;
	}

	public <T> void process(T message, WeChatContext context) {
		PaySignature signature = (PaySignature) message;
		if(StringUtil.isEmpty(signature.getSignature())){
			String sign = signature.createSignature(weChatClient.getPayToken());
			signature.setSignature(sign);
			context.setInput(signature);
		}
	}
}
