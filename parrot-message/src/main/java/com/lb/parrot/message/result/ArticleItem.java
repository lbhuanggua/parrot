package com.lb.parrot.message.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
public class ArticleItem {
	
	public ArticleItem(){
		
	}
	
    public ArticleItem(String title,String description,String url,String picUrl){
		this.title = title;
		this.description = description;
		this.url = url;
		this.picUrl = picUrl;
	}

	@XStreamAlias("Title")
	private String title;
	
	@XStreamAlias("Description")
	private String description;
	
	@XStreamAlias("Url")
	private String url;
	
	@XStreamAlias("PicUrl")
	private String picUrl;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}
