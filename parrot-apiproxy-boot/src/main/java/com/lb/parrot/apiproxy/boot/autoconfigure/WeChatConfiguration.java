package com.lb.parrot.apiproxy.boot.autoconfigure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lb.parrot.support.WeChatClient;

@Configuration
public class WeChatConfiguration {

	@Bean()
	public WeChatClient weChatClient() {
		return new WeChatClient(appid, secret, token, encodeAseKey, mchId,
				payToken, checkSignature, checkIp, certPath, password, certType);
	}

	/**
	 * 微信的appid
	 */
	@Value("${parrot.wechat.appid}")
	private String appid;
	/**
	 * 微信的app秘钥
	 */
	@Value("${parrot.wechat.secret}")
	private String secret;
	/**
	 * 认证的token字符串
	 */
	@Value("${parrot.wechat.token}")
	private String token;
	/**
	 * 微信消息加密密钥
	 */
	@Value("${parrot.wechat.encodeAseKey}")
	private String encodeAseKey;
	/**
	 * 商户号
	 */
	@Value("${parrot.wechat.mchId}")
	private String mchId;
	/**
	 * 商户平台的key字符串
	 */
	@Value("${parrot.wechat.payToken}")
	private String payToken;
	/**
	 * HTTP是否强制检查签名
	 */
	@Value("${parrot.wechat.checkSignature}")
	private String checkSignature;
	/**
	 * 是否检查微信服务器ip
	 */
	@Value("${parrot.wechat.checkIp}")
	private String checkIp;
	/**
	 * 证书路径
	 */
	@Value("${parrot.wechat.certPath}")
	private String certPath;
	/**
	 * 验证密码
	 */
	@Value("${parrot.wechat.password}")
	private String password;
	/**
	 * 证书类型
	 */
	@Value("${parrot.wechat.certType}")
	private String certType;

}