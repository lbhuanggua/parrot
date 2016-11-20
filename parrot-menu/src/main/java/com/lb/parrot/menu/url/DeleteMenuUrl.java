package com.lb.parrot.menu.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 自定义菜单删除接口
 * 微信请求地址： https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN
 *
 */
public class DeleteMenuUrl extends AbstractToServerUrl implements ToServerUrl{

	public DeleteMenuUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "delete";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=#delete.accessToken#";
	}

	public String getMethod() {
		return "get";
	}


}
