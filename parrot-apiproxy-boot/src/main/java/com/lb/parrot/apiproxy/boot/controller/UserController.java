package com.lb.parrot.apiproxy.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lb.parrot.apiproxy.user.api.WeChatUserBean;
import com.lb.parrot.support.result.UserInfoResult;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	WeChatUserBean weChatUserBean;

	@RequestMapping(value = "/get/{code}", method = { RequestMethod.GET,RequestMethod.POST })
	public UserInfoResult getByCode(
			@PathVariable(name = "code", required = true) String code) {
		return weChatUserBean.getUserInfoHtml(code);
	}

	@RequestMapping(value = "/qrcode/{access_token}", method = { RequestMethod.GET,RequestMethod.POST })
	public UserInfoResult send(
			@PathVariable(name = "access_token", required = true) String accessToken,
			@RequestParam(required = true) String openId) {
		return weChatUserBean.getUserInfo(accessToken, openId);
	}

}
