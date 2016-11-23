package com.lb.parrot.apiproxy.pay.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.parrot.apiproxy.pay.api.WeChatPayRefundBean;
import com.lb.parrot.apiproxy.pay.model.WeChatRefundModel;
import com.lb.parrot.apiproxy.pay.model.WeChatRefundQueryModel;
import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.message.RefundMessage;
import com.lb.parrot.pay.message.RefundQueryMessage;
import com.lb.parrot.pay.result.RefundQueryResult;
import com.lb.parrot.pay.result.RefundResult;
import com.lb.parrot.pay.url.RefundQueryUrl;
import com.lb.parrot.pay.url.RefundUrl;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.bean.WeChatContextDefault;
import com.lb.parrot.support.util.SignatureUtil;
import com.lb.parrot.support.util.XmlUtil;

@Service("weChatPayRefundBean")
public class WeChatPayRefundBeanImpl implements WeChatPayRefundBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatPayRefundBeanImpl.class);
	
	@Autowired
	WeChatConnector weChatConnector;
	
	@Autowired
	WeChatClient weChatClient;

	@Override
	public RefundResult refund(WeChatRefundModel model) throws WeChatPayException {
		LOGGER.debug("申请退款>>>接收业务表单：{}", model.toString());
		RefundUrl toUrl = new RefundUrl();
		WeChatContext context = new WeChatContextDefault();
		RefundMessage message = new RefundMessage();
		BeanUtils.copyProperties(model, message);
		message.setAppId(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		context.setInput(message);
		LOGGER.debug("申请退款>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("申请退款>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		RefundResult result = XmlUtil.toBean((String)context.getOutput(), RefundResult.class);
		if(result.getReturnCode().equals("FAIL")){
			LOGGER.error("申请退款>>>出错：code:{},msg：{}", result.getReturnCode(), result.getReturnMsg());
			throw new WeChatPayException(result.getReturnCode(),result.getReturnMsg());
		}
		if(result.getResultCode().equals("FAIL")){
			LOGGER.error("申请退款>>>出错：code:{},des：{}", result.getErrorCode(), result.getErrorCodeDes());
			throw new WeChatPayException(result.getErrorCode(),result.getErrorCodeDes());
		}
		return result;
	}

	@Override
	public RefundQueryResult query(WeChatRefundQueryModel model) throws WeChatPayException {
		LOGGER.debug("查询退款>>>接收业务表单：{}", model.toString());
		RefundQueryUrl toUrl = new RefundQueryUrl();
		WeChatContext context = new WeChatContextDefault();
		RefundQueryMessage message = new RefundQueryMessage();
		BeanUtils.copyProperties(model, message);
		message.setAppId(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		context.setInput(message);
		LOGGER.debug("查询退款>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("查询退款>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		RefundQueryResult result = XmlUtil.toBean((String)context.getOutput(), RefundQueryResult.class);
		if(result.getReturnCode().equals("FAIL")){
			LOGGER.error("查询退款>>>出错：code:{},msg：{}", result.getReturnCode(), result.getReturnMsg());
			throw new WeChatPayException(result.getReturnCode(),result.getReturnMsg());
		}
		if(result.getResultCode().equals("FAIL")){
			LOGGER.error("查询退款>>>出错：code:{},des：{}", result.getErrorCode(), result.getErrorCodeDes());
			throw new WeChatPayException(result.getErrorCode(),result.getErrorCodeDes());
		}
		return result;
	}
	
}
