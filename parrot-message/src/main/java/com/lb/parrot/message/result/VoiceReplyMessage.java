package com.lb.parrot.message.result;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 语音回复消息
 *
 */
@XStreamAlias("xml")
public class VoiceReplyMessage extends CommonReplyMessage{

	public VoiceReplyMessage(String mediaId){
		setMsgType("voice");
		voice = new VoiceItem(mediaId);
	}
	
	public VoiceReplyMessage(){
		this(null);
	}
	
	@XStreamAlias("Voice")
	private VoiceItem voice;

	public VoiceItem getVoice() {
		return voice;
	}

	public void setVoice(VoiceItem voice) {
		this.voice = voice;
	}
	
	public String toString(){
		XStream xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations(getClass());
		return xstream.toXML(this);
	}
}
