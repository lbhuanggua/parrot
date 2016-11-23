package com.lb.parrot.message.result;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图文回复消息
 * @author lbhuanggua
 *
 */
@XStreamAlias("xml")
public class NewsReplyMessage extends CommonReplyMessage{
	
	public NewsReplyMessage(){
	    setMsgType("news");
	}

	@XStreamAlias("ArticleCount")
	private int articleCount;
	
	@XStreamAlias("Articles")
	private ArticleItems articleItems;

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public ArticleItems getArticleItems() {
		return articleItems;
	}

	public void setArticleItems(ArticleItems articleItems) {
		this.articleItems = articleItems;
	}
	
	public void addArticleItem(ArticleItem articleItem){
		if(articleItems==null){
		   articleItems = new ArticleItems();
		}
		articleItems.getArticleItemList().add(articleItem);
	}
	
	public String toString(){
		XStream xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations(getClass());
		return xstream.toXML(this);
	}
}
