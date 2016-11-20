package com.lb.parrot.support.message;

import com.alibaba.fastjson.annotation.JSONField;

public class UserOpenId {

	public UserOpenId(String openid) {
		super();
		this.openid = openid;
		this.lang = "zh_CN";
	}
	
	public UserOpenId(String openid, String lang) {
		super();
		this.openid = openid;
		this.lang = lang;
	}

	@JSONField(name = "openid")
	private String openid;

	/**
	 * 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
	 */
	@JSONField(name = "lang")
	private String lang;

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

}
