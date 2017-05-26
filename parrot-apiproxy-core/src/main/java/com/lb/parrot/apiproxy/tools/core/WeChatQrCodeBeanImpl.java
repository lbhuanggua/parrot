package com.lb.parrot.apiproxy.tools.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lb.parrot.apiproxy.tools.api.WeChatQrCodeBean;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.bean.WeChatContextDefault;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.message.QrcodeCreateMessage;
import com.lb.parrot.support.result.QrcodeResult;
import com.lb.parrot.support.url.QrcodeCreateUrl;

@Service("weChatQrCodeBean")
public class WeChatQrCodeBeanImpl implements WeChatQrCodeBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatQrCodeBeanImpl.class);
	
	@Autowired
	WeChatConnector weChatConnector;
	
	@Override
	public QrcodeResult createTempQrCode(String accessToken, QrcodeCreateMessage message) throws WeChatSupportException {
		LOGGER.debug("帐号管理>>>接收业务表单：{}", message.toString());
		QrcodeCreateUrl toUrl = new QrcodeCreateUrl(accessToken);
		WeChatContext context = new WeChatContextDefault();
		context.setInput(message);
		weChatConnector.send(toUrl, context);
		LOGGER.debug("帐号管理>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		return JSON.parseObject((String) context.getOutput(), QrcodeResult.class);
	}

}