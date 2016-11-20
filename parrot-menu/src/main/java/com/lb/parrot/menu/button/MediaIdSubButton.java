package com.lb.parrot.menu.button;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.WeChatEventMode;

/**
 * media_id：下发消息（除文本消息）。用户点击media_id类型按钮后，微信服务器会将开发者填写的永久素材id对应的素材下发给用户，永久素材类型可以是图片、音频、视频、图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
 *
 */
public class MediaIdSubButton extends CommonSubButton{

	public MediaIdSubButton(){
		this(null,null);
	}
	
	public MediaIdSubButton(String name){
		this(name,null);
	}
	
    public MediaIdSubButton(String name,String mediaId){
		super(name, WeChatEventMode.MEDIA_ID.getEvent());
		this.mediaId = mediaId;
	}
	
    @JSONField(name="media_id")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	
}

