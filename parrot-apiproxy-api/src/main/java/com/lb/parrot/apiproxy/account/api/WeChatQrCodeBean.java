package com.lb.parrot.apiproxy.account.api;

import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.message.QrcodeCreateMessage;
import com.lb.parrot.support.result.QrcodeResult;

public interface WeChatQrCodeBean {
	
	/**
	 * 创建临时二维码ticket
	 * @param message
	 * @return
	 * @throws WeChatSupportException
	 */
	QrcodeResult createTempQrCode(QrcodeCreateMessage message) throws WeChatSupportException;
	
}