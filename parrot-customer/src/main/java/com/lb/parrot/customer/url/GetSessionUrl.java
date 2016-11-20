package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 获取客户会话状态
 * 此接口获取一个客户的会话，如果不存在，则kf_account为空。
 * http请求方式: GET
 * https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=ACCESS_TOKEN
 */
public class GetSessionUrl extends AbstractToServerUrl implements ToServerUrl{

	public GetSessionUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "getsession";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=#getsession.accessToken#";
	}

	public String getMethod() {
		return "get";
	}

}
