package com.lb.parrot.message.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class MusicItem {
	
	@XStreamAlias("Title")
	private String title;
	
	@XStreamAlias("Description")
	private String description;
	
	@XStreamAlias("MusicUrl")
	private String musicUrl;
	
	@XStreamAlias("HQMusicUrl")
	private String hQMusicUrl;
	
	@XStreamAlias("ThumbMediaId")
	private String thumbMediaId;

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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String gethQMusicUrl() {
		return hQMusicUrl;
	}

	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
}
