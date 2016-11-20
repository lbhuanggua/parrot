package com.lb.parrot.template.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;


/**
 * 发送模板消息
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
 *
 */
public class SendTemplateUrl extends AbstractToServerUrl implements ToServerUrl{

	public SendTemplateUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "send";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=#send.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
