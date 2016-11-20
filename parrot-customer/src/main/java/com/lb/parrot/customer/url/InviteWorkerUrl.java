package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;



/**
 * 邀请绑定客服帐号
 * 新添加的客服帐号是不能直接使用的，只有客服人员用微信号绑定了客服账号后，方可登录Web客服进行操作。
 * 此接口发起一个绑定邀请到客服人员微信号，客服人员需要在微信客户端上用该微信号确认后帐号才可用。
 * 尚未绑定微信号的帐号可以进行绑定邀请操作，邀请未失效时不能对该帐号进行再次绑定微信号邀请。
 * 微信请求地址：https://api.weixin.qq.com/customservice/kfaccount/inviteworker?access_token=ACCESS_TOKEN
 *
 */
public class InviteWorkerUrl extends AbstractToServerUrl implements ToServerUrl{

	public InviteWorkerUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "inviteworker";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/customservice/kfaccount/inviteworker?access_token=#inviteworker.accessToken#";
	}

	public String getMethod() {
		return "post";
	}


}
