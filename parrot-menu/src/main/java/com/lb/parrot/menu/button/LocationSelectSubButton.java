package com.lb.parrot.menu.button;

import com.lb.parrot.support.common.WeChatEventMode;


/**
 * location_select：弹出地理位置选择器。用户点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。
 *
 */
public class LocationSelectSubButton extends CommonSubButton{

	public LocationSelectSubButton(){
		this(null,null);
	}
	
	public LocationSelectSubButton(String name){
		this(name,null);
	}
	
    public LocationSelectSubButton(String name,String key){
		super(name,WeChatEventMode.LOCATION_SELECT.getEvent());
		this.key = key;
	}
	
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}

