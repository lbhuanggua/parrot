package com.lb.parrot.apiproxy.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lb.parrot.apiproxy.message.api.WeChatTemplateBean;
import com.lb.parrot.template.message.SendTemplateMessage;
import com.lb.parrot.template.result.SendTemplateResult;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
	
	@Autowired WeChatTemplateBean weChatTemplateBean;
	
	@RequestMapping(value = "/template/send/{access_token}", method = { RequestMethod.POST })
	public SendTemplateResult send(
			@PathVariable(name = "access_token", required = true) String accessToken,
			@RequestBody(required = true) SendTemplateMessage message) {
		return weChatTemplateBean.send(accessToken, message);
	}

    
}
