package com.lb.parrot.apiproxy.pay.api;

import java.io.InputStream;

import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.from.PayNotifyBusiness;

public interface WeChatPayNotifyBean {
	
	/**
	 * 读取微信POST流数据并验证签名
	 * @param in
	 * @return
	 * @throws WeChatPayException
	 */
	PayNotifyBusiness readNotifyStreamAndCheckSign(InputStream in) throws WeChatPayException;
	
	/**
	 * 读取微信XML数据并验证签名
	 * @param xml
	 * @return
	 * @throws WeChatPayException
	 */
	PayNotifyBusiness readNotifyStreamAndCheckSign(String xml) throws WeChatPayException;
	
}
