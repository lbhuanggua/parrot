package com.lb.parrot.pay.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 
* <p>Title: 退款请求地址</p>
* <p>Description: https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_4</p>
* @author lbhuanggua
* @date 2016-05-21
 */
public class RefundUrl extends AbstractToServerUrl implements ToServerUrl{

	public String getKey() {
		return "refund";
	}
	
	public String getUrl() {
		return "https://api.mch.weixin.qq.com/pay/refund";
	}

	public String getMethod() {
		return "post";
	}

	@Override
	public boolean isCert() {
		return true;
	}

}
