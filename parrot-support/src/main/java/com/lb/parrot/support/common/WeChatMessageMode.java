package com.lb.parrot.support.common;

/**
 * 
* <p>Title: 微信消息枚举类</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public enum WeChatMessageMode {

	/**
	 * 文本消息1
	 */
	TEXT("text"),
	/**
	 * 图像消息2
	 */
	IMAGE("image"),
	/**
	 * 语音消息3
	 */
	VOICE("voice"),
	/**
	 * 视频消息4
	 */
	VIDEO("video"),
	/**
	 * 小视频消息5
	 */
	SHORT_VIDEO("shortvideo"),
	/**
	 * 地理位置消息6
	 */
	LOCATION("location"),
	/**
	 * 链接消息7
	 */
	LINK("link"),
	/**
	 * 音乐消息8
	 */
	MUSIC("music"),
	/**
	 * 多图文消息9
	 */
	NEWS("news"),
	/**
	 * 群发消息中的图文消息10
	 */
	MP_NEWS("mpnews"),
	/**
	 * 群发消息中的视频消息11
	 */
	MP_VIDEO("mpvideo"),
	/**
	 * 客服消息12
	 */
	TRANSFER_CUSTOMER_SERVICE("transfer_customer_service");

	private WeChatMessageMode(String type) {
		this.type = type;
	}

	private final String type;

	public String getType() {
		return type;
	}
}
