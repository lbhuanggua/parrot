package com.lb.parrot.message.from;

import com.lb.parrot.support.common.WeChatMessageMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 小视频消息
 * @author lbhuanggua
 *
 */
@XStreamAlias("xml")
public class ShortVideoMessage extends CommonMessage{
	
	public ShortVideoMessage(){
		setMsgType(WeChatMessageMode.SHORT_VIDEO.getType());
	}

	@XStreamAlias("MediaId")
	private String mediaId;
	
	@XStreamAlias("ThumbMediaId")
	private String thumbMediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
}
