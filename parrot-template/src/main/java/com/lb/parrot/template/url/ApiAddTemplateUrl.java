package com.lb.parrot.template.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;


/**
 * 获得模板ID
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN
 * 文档地址：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1445241432&token=&lang=zh_CN
 */
public class ApiAddTemplateUrl extends AbstractToServerUrl implements ToServerUrl{

	public ApiAddTemplateUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "api_add_template";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=#api_add_template.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
