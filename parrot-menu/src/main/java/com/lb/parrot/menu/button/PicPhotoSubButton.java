package com.lb.parrot.menu.button;

import com.lb.parrot.support.common.WeChatEventMode;


/**
 * pic_photo_or_album：弹出拍照或者相册发图。用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。用户选择后即走其他两种流程。
 *
 */
public class PicPhotoSubButton extends CommonSubButton{

	public PicPhotoSubButton(){
		this(null,null);
	}
	
	public PicPhotoSubButton(String name){
		this(name,null);
	}
	
    public PicPhotoSubButton(String name,String key){
		super(name, WeChatEventMode.PIC_PHOTO_OR_ALBUM.getEvent());
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

