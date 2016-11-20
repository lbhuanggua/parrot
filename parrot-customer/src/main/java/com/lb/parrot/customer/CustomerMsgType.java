package com.lb.parrot.customer;

/**
 * 客服消息类型
 * @author liuzhenhua
 *
 */
public enum CustomerMsgType {

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
	 * 音乐消息5
	 */
	MUSIC("music"),
	/**
	 * 图文消息（点击跳转到外链）6
	 */
	NEWS("news"),
	/**
	 * 图文消息7
	 */
	MPNEWS("mpnews"),
	/**
	 * 卡券8
	 */
	WXCARD("wxcard");

	private CustomerMsgType(String type) {
		this.type = type;
	}

	private final String type;

	public String getType() {
		return type;
	}
}
