package com.lb.parrot.menu.button;

import com.lb.parrot.support.common.WeChatEventMode;



/**
 * view：跳转URL用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，可与网页授权获取用户基本信息接口结合，获得用户基本信息。
 *
 */
public class ViewSubButton extends CommonSubButton{

	public ViewSubButton(){
		this(null,null);
	}
	
	public ViewSubButton(String name){
		this(name,null);
	}
	
	public ViewSubButton(String name,String url){
		super(name,WeChatEventMode.VIEW.getEvent().toLowerCase());
		this.url = url;
	}
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
