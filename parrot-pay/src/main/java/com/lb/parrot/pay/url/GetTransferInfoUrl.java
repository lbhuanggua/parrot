package com.lb.parrot.pay.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 
* <p>Title: 查询企业付款API</p>
* <p>Description: https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_3</p>
* @author lbhuanggua
* @date 2016-05-21
 */
public class GetTransferInfoUrl extends AbstractToServerUrl implements ToServerUrl{

	public String getKey() {
		return "gettransferinfo";
	}
	
	public String getUrl() {
		return "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";
	}

	public String getMethod() {
		return "post";
	}

	@Override
	public boolean isCert() {
		return true;
	}

}
