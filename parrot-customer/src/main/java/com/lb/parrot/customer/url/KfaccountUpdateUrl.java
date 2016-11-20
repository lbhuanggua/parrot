package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;



/**
 * 修改客服帐号
 * 微信请求地址：https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN
 *
 */
public class KfaccountUpdateUrl extends AbstractToServerUrl implements ToServerUrl{

	public KfaccountUpdateUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "update";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=#update.accessToken#";
	}

	public String getMethod() {
		return "post";
	}


}
