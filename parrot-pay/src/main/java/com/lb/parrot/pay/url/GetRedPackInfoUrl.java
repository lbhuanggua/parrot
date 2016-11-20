package com.lb.parrot.pay.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 
* <p>Title: 查询红包记录</p>
* <p>Description: https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=13_6&index=5</p>
* @author lbhuanggua
* @date 2016-05-23
 */
public class GetRedPackInfoUrl extends AbstractToServerUrl implements ToServerUrl{

	public String getKey() {
		return "gethbinfo";
	}
	
	public String getUrl() {
		return "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";
	}

	public String getMethod() {
		return "post";
	}

	@Override
	public boolean isCert() {
		return true;
	}

}
