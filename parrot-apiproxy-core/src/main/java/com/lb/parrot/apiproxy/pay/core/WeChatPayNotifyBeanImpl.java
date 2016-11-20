package com.lb.parrot.apiproxy.pay.core;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.parrot.apiproxy.pay.api.WeChatPayNotifyBean;
import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.from.PayNotifyBusiness;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.util.SignatureUtil;
import com.lb.parrot.support.util.StreamUtil;
import com.lb.parrot.support.util.XmlUtil;

@Service("weChatPayNotifyBean")
public class WeChatPayNotifyBeanImpl implements WeChatPayNotifyBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatPayNotifyBeanImpl.class);
	
	@Autowired
	WeChatClient weChatClient;
	
	@Override
	public PayNotifyBusiness readNotifyStreamAndCheckSign(String xml) throws WeChatPayException {
		LOGGER.debug("支付结果通知>>>接收XML：{}", xml);
		PayNotifyBusiness payNotifyBusiness = XmlUtil.toBean(xml, PayNotifyBusiness.class);
		if(payNotifyBusiness.getReturnCode().equals("FAIL")){
			LOGGER.error("支付结果通知>>>出错：code:{},msg：{}", payNotifyBusiness.getReturnCode(), payNotifyBusiness.getReturnMsg());
			throw new WeChatPayException(payNotifyBusiness.getReturnCode(), payNotifyBusiness.getReturnMsg());
		}
		if(payNotifyBusiness.getResultCode().equals("FAIL")){
			LOGGER.error("支付结果通知>>>出错：code:{},dec：{}", payNotifyBusiness.getErrorCode(), payNotifyBusiness.getErrorCodeDes());
			throw new WeChatPayException(payNotifyBusiness.getErrorCode(), payNotifyBusiness.getErrorCodeDes());
		}
		LOGGER.debug("支付结果通知>>>XML转对象：{}", payNotifyBusiness.toString());
		LOGGER.debug("支付结果通知>>>微信签名：{}", payNotifyBusiness.getSignature());
		String sign = SignatureUtil.createPaySignature(payNotifyBusiness, weChatClient.getPayToken());
		LOGGER.debug("支付结果通知>>>第三方签名：{}", sign);
		if (!sign.equals(payNotifyBusiness.getSignature())){
			LOGGER.error("支付结果通知>>>签名错误,微信:{},第三方:{}", payNotifyBusiness.getSignature(), sign);
			throw new WeChatPayException("SIGNERROR", "签名错误");
		}
		return payNotifyBusiness;
	}

	@Override
	public PayNotifyBusiness readNotifyStreamAndCheckSign(InputStream in) throws WeChatPayException {
		LOGGER.debug("支付结果通知>>>接收流：{}", in);
		String xml = "";
		try {
			xml = StreamUtil.readText(in, "UTF-8", false);
		} catch (IOException e) {
			throw new WeChatPayException(e.getMessage(), e);
		}
		if (xml == null || xml.equals("")) {
			throw new WeChatPayException("input stream is null");
		}
		PayNotifyBusiness payNotifyBusiness = XmlUtil.toBean(xml, PayNotifyBusiness.class);
		if(payNotifyBusiness.getReturnCode().equals("FAIL")){
			LOGGER.error("支付结果通知>>>出错：code:{},msg：{}", payNotifyBusiness.getReturnCode(), payNotifyBusiness.getReturnMsg());
			throw new WeChatPayException(payNotifyBusiness.getReturnCode(), payNotifyBusiness.getReturnMsg());
		}
		if(payNotifyBusiness.getResultCode().equals("FAIL")){
			LOGGER.error("支付结果通知>>>出错：code:{},dec：{}", payNotifyBusiness.getErrorCode(), payNotifyBusiness.getErrorCodeDes());
			throw new WeChatPayException(payNotifyBusiness.getErrorCode(), payNotifyBusiness.getErrorCodeDes());
		}
		LOGGER.debug("支付结果通知>>>流转对象：{}", payNotifyBusiness.toString());
		String sign = SignatureUtil.createPaySignature(payNotifyBusiness, weChatClient.getPayToken());
		LOGGER.debug("支付结果通知>>>微信签名：{}, 第三方签名：{}, 验证结果: {}", payNotifyBusiness.getSignature() , sign, sign.equals(payNotifyBusiness.getSignature()));
		if (!sign.equals(payNotifyBusiness.getSignature())){
			LOGGER.error("支付结果通知>>>签名错误,微信:{},第三方:{}", payNotifyBusiness.getSignature(), sign);
			throw new WeChatPayException("SIGNERROR", "签名错误");
		}
		return payNotifyBusiness;
	}

}
