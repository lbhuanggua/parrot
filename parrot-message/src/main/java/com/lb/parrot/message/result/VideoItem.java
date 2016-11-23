package com.lb.parrot.message.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class VideoItem {

	public VideoItem(){
		
	}
	
    public VideoItem(String mediaId,String title,String description){
		this.mediaId = mediaId;
		this.title = title;
		this.description = description;
	}
    
	@XStreamAlias("MediaId")
	private String mediaId;
	
	@XStreamAlias("Title")
	private String title;
	
	@XStreamAlias("Description")
	private String description;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
