package com.lb.parrot.message.result;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文本回复消息
 *
 */
@XStreamAlias("xml")
public class TextReplyMessage extends CommonReplyMessage{

	public TextReplyMessage(){
		setMsgType("text");
	}
	@XStreamAlias("Content")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String toString(){
		XStream xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations(getClass());
		return xstream.toXML(this);
	}
	
}
