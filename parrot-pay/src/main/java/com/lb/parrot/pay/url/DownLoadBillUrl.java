package com.lb.parrot.pay.url;

import com.lb.parrot.support.common.ToServerUrl;
import com.lb.parrot.support.url.AbstractToServerUrl;

/**
 * 
* <p>Title: 下载对账单请求地址</p>
* <p>Description: https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_6</p>
* @author lbhuanggua
* @date 2016-05-21
 */
public class DownLoadBillUrl extends AbstractToServerUrl implements ToServerUrl{

	public String getKey() {
		return "downloadbill";
	}
	
	public String getUrl() {
		return "https://api.mch.weixin.qq.com/pay/downloadbill";
	}

	public String getMethod() {
		return "post";
	}

}
