package com.lb.parrot.support.bean;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.WeChatReceiver;
import com.lb.parrot.support.exception.RepeatMessageException;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.handler.WeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;

/**
 * 
* <p>Title: 接收类</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
@Service
public class WeChatReceiverDefault implements WeChatReceiver{

	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatReceiverDefault.class);
	
	private List<WeChatHandler> receiverHandlerList = new ArrayList<WeChatHandler>();
	
	public void addReceiverHandler(WeChatHandler receiverHandler) {
		this.receiverHandlerList.add(receiverHandler);
	}

	public void removeReceiverHandler(WeChatHandler receiverHandler) {
		this.receiverHandlerList.remove(receiverHandler);
	}
	
	public List<WeChatHandler> getMatchWeChatHandlers(WeChatHandlerMode mode) {
		List<WeChatHandler> list = new ArrayList<WeChatHandler>();
		for (WeChatHandler handler : this.receiverHandlerList) {
			if (handler.getWeChatHandlerMode() == mode) {
				list.add(handler);
			}
		}
		if (list.size() > 0) {
		   java.util.Collections.sort(list);
		}
		return list;
	}

	public void receive(WeChatContext context) throws WeChatSupportException{
		List<WeChatHandler> dealHandlers = getMatchWeChatHandlers(WeChatHandlerMode.RECEIVE);
		try{
			for (WeChatHandler handler : dealHandlers) {
				LOGGER.debug("{}开始匹配消息", handler.getClass().getName());
				if(handler.isMatch(context.getInput(),context)){
					//LOGGER.debug("未处理消息:{}", context.getInput());
					handler.process(context.getInput(), context);
					//LOGGER.debug("已处理消息:{}", context.getInput());
				}
				LOGGER.debug("{}匹配消息结束", handler.getClass().getName());
			}
		}catch(RepeatMessageException e){
			//重复消息不用处理
			LOGGER.error(e.getMessage(), e);
		}
	}

}
