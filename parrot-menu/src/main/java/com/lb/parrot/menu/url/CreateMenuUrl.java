package com.lb.parrot.menu.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 自定义菜单创建接口
 * 微信请求地址： https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
 *
 */
public class CreateMenuUrl extends AbstractToServerUrl implements ToServerUrl{

	public CreateMenuUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "create";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=#create.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
