package com.lb.parrot.menu.button;

import com.lb.parrot.support.common.WeChatEventMode;


/**
 * scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框。用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后，将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息。
 *
 */
public class WaitMsgSubButton extends CommonSubButton{

	public WaitMsgSubButton(){
		this(null,null);
	}
	
	public WaitMsgSubButton(String name){
		this(name, null);
	}
	
    public WaitMsgSubButton(String name,String key){
		super(name, WeChatEventMode.SCANCODE_WAITMSG.getEvent());
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
