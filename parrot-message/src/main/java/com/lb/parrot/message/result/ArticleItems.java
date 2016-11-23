package com.lb.parrot.message.result;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;


public class ArticleItems {

	@XStreamImplicit
	private List<ArticleItem>  articleItemList;

	public List<ArticleItem> getArticleItemList() {
		if(articleItemList==null){
		   articleItemList = new ArrayList<ArticleItem>();
		}
		return articleItemList;
	}

	public void setArticleItemList(List<ArticleItem> articleItemList) {
		this.articleItemList = articleItemList;
	}
	
}
