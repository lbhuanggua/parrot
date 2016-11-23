package com.lb.parrot.message.from;

import com.lb.parrot.support.common.WeChatMessageMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
* <p>Title: 链接消息</p>
* <p>Description: 链接消息</p>
* @author lbhuanggua
* @date 2016年10月17日
 */
@XStreamAlias("xml")
public class LinkMessage extends CommonMessage{
	
	public LinkMessage(){
		setMsgType(WeChatMessageMode.LINK.getType());
	}

	@XStreamAlias("Title")
	private String title;
	
	@XStreamAlias("Description")
	private String description;
	
	@XStreamAlias("Url")
	private String url;

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

	
}
