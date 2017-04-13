package com.lb.parrot.token.autoconfigure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lb.parrot.support.WeChatClient;

@Configuration
public class WeChatConfiguration {

	@Value("${parrot.wechat.appid}")
	private String appid;
	@Value("${parrot.wechat.secret}")
	private String secret;

	@Bean()
	public WeChatClient weChatClient() {
		return new WeChatClient(appid, secret);
	}

}