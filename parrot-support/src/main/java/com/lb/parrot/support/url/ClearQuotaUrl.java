package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;

/**
 * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/clear_quota?access_token=ACCESS_TOKEN
 *
 */
public class ClearQuotaUrl extends AbstractToServerUrl implements ToServerUrl{

	public ClearQuotaUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "clear_quota";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/clear_quota?access_token=#clear_quota.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
