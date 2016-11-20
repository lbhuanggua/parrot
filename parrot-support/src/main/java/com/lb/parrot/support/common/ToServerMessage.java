package com.lb.parrot.support.common;

import java.io.Serializable;


/**
 * 
* <p>Title: 发送到微信服务器的消息</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年05月19日
 */
public interface ToServerMessage extends Serializable{
	/**
	 * 转化post提交的内容
	 * 
	 * @return
	 */
	String toString();
}
