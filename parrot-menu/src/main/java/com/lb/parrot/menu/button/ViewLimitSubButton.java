package com.lb.parrot.menu.button;

import com.alibaba.fastjson.annotation.JSONField;
import com.lb.parrot.support.common.WeChatEventMode;

/**
 * view_limited：跳转图文消息URL。用户点击view_limited类型按钮后，微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL，永久素材类型只支持图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
 *
 */
public class ViewLimitSubButton extends CommonSubButton{

	public ViewLimitSubButton(){
		this(null,null);
	}
	
	public ViewLimitSubButton(String name){
		this(name,null);
	}
	
    public ViewLimitSubButton(String name,String mediaId){
		super(name,WeChatEventMode.VIEW_LIMITED.getEvent());
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
