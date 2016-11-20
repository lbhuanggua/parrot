package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;



/**
 * 删除客服帐号
 * 微信请求地址：https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT
 *
 */
public class KfaccountDelUrl extends AbstractToServerUrl implements ToServerUrl{

	public KfaccountDelUrl(String accessToken,String kfAccount){
		super.setAccessToken(accessToken);
		this.kfAccount = kfAccount;
	}
	
	private  String kfAccount;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}
	
	public String getKey() {
		return "del";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=#del.accessToken#&kf_account=#del.kfAccount#";
	}

	public String getMethod() {
		return "post";
	}


}
