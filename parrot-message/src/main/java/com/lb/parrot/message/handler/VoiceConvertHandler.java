package com.lb.parrot.message.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lb.parrot.message.from.VoiceMessage;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.WeChatReceiver;
import com.lb.parrot.support.bean.WeChatConnectorDefault;
import com.lb.parrot.support.convert.ConvertException;
import com.lb.parrot.support.convert.NumberConvert;
import com.lb.parrot.support.handler.AbstractWeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;

/**
 * 语音转换处理器<br>
 * 1. 语音回复去除标点符号<br>
 * 2. 语音为数字的转成阿拉伯数字 <br>
 *
 */
public class VoiceConvertHandler extends AbstractWeChatHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatConnectorDefault.class);
	
    private static final String[] FILTER_SYMBOL = new String[]{"!","！"};
    
    private NumberConvert numberConvert = new NumberConvert();
    
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
    
    public VoiceConvertHandler(){
    	this.setPriority(-100);
    }
    
	public WeChatHandlerMode getWeChatHandlerMode() {
		return WeChatHandlerMode.RECEIVE;
	}

	public <T> boolean isMatch(T message, WeChatContext context) {
		return message instanceof VoiceMessage;
	}

	public <T> void process(T message, WeChatContext context) {
		VoiceMessage voiceMessage = (VoiceMessage) message;
		if(voiceMessage.getRecognition()!=null){
		   String text = voiceMessage.getRecognition();
		   //过滤标点
		   for(String symbol:FILTER_SYMBOL){
			   text = text.replaceAll(symbol, "");
		   }
		   
		   try {
			  text = numberConvert.convert(text);
		   } catch (ConvertException e) {
			  //转换失败，记录日志
			  LOGGER.error("处理语音的文字转换发生异常,text:{0}", e, text);
		   }
		   voiceMessage.setRecognition(text);
		   context.setInput(voiceMessage);
		}
	}
    
}
