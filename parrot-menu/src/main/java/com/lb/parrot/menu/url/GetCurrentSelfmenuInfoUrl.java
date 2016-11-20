package com.lb.parrot.menu.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 获取自定义菜单配置接口
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN
 *
 */
public class GetCurrentSelfmenuInfoUrl extends AbstractToServerUrl implements ToServerUrl{

	public GetCurrentSelfmenuInfoUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "get_current_selfmenu_info";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=#get_current_selfmenu_info.accessToken#";
	}

	public String getMethod() {
		return "get";
	}


}
