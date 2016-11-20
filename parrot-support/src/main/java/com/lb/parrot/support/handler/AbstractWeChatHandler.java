package com.lb.parrot.support.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
* <p>Title: 抽象的微信处理器</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public abstract class AbstractWeChatHandler implements WeChatHandler{

	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractWeChatHandler.class);
	
	private int priority;
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int compareTo(WeChatHandler o) {
		if (o.getPriority() == getPriority()) {
            return 0;
        } else if (o.getPriority() < getPriority()) {
            return 1;
        } else {
            return -1;
        }
	}

	public abstract void init();
	
	public abstract void destory();  
	
}
