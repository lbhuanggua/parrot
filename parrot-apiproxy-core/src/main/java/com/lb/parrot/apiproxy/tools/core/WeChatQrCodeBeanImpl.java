package com.lb.parrot.apiproxy.tools.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.parrot.apiproxy.tools.api.WeChatQrCodeBean;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.bean.WeChatContextDefault;
import com.lb.parrot.support.common.ToServerResult;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.message.QrcodeCreateMessage;
import com.lb.parrot.support.result.ErrorResult;
import com.lb.parrot.support.result.QrcodeResult;
import com.lb.parrot.support.url.QrcodeCreateUrl;
import com.lb.parrot.support.util.ParserUtil;

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
		weChatConnector.send(toUrl, context);
		LOGGER.debug("帐号管理>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		ToServerResult toServerResult = ParserUtil.parse((String)context.getOutput(), ConvertMode.SEND);
		if (toServerResult instanceof ErrorResult) {
			ErrorResult err = (ErrorResult) toServerResult;
			LOGGER.error("帐号管理>>>出错：code:{}, msg：{}", err.getErrCode(), err.getErrMsg());
			throw new WeChatSupportException(err.getErrCode(), err.getErrMsg());
		}
		return (QrcodeResult) toServerResult;
	}

	
}
