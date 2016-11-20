package com.lb.parrot.pay.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 
* <p>Title: 转换短链接</p>
* <p>Description: https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_9</p>
* @author lbhuanggua
* @date 2016-05-21
 */
public class ShortUrl extends AbstractToServerUrl implements ToServerUrl{

	public String getKey() {
		return "shorturl";
	}
	
	public String getUrl() {
		return "https://api.mch.weixin.qq.com/tools/shorturl";
	}

	public String getMethod() {
		return "post";
	}


}
