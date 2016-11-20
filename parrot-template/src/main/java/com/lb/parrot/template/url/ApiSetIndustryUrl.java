package com.lb.parrot.template.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;


/**
 * 设置所属行业
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN
 *
 */
public class ApiSetIndustryUrl extends AbstractToServerUrl implements ToServerUrl{

	public ApiSetIndustryUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "api_set_industry";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=#api_set_industry.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
