package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;

/**
 * 第二步：通过code换取网页授权access_token
 * 首先请注意，这里通过code换取的是一个特殊的网页授权access_token,与基础支持中的access_token（该access_token用于调用其他接口）不同。公众号可通过下述接口来获取网页授权access_token。如果网页授权的作用域为snsapi_base，则本步骤中获取到网页授权access_token的同时，也获取到了openid，snsapi_base式的网页授权流程即到此为止。
 * 尤其注意：由于公众号的secret和获取到的access_token安全级别都非常高，必须只保存在服务器，不允许传给客户端。后续刷新access_token、通过access_token获取用户信息等步骤，也必须从服务器发起。
 * https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
 */
public class GetOauth2TokenUrl extends AbstractToServerUrl implements ToServerUrl{
	
	/**
	 * 	公众号的唯一标识
	 */
	private String appid;
	/**
	 * 公众号的appsecret
	 */
	private String secret;
	/**
	 * 填写第一步获取的code参数
	 */
	private String code;
	
	public GetOauth2TokenUrl(String appid, String secret, String code) {
		super();
		this.appid = appid;
		this.secret = secret;
		this.code = code;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getKey() {
		return "access_token";
	}

	public String getUrl() {
		return "https://api.weixin.qq.com/sns/oauth2/access_token?appid=#access_token.appid#&secret=#access_token.secret#&code=#access_token.code#&grant_type=authorization_code";
	}

	public String getMethod() {
		return "get";
	}

}
