package com.lb.parrot.apiproxy.template.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lb.parrot.apiproxy.support.api.WeChatAccessTokenBean;
import com.lb.parrot.apiproxy.template.api.WeChatTemplateBean;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.bean.WeChatContextDefault;
import com.lb.parrot.support.exception.WeChatUserException;
import com.lb.parrot.template.exception.WeChatTemplateException;
import com.lb.parrot.template.message.SendTemplateMessage;
import com.lb.parrot.template.result.SendTemplateResult;
import com.lb.parrot.template.url.SendTemplateUrl;

@Service("weChatTemplateBean")
public class WeChatTemplateBeanImpl implements WeChatTemplateBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatTemplateBeanImpl.class);
	
	@Autowired
	WeChatConnector weChatConnector;
	
	@Autowired
	WeChatClient weChatClient;
	
	@Autowired
	WeChatAccessTokenBean weChatAccessTokenBean;

	@Override
	public SendTemplateResult send(SendTemplateMessage message) throws WeChatTemplateException {
		LOGGER.debug("模板消息>>>接收表单：{}", message.toString());
		String accessToken = weChatAccessTokenBean.getAccessToken().getAccessToken();
		SendTemplateUrl toUrl = new SendTemplateUrl(accessToken);
		LOGGER.debug("模板消息>>>AccessToken：{}", toUrl.getAccessToken());
		WeChatContext context = new WeChatContextDefault();
		context.setInput(message);
		weChatConnector.send(toUrl, context);
		LOGGER.debug("模板消息>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		SendTemplateResult result = JSON.parseObject((String) context.getOutput(), SendTemplateResult.class);
		if (!result.getErrCode().equals("0")) {
			LOGGER.error("模板消息>>>出错：code:{}, msg：{}", result.getErrCode(), result.getErrMsg());
			throw new WeChatUserException( result.getErrCode(), result.getErrMsg());
		}		
		return result;
	}

}
