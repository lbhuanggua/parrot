package com.lb.parrot.message.from;

import com.lb.parrot.support.common.WeChatMessageMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图片消息
 *
 */
@XStreamAlias("xml")
public class ImageMessage extends CommonMessage{
	
	public ImageMessage(){
		setMsgType(WeChatMessageMode.IMAGE.getType());
	}

	@XStreamAlias("PicUrl")
	private String picUrl;
	
	@XStreamAlias("MediaId")
	private String mediaId;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
}
