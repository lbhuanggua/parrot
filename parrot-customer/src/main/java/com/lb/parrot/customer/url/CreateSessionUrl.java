package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 创建会话
 * 此接口在客服和用户之间创建一个会话，如果该客服和用户会话已存在，则直接返回0。指定的客服帐号必须已经绑定微信号且在线。
 * http请求方式: POST
 * https://api.weixin.qq.com/customservice/kfsession/create?access_token=ACCESS_TOKEN
 */
public class CreateSessionUrl extends AbstractToServerUrl implements ToServerUrl{

	public CreateSessionUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "create";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/customservice/kfsession/create?access_token=#create.accessToken#";
	}

	public String getMethod() {
		return "post";
	}


}
