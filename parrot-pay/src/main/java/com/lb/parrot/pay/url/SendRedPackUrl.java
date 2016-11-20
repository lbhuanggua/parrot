package com.lb.parrot.pay.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 
* <p>Title: 发放普通红包</p>
* <p>Description: https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=13_4&index=3</p>
* @author lbhuanggua
* @date 2016-05-23
 */
public class SendRedPackUrl extends AbstractToServerUrl implements ToServerUrl{

	public String getKey() {
		return "sendredpack";
	}
	
	public String getUrl() {
		return "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	}

	public String getMethod() {
		return "post";
	}

	@Override
	public boolean isCert() {
		return true;
	}

}
