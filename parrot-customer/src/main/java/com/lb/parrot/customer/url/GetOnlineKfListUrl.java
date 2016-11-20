package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;



/**
 * 获取在线客服列表
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=ACCESS_TOKEN
 *
 */
public class GetOnlineKfListUrl extends AbstractToServerUrl implements ToServerUrl{

	public GetOnlineKfListUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "getonlinekflist";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/customservice/getonlinekflist?access_token=#getonlinekflist.accessToken#";
	}

	public String getMethod() {
		return "get";
	}


}
