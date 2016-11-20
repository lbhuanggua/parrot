package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * TODO 暂未实现上传头像
 * 调用示例（使用curl命令，用FORM表单方式上传一个多媒体文件）：
 * curl -F media=@test.jpg "https://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT"
 * http请求方式: POST/FORM
 * 上传客服头像
 * 微信请求地址：http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT
 *
 */
public class UploadheadimgUrl extends AbstractToServerUrl implements
		ToServerUrl {

	public UploadheadimgUrl(String accessToken,String kfAccount){
		super.setAccessToken(accessToken);
		this.kfAccount = kfAccount;
	}
	
	private String kfAccount;

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	public String getKey() {
		return "uploadheadimg";
	}

	public String getUrl() {
		return "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=#uploadheadimg.accessToken#&kf_account=#uploadheadimg.kfAccount#";
	}

	public String getMethod() {
		return "post";
	}

}
