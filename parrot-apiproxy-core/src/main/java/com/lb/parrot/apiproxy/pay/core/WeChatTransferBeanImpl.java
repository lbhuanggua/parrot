package com.lb.parrot.apiproxy.pay.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.parrot.apiproxy.pay.api.WeChatTransferBean;
import com.lb.parrot.apiproxy.pay.model.WeChatTransferModel;
import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.message.GetTransferInfoMessage;
import com.lb.parrot.pay.message.TransferMessage;
import com.lb.parrot.pay.result.transfer.GetTransferInfoResult;
import com.lb.parrot.pay.result.transfer.TransferResult;
import com.lb.parrot.pay.url.GetTransferInfoUrl;
import com.lb.parrot.pay.url.TransferUrl;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.bean.WeChatContextDefault;
import com.lb.parrot.support.util.SignatureUtil;
import com.lb.parrot.support.util.XmlUtil;

@Service("weChatTransferBean")
public class WeChatTransferBeanImpl implements WeChatTransferBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatTransferBeanImpl.class);
	
	@Autowired
	WeChatConnector weChatConnector;
	@Autowired
	WeChatClient weChatClient;
	
	@Override
	public TransferResult transfers(WeChatTransferModel model)
			throws WeChatPayException {
		LOGGER.debug("企业付款>>>接收业务表单：{}", model.toString());
		TransferUrl toUrl = new TransferUrl();
		WeChatContext context = new WeChatContextDefault();
		TransferMessage message = new TransferMessage();
		BeanUtils.copyProperties(model, message);
		message.setAppId(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		context.setInput(message);
		LOGGER.debug("企业付款>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("企业付款>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		TransferResult result = XmlUtil.toBean((String)context.getOutput(), TransferResult.class);
		if(result.getReturnCode().equals("FAIL")){
			LOGGER.error("企业付款>>>下单出错：code:{},msg：{}", result.getReturnCode(), result.getReturnMsg());
			throw new WeChatPayException(result.getReturnCode(),result.getReturnMsg());
		}
		if(result.getResultCode().equals("FAIL")){
			LOGGER.error("企业付款>>>下单出错：code:{},des：{}", result.getErrorCode(), result.getErrorCodeDes());
			throw new WeChatPayException(result.getErrorCode(),result.getErrorCodeDes());
		}
		return result;
	}

	@Override
	public GetTransferInfoResult gettransferinfo(String partnerTradeNo)
			throws WeChatPayException {
		LOGGER.debug("查询企业付款>>>接收业务表单：{}", partnerTradeNo.toString());
		GetTransferInfoUrl toUrl = new GetTransferInfoUrl();
		WeChatContext context = new WeChatContextDefault();
		GetTransferInfoMessage message = new GetTransferInfoMessage();
		message.setPartnerTradeNo(partnerTradeNo);
		message.setAppId(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		context.setInput(message);
		LOGGER.debug("查询企业付款>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("查询企业付款>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		GetTransferInfoResult result = XmlUtil.toBean((String)context.getOutput(), GetTransferInfoResult.class);
		if(result.getReturnCode().equals("FAIL")){
			LOGGER.error("查询企业付款>>>下单出错：code:{},msg：{}", result.getReturnCode(), result.getReturnMsg());
			throw new WeChatPayException(result.getReturnCode(),result.getReturnMsg());
		}
		if(result.getResultCode().equals("FAIL")){
			LOGGER.error("查询企业付款>>>下单出错：code:{},des：{}", result.getErrorCode(), result.getErrorCodeDes());
			throw new WeChatPayException(result.getErrorCode(),result.getErrorCodeDes());
		}
		return result;
	}

}