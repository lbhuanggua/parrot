package com.lb.parrot.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.result.AccessToken;
import com.lb.parrot.support.result.JsApiSignature;
import com.lb.parrot.support.result.JsApiTicket;

/**
 * 
* <p>Title: 微信统一管理器</p>
* <p>Description: 微信统一管理器</p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public interface WeChatConnector {
	
	/**
	 * 获取当前的管理号客户端信息
	 * @return
	 */
	WeChatClient  getWeChatClient();
    /**
     * 微信发送消息器，负责发送消息和上传文件到微信服务器，并处理响应，WeChatConnector委托其发送消息。
     * @return
     */
    WeChatSender getWeChatSender();
    /**
     * 微信接收消息器，负责接收微信服务器推送过来的消息和事件，WeChatConnector委托其接收消息。
     * @return
     */
	WeChatReceiver getWeChatReceiver();
	/**
	 * 获取微信验证令牌
	 * @return
	 */
	AccessToken getAccessToken();
	/**
	 * 获得微信的JS访问票据
	 * @return
	 */
	JsApiTicket getJsApiTicket();
	/**
	 * 获取H5签名
	 * @param appId
	 * @param url
	 * @return
	 * @throws WeChatSupportException
	 */
	JsApiSignature getJsApiSignature(String appId, String url) throws WeChatSupportException;
	/**
	 * 发送微信消息
	 * @param toUrl 微信请求对象
	 * @param context 请求上下文
	 */
    void send(ToServerUrl toUrl, WeChatContext context) throws WeChatSupportException;
    /**
     * 上传微信文件
     * @param upload
     */
    void upload(WeChatHttpUpload upload) throws WeChatSupportException;
	/**
	 * 接收微信消息
	 * @param request
	 * @param response
	 */
	void receive(HttpServletRequest request, HttpServletResponse response) throws WeChatSupportException;
	
}