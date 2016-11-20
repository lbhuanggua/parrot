package com.lb.parrot.support.common;

/**
 * 
* <p>Title: 应用授权作用域</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public enum Oauth2ScopeMode {

	/**
	 * 不弹出授权页面，直接跳转，只能获取用户openid
	 */
	SNSAPI_BASE("snsapi_base"),
	/**
	 * 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息
	 */
	SNSAPI_USERINFO("snsapi_userinfo");


	private final String scope;

	private Oauth2ScopeMode(String scope) {
		this.scope = scope;
	}

	public String getScope() {
		return scope;
	}

}
