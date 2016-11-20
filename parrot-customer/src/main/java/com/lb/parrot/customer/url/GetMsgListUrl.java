package com.lb.parrot.customer.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 获取聊天记录
 * 此接口返回的聊天记录中，对于图片、语音、视频，分别展示成文本格式的[image]、[voice]、[video]。对于较可能包含重要信息的图片消息，后续将提供图片拉取URL，近期将上线。
 * https://api.weixin.qq.com/customservice/msgrecord/getmsglist?access_token=ACCESS_TOKEN
 */
public class GetMsgListUrl extends AbstractToServerUrl implements ToServerUrl{

	public GetMsgListUrl(String accessToken){
		super.setAccessToken(accessToken);
	}
	
	public String getKey() {
		return "getmsglist";
	}
	
	public String getUrl() {
		return "https://api.weixin.qq.com/customservice/msgrecord/getmsglist?access_token=#close.accessToken#";
	}

	public String getMethod() {
		return "post";
	}

}
