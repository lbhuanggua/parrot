package com.lb.parrot.apiproxy.user.api;

import com.lb.parrot.support.exception.WeChatUserException;
import com.lb.parrot.support.result.UserInfoResult;

public interface WeChatUserBean {
	
	/**
	 * 网页授权获取用户信息
	 * @param code
	 * @return
	 */
	UserInfoResult getUserInfoHtml(String code) throws WeChatUserException;
	
	/**
	 * 根据ipenid获取用户信息
	 * @param openId
	 * @return
	 */
	UserInfoResult getUserInfo(String openId) throws WeChatUserException;
	
}
