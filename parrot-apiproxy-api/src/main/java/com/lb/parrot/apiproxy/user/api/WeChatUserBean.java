package com.lb.parrot.apiproxy.user.api;

import com.lb.parrot.support.exception.WeChatUserException;
import com.lb.parrot.support.result.Oauth2Token;
import com.lb.parrot.support.result.UserInfoResult;

public interface WeChatUserBean {
	
	/**
	 * scope=snsapi_base 获取Oauth2Token
	 * @param code
	 * @return
	 * @throws WeChatUserException
	 */
	Oauth2Token getOauth2Token(String code) throws WeChatUserException;
	/**
	 * 网页授权获取用户信息
	 * @param code
	 * @return
	 */
	UserInfoResult getUserInfo(String code) throws WeChatUserException;
	/**
	 * 根据ipenid获取用户信息
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	UserInfoResult getUser(String accessToken, String openId) throws WeChatUserException;
	
}
