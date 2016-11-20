package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;


/**
 * 请求JS的临时票据
 */
public class GetTicketUrl extends AbstractToServerUrl implements ToServerUrl {
	
	public GetTicketUrl(String accessToken){
		super.setAccessToken(accessToken);
	}

	public String getKey() {
		return "ticket";
	}

	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=#ticket.accessToken#&type=jsapi";
	}

	public String getMethod() {
		return "get";
	}

}
