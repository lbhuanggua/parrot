package com.lb.parrot.pay.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 
* <p>Title: 统一下单请求地址</p>
* <p>Description: https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1</p>
* @author lbhuanggua
* @date 2016-05-21
 */
public class UnifiedOrderUrl extends AbstractToServerUrl implements ToServerUrl{

	public String getKey() {
		return "unifiedorder";
	}
	
	public String getUrl() {
		return "https://api.mch.weixin.qq.com/pay/unifiedorder";
	}

	public String getMethod() {
		return "post";
	}


}
