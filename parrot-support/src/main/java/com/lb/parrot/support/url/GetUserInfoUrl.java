package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 获取用户基本信息（包括UnionID机制） 开发者可通过OpenID来获取用户基本信息。请使用https协议。 http请求方式: GET
 * https://
 * api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID
 * &lang=zh_CN
 * lang=返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
 */
public class GetUserInfoUrl extends AbstractToServerUrl implements ToServerUrl {

	/**
	 * 普通用户的标识，对当前公众号唯一
	 */
	private String openid;
	
	public GetUserInfoUrl(String accessToken ,String openid) {
		super.setAccessToken(accessToken);
		this.openid = openid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getKey() {
		return "info";
	}

	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/user/info?access_token=#info.accessToken#&openid=#info.openid#&lang=zh_CN";
	}

	public String getMethod() {
		return "get";
	}

}
