package com.lb.parrot.pay.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 
* <p>Title: 企业付款API</p>
* <p>Description: https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2</p>
* @author lbhuanggua
* @date 2016-05-21
 */
public class TransferUrl extends AbstractToServerUrl implements ToServerUrl{

	public String getKey() {
		return "transfers";
	}
	
	public String getUrl() {
		return "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
	}

	public String getMethod() {
		return "post";
	}

	@Override
	public boolean isCert() {
		return true;
	}

}
