package com.lb.parrot.message.from;

import com.lb.parrot.support.common.WeChatMessageMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文本消息
 *
 */
@XStreamAlias("xml")
public class TextMessage extends CommonMessage{

	public TextMessage(){
	   setMsgType(WeChatMessageMode.TEXT.getType());	
	}
	
	@XStreamAlias("Content")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
