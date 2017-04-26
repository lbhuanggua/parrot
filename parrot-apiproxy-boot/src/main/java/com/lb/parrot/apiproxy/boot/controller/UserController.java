package com.lb.parrot.apiproxy.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lb.parrot.apiproxy.user.api.WeChatUserBean;
import com.lb.parrot.support.result.Oauth2Token;
import com.lb.parrot.support.result.UserInfoResult;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired WeChatUserBean weChatUserBean;

	/**
	 * 网页授权->scope=snsapi_base,返回access_token
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getOauth2Token/{code}", method = { RequestMethod.GET})
	public Oauth2Token getOauth2Token(@PathVariable(name = "code", required = true) String code) {
		return weChatUserBean.getOauth2Token(code);
	}
	
	/**
	 * 网页授权->scope=snsapi_userinfo,返回userinfo
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getUserInfo/{code}", method = { RequestMethod.GET})
	public UserInfoResult getUserInfoByCode(
			@PathVariable(name = "code", required = true) String code) {
		return weChatUserBean.getUserInfo(code);
	}

	/**
	 * 通过OpenID和access_token获取用户信息
	 * @param code
	 * @param accessToken
	 * @return
	 */
	@RequestMapping(value = "/getUser/{access_token}/{openid}", method = { RequestMethod.GET})
	public UserInfoResult getUserInfoByCodeAndAccessToken(
			@PathVariable(name = "openid", required = true) String openid,
			@PathVariable(name = "access_token", required = true) String accessToken) {
		return weChatUserBean.getUser(accessToken, openid);
	}

}