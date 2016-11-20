package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;



/**
 * 添加客服帐号
 * 微信请求地址：https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN
 *
 */
public class KfaccountAddUrl extends AbstractToServerUrl implements ToServerUrl{

	public KfaccountAddUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "add";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=#add.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
