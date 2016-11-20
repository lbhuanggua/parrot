package com.lb.parrot.menu.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 删除个性化菜单
 * 微信请求地址： https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN
 *
 */
public class DelconditionalMenuUrl extends AbstractToServerUrl implements ToServerUrl{

	public DelconditionalMenuUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "delconditional";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=#delconditional.accessToken#";
	}

	public String getMethod() {
		return "post";
	}


}
