package com.lb.parrot.menu.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 自定义菜单查询接口
 * 微信请求地址： https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN
 *
 */
public class GetMenuUrl extends AbstractToServerUrl implements ToServerUrl{

	public GetMenuUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "get";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=#get.accessToken#";
	}

	public String getMethod() {
		return "get";
	}


}
