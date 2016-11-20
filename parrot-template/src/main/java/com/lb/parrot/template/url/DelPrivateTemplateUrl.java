package com.lb.parrot.template.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;


/**
 * 删除模板
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN
 *
 */
public class DelPrivateTemplateUrl extends AbstractToServerUrl implements ToServerUrl{

	public DelPrivateTemplateUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "del_private_template";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=#del_private_template.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
