package com.lb.parrot.apiproxy.support.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.parrot.apiproxy.support.api.WeChatAccessTokenBean;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.result.AccessToken;
import com.lb.parrot.support.result.JsApiSignature;
import com.lb.parrot.support.result.JsApiTicket;

@Service("weChatAccessTokenBean")
public class WeChatAccessTokenBeanImpl implements WeChatAccessTokenBean{
	
	@Autowired
	WeChatClient weChatClient;
	
	@Autowired
	WeChatConnector weChatConnector;

	@Override
	public AccessToken getAccessToken() {
		return weChatConnector.getAccessToken();
	}

	@Override
	public JsApiTicket getJsApiTicket() {
		return weChatConnector.getJsApiTicket();
	}

	@Override
	public JsApiSignature getJsApiSignature(String url) {
		return weChatConnector.getJsApiSignature(weChatClient.getAppid(), url);
	}

}
