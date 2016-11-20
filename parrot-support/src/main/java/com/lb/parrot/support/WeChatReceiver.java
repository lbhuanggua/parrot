package com.lb.parrot.support;

import java.util.List;

import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.handler.WeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;
/**
 * 
* <p>Title: </p>
* <p>Description: 接收类 </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public interface WeChatReceiver {
	
	/**
	 * 获取接收处理器
	 * @param mode
	 * @return
	 */
	List<WeChatHandler> getMatchWeChatHandlers(WeChatHandlerMode mode);
	
	 /**
     * 增加接收处理器
     * @param receiverHandler
     */
    void addReceiverHandler(WeChatHandler receiverHandler);
    
    /**
     * 移除接收处理器
     * @param receiverHandler
     */
    void removeReceiverHandler(WeChatHandler receiverHandler);

	/**
	 * 接收微信消息
	 * 
	 * @param context
	 */
	void receive(WeChatContext context) throws WeChatSupportException;
}
