package com.lb.parrot.menu.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 创建个性化菜单
 * 微信请求地址： https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN
 *
 */
public class AddconditionalMenuUrl extends AbstractToServerUrl implements ToServerUrl{

	public AddconditionalMenuUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "addconditional";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=#addconditional.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
