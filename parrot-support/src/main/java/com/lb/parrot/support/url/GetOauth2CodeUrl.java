package com.lb.parrot.support.url;

import com.lb.parrot.support.common.Oauth2ScopeMode;
import com.lb.parrot.support.common.ToServerUrl;

/**
 * 第一步：用户同意授权，获取code
 * 在确保微信公众账号拥有授权作用域（scope参数）的权限的前提下（服务号获得高级接口后，默认拥有scope参数中的snsapi_base和snsapi_userinfo）
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
 * 尤其注意：跳转回调redirect_uri，应当使用https链接来确保授权code的安全性。
 */
public class GetOauth2CodeUrl extends AbstractToServerUrl implements ToServerUrl{

	/**
	 * 	公众号的唯一标识
	 */
	private String appid;
	/**
	 * 授权后重定向的回调链接地址，请使用urlencode对链接进行处理
	 */
	private String redirectUri;
	/**
	 * 应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
	 */
	private String scope;
	/**
	 * 重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
	 */
	private String state;
	
	public GetOauth2CodeUrl(String appid, String redirectUri, String state) {
		this.appid = appid;
		this.redirectUri = redirectUri;
		this.scope = Oauth2ScopeMode.SNSAPI_BASE.getScope();
		this.state = state;
	}
	
	public GetOauth2CodeUrl(String appid, String redirectUri, String scope, String state) {
		this.appid = appid;
		this.redirectUri = redirectUri;
		this.scope = scope;
		this.state = state;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getKey() {
		return "authorize";
	}

	public String getUrl() {
		return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=#authorize.appid#&redirect_uri=#authorize.redirectUri#&response_type=code&scope=#authorize.scope#&state=#authorize.state##wechat_redirect";
	}

	public String getMethod() {
		return "get";
	}

}
