package com.lb.parrot.template.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;


/**
 * 获取模板列表
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN
 *
 */
public class GetAllPrivateTemplateUrl extends AbstractToServerUrl implements ToServerUrl{

	public GetAllPrivateTemplateUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "get_all_private_template";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=#get_all_private_template.accessToken#";
	}

	public String getMethod() {
		return "get";
	}

}
