package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 获取客服会话列表 http请求方式: GET
 * 微信请求地址：https://api.weixin.qq.com/customservice/kfsession
 * /getsessionlist?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT
 *
 */
public class GetSessionListUrl extends AbstractToServerUrl implements
		ToServerUrl {
	
	public GetSessionListUrl(String accessToken, String kfAccount){
		super.setAccessToken(accessToken);
		this.kfAccount = kfAccount;
	}
	
	/**
	 * 完整客服帐号，格式为：帐号前缀@公众号微信号
	 */
	private String kfAccount;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	public String getKey() {
		return "getsessionlist";
	}

	public String getUrl() {
		return "http://api.weixin.qq.com/customservice/kfsession/getsessionlist?access_token=#getsessionlist.accessToken#&kf_account=#getsessionlist.kfAccount#";
	}

	public String getMethod() {
		return "get";
	}


}
