package com.lb.parrot.support.bean;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.WeChatHttp;
import com.lb.parrot.support.WeChatHttpUpload;
import com.lb.parrot.support.WeChatSender;
import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.common.WeChatCert;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.handler.WeChatHandler;
import com.lb.parrot.support.handler.WeChatHandlerMode;
import com.lb.parrot.support.result.AccessToken;
import com.lb.parrot.support.result.JsApiTicket;
import com.lb.parrot.support.url.GetTicketUrl;
import com.lb.parrot.support.url.GetTokenUrl;
import com.lb.parrot.support.util.ParserUtil;
import com.lb.parrot.support.util.RendUtil;

/**
 * 
* <p>Title: 微信 API请求发送类</p>
* <p>Description: 微信 API请求发送类</p>
* @author lbhuanggua
* @date 2016年05月19日
 */
@Service
public class WeChatSenderDefault implements WeChatSender{

	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatSenderDefault.class);
	
	@Autowired
	private WeChatClient weChatClient;
	
	@Autowired
	private WeChatHttp weChatHttp;
	
	private List<WeChatHandler> sendHandlerList = new ArrayList<WeChatHandler>();
	
	public WeChatHttp getWeChatHttp() {
		return this.weChatHttp;
	}
	
	public List<WeChatHandler> getMatchWeChatHandlers(WeChatHandlerMode mode) {
		List<WeChatHandler> list = new ArrayList<WeChatHandler>();
		for (WeChatHandler handler : this.sendHandlerList) {
			if (handler.getWeChatHandlerMode() == mode) {
				list.add(handler);
			}
		}
		if(list.size()>0){
		   java.util.Collections.sort(list);
		}
		return list;
	}

	public void addSendHandler(WeChatHandler sendHandler) {
		this.sendHandlerList.add(sendHandler);
	}

	public void removeSendHandler(WeChatHandler sendHandler) {
		this.sendHandlerList.remove(sendHandler);
	}
	
	private void beforeExecute(WeChatContext context) throws WeChatSupportException{
		List<WeChatHandler> inputHandlers = getMatchWeChatHandlers(WeChatHandlerMode.SEND_INPUT);
		for (WeChatHandler handler : inputHandlers) {
			LOGGER.debug("beforeExecute mode={},handler={}, priority={}" ,handler.getWeChatHandlerMode(), handler.getClass().getName(), handler.getPriority());
			if (handler.isMatch(context.getInput(), context)) {
				handler.process(context.getInput(), context);
			}
		}
	}
	
	private void afterExecute(WeChatContext context) throws WeChatSupportException{
		List<WeChatHandler> outputHandlers = getMatchWeChatHandlers(WeChatHandlerMode.SEND_OUPUT);
		for (WeChatHandler handler : outputHandlers) {
			LOGGER.debug("afterExecute mode={},handler={}, priority={}" ,handler.getWeChatHandlerMode(), handler.getClass().getName(), handler.getPriority());
			if (handler.isMatch(context.getOutput(), context)) {
				handler.process(context.getOutput(), context);
			}
		}
	}

	public void send(ToServerUrl toUrl, WeChatContext context) throws WeChatSupportException {
		beforeExecute(context);
		execute(toUrl, context);
		afterExecute(context);
	}

	public void upload(WeChatHttpUpload upload, WeChatContext context) throws WeChatSupportException {
		context.setInput(upload);
		beforeExecute(context);
		afterExecute(context);
	}

	public synchronized AccessToken connect(WeChatClient client) {
		try{
			GetTokenUrl message = new GetTokenUrl();
			message.setAppid(client.getAppid());
			message.setSecret(client.getSecret());
			WeChatContext context = new WeChatContextDefault();
			execute(message, context);
			return (AccessToken) ParserUtil.parse((String)context.getOutput(), ConvertMode.SEND);
		}catch(Exception e){
			//忽略转换异常
			LOGGER.error("获取微信访问认证令牌发生异常:{}",e.getMessage(), e);
			return null;
		}
	}

	public synchronized JsApiTicket getJsApiTicket(GetTicketUrl ticket) {
		try{
			WeChatContext context = new WeChatContextDefault();
			execute(ticket, context);
			//LOGGER.debug("ticket = {}",context.getOutput());
			return (JsApiTicket) ParserUtil.parse((String)context.getOutput(), ConvertMode.SEND);
		}catch(Exception e){
			//忽略转换异常
			LOGGER.error("获取微信JS的临时票据发生异常:{}", e.getMessage(), e);
			return null;
		}
	}

	private void execute(ToServerUrl toUrl, WeChatContext context) throws WeChatSupportException{
		//URL渲染
		String url = RendUtil.rendUrl(toUrl);
		//访问微信服务器
		String result = null;
		if ("get".equalsIgnoreCase(toUrl.getMethod())) {
			result = getWeChatHttp().getUrl(url);
		} else if ("post".equalsIgnoreCase(toUrl.getMethod())) {
			if(context.getInput() instanceof WeChatHttpUpload){
				result = getWeChatHttp().upload(url, (WeChatHttpUpload) context.getInput());
			}else{
				if (toUrl.isCert()) {
					// 证书认证
					WeChatCert cert = new WeChatCert(weChatClient.getCertPath(), weChatClient.getPassword());
					result = getWeChatHttp().postUrl(url, context.getInput().toString(), cert);
					cert = null;
				} else {
					// 非加密访问
					result = getWeChatHttp().postUrl(url, context.getInput().toString());
				}
			}
		}else{
			LOGGER.error(String.format("未知的HTTP请求类型:[%s]", toUrl.getMethod()));
			throw new WeChatSupportException(String.format("未知的HTTP请求类型:[%s]", toUrl.getMethod()));
		}
		//处理结果参数
		context.setOutput(result);
	}
	
}
