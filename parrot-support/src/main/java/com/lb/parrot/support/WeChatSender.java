package com.lb.parrot.support;

import java.util.List;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.handler.WeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;
import com.lb.parrot.support.result.AccessToken;
import com.lb.parrot.support.result.JsApiTicket;
import com.lb.parrot.support.url.GetTicketUrl;

public interface WeChatSender {
	
	/**
	 * HTTP协议操作者
	 * @return
	 */
	WeChatHttp getWeChatHttp();
	
	/**
	 * 获取发送处理器
	 * @param mode
	 * @return
	 */
	List<WeChatHandler> getMatchWeChatHandlers(WeChatHandlerMode mode);
	
    /**
     * 增加发送处理器
     * @param sendHandler
     */
    void addSendHandler(WeChatHandler sendHandler);
    
    /**
     * 移除发送处理器
     * @param sendHandler
     */
    void removeSendHandler(WeChatHandler sendHandler);
    
    /**
	 * 发送微信消息
	 * @param message
	 */
    void send(ToServerUrl message, WeChatContext context) throws WeChatSupportException;
    
    /**
     * 上传微信文件
     * @param upload
     */
    void upload(WeChatHttpUpload upload, WeChatContext context) throws WeChatSupportException;
    
    /**
     * 取得微信认证
     * @param client
     */
    AccessToken connect(WeChatClient client);
    
    /**
     * 微信的js临时票据
     * @param ticket
     * @return
     */
    JsApiTicket getJsApiTicket(GetTicketUrl ticket);
}
