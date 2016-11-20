package com.lb.parrot.support.url;

import com.lb.parrot.support.common.ToServerUrl;

/**
 * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
 *
 */
public class QrcodeCreateUrl extends AbstractToServerUrl implements ToServerUrl{

	public QrcodeCreateUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "qrcode_create";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=#qrcode_create.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
