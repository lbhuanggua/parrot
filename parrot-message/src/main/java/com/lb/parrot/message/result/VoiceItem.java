package com.lb.parrot.message.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class VoiceItem {

	public VoiceItem(){
		
	}
	
    public VoiceItem(String mediaId){
		this.mediaId = mediaId;
	}

	@XStreamAlias("MediaId")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
