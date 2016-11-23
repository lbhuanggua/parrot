package com.lb.parrot.message.from;

/**
 * 微信消息枚举类
 * @author lbhuanggua
 *
 */
public enum MessageMode {

	/**
     * 文本消息
     */
    TEXT("text"),
    /**
     * 图像消息
     */
    IMAGE("image"),
    /**
     * 语音消息
     */
    VOICE("voice"),
    /**
     * 视频消息
     */
    VIDEO("video"), 
    /**
     * 小视频消息
     */
    SHORT_VIDEO("shortvideo"),
    /**
     * 地理位置消息
     */
    LOCATION("location"),
    /**
     * 链接消息
     */
    LINK("link"),
    /**
     * 音乐消息
     */
    MUSIC("music"),
    /**
     * 多图文消息
     */
    NEWS("news"),
    /**
     * 群发消息中的图文消息
     */
    MP_NEWS("mpnews"),
    /**
     * 群发消息中的视频消息
     */
    MP_VIDEO("mpvideo");
    
    
    private MessageMode(String type){
    	this.type = type;
    }
    
    private final String type;

	public String getType() {
		return type;
	} 
}
