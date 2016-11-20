package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;



/**
 * 获取所有客服账号
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN
 *
 */
public class GetKfListUrl extends AbstractToServerUrl implements ToServerUrl{

	public GetKfListUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "getkflist";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/customservice/getkflist?access_token=#getkflist.accessToken#";
	}

	public String getMethod() {
		return "get";
	}

}
