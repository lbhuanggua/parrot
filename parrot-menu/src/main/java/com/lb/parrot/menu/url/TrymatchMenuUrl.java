package com.lb.parrot.menu.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 测试个性化菜单匹配结果
 * 微信请求地址： https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN
 *
 */
public class TrymatchMenuUrl extends AbstractToServerUrl implements ToServerUrl{

	public TrymatchMenuUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "trymatch";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=#addconditional.accessToken#";
	}

	public String getMethod() {
		return "post";
	}


}
