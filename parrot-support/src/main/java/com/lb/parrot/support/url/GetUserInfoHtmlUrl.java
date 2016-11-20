package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;

/**
 * 第四步：拉取用户信息(需scope为 snsapi_userinfo)
 * 如果网页授权作用域为snsapi_userinfo，则此时开发者可以通过access_token和openid拉取用户信息了。
 * https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN  
 */
public class GetUserInfoHtmlUrl extends AbstractToServerUrl implements ToServerUrl{
	/**
	 * 	用户的唯一标识
	 */
	private String openid;
	/**
	 * 	返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 */
	private String lang;
	
	public GetUserInfoHtmlUrl(String accessToken ,String openid) {
		super.setAccessToken(accessToken);
		this.openid = openid;
		this.lang = "zh_CN";
	}

	public GetUserInfoHtmlUrl(String accessToken, String openid, String lang) {
		super.setAccessToken(accessToken);
		this.openid = openid;
		this.lang = lang;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getKey() {
		return "userinfo_access_token";
	}

	public String getUrl() {
		return "https://api.weixin.qq.com/sns/userinfo?access_token=#userinfo_access_token.accessToken#&openid=#userinfo_access_token.openid#&lang=#userinfo_access_token.lang#";
	}

	public String getMethod() {
		return "get";
	}


}
