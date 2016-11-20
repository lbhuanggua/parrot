package com.lb.parrot.material.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;


/**
 * 获取素材总数
 * 开发者可以根据本接口来获取永久素材的列表，需要时也可保存到本地
 * 1.永久素材的总数，也会计算公众平台官网素材管理中的素材
 * 2.图片和图文消息素材（包括单图文和多图文）的总数上限为5000，其他素材的总数上限为1000
 * 3.调用该接口需https协议
 * 微信请求地址：https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN
 *
 */
public class GetMaterialCountUrl extends AbstractToServerUrl implements ToServerUrl{

	public GetMaterialCountUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "get_materialcount";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=#get_materialcount.accessToken#";
	}

	public String getMethod() {
		return "get";
	}

}
