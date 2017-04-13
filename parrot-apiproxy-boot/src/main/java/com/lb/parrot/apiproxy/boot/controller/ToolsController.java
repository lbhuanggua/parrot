package com.lb.parrot.apiproxy.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lb.parrot.apiproxy.tools.api.WeChatQrCodeBean;
import com.lb.parrot.support.message.QrcodeCreateMessage;
import com.lb.parrot.support.result.QrcodeResult;

@RestController
@RequestMapping(value = "/tools")
public class ToolsController {
	
	@Autowired WeChatQrCodeBean weChatQrCodeBean;
	
	@RequestMapping(value = "/qrcode/{access_token}", method = { RequestMethod.POST })
	public QrcodeResult send(
			@PathVariable(name = "access_token", required = true) String accessToken,
			@RequestBody(required = true) QrcodeCreateMessage message) {
		return weChatQrCodeBean.createTempQrCode(accessToken, message);
	}
    
}
