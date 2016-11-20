package com.lb.parrot.pay.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 
* <p>Title: 查询订单请求地址</p>
* <p>Description: https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2</p>
* @author lbhuanggua
* @date 2016-05-21
 */
public class OrderQueryUrl extends AbstractToServerUrl implements ToServerUrl{

	public String getKey() {
		return "orderquery";
	}
	
	public String getUrl() {
		return "https://api.mch.weixin.qq.com/pay/orderquery";
	}

	public String getMethod() {
		return "post";
	}


}
