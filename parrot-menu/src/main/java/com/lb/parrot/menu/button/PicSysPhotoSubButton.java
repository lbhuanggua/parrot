package com.lb.parrot.menu.button;

import com.lb.parrot.support.common.WeChatEventMode;


/**
 * pic_sysphoto：弹出系统拍照发图。用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，会将拍摄的相片发送给开发者，并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
 *
 */
public class PicSysPhotoSubButton extends CommonSubButton{

	public PicSysPhotoSubButton(){
		this(null,null);
	}
	
	public PicSysPhotoSubButton(String name){
		this(name,null);
	}
	
    public PicSysPhotoSubButton(String name,String key){
		super(name,WeChatEventMode.PIC_SYSPHOTO.getEvent());
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
