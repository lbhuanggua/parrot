package com.lb.parrot.template.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;


/**
 * 获取设置的行业信息
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN
 *
 */
public class GetIndustryUrl extends AbstractToServerUrl implements ToServerUrl{

	public GetIndustryUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "get_industry";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=#get_industry.accessToken#";
	}

	public String getMethod() {
		return "get";
	}

}
