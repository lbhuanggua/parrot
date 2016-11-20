package com.lb.parrot.apiproxy.pay.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.parrot.apiproxy.pay.api.WeChatRedPackBean;
import com.lb.parrot.apiproxy.pay.model.WeChatGroupRedPackModel;
import com.lb.parrot.apiproxy.pay.model.WeChatRedPackModel;
import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.message.GetRedPackInfoMessage;
import com.lb.parrot.pay.message.SendRedPackMessage;
import com.lb.parrot.pay.result.red.RedPackInfoResult;
import com.lb.parrot.pay.result.red.RedPackResult;
import com.lb.parrot.pay.url.GetRedPackInfoUrl;
import com.lb.parrot.pay.url.SendRedPackUrl;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.bean.WeChatContextDefault;
import com.lb.parrot.support.util.SignatureUtil;
import com.lb.parrot.support.util.XmlUtil;

@Service("weChatRedPackBean")
public class WeChatRedPackBeanImpl implements WeChatRedPackBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatRedPackBeanImpl.class);
	
	@Autowired
	WeChatConnector weChatConnector;
	
	@Autowired
	WeChatClient weChatClient;

	@Override
	public RedPackResult sendRedPack(WeChatRedPackModel model) throws WeChatPayException {
		LOGGER.debug("发放普通红包>>>接收业务表单：{}", model.toString());
		SendRedPackUrl toUrl = new SendRedPackUrl();
		WeChatContext context = new WeChatContextDefault();
		SendRedPackMessage message = new SendRedPackMessage();
		BeanUtils.copyProperties(model, message);
		message.setAppId(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		context.setInput(message);
		LOGGER.debug("发放普通红包>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("发放普通红包>>>接收微信反馈表单：{}", (String) context.getOutput());
		RedPackResult result = XmlUtil.toBean((String)context.getOutput(), RedPackResult.class);
		if(result.getReturnCode().equals("FAIL")){
			LOGGER.error("发放普通红包>>>出错：code:{},msg：{}", result.getReturnCode(), result.getReturnMsg());
			throw new WeChatPayException(result.getReturnCode(),result.getReturnMsg());
		}
		if(result.getResultCode().equals("FAIL")){
			LOGGER.error("发放普通红包>>>出错：code:{},des：{}", result.getErrorCode(), result.getErrorCodeDes());
			throw new WeChatPayException(result.getErrorCode(),result.getErrorCodeDes());
		}
		return result;
	}

	@Override
	public RedPackResult sendGroupRedPack(WeChatGroupRedPackModel model)
			throws WeChatPayException {
		LOGGER.debug("发放裂变红包>>>接收业务表单：{}", model.toString());
		SendRedPackUrl toUrl = new SendRedPackUrl();
		WeChatContext context = new WeChatContextDefault();
		SendRedPackMessage message = new SendRedPackMessage();
		BeanUtils.copyProperties(model, message);
		message.setAppId(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		context.setInput(message);
		LOGGER.debug("发放裂变红包>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("查询红包记录>>>接收微信反馈表单：{}", (String) context.getOutput());
		RedPackResult result = XmlUtil.toBean((String)context.getOutput(), RedPackResult.class);
		if(result.getReturnCode().equals("FAIL")){
			LOGGER.error("查询红包记录>>>出错：code:{},msg：{}", result.getReturnCode(), result.getReturnMsg());
			throw new WeChatPayException(result.getReturnCode(),result.getReturnMsg());
		}
		if(result.getResultCode().equals("FAIL")){
			LOGGER.error("查询红包记录>>>出错：code:{},des：{}", result.getErrorCode(), result.getErrorCodeDes());
			throw new WeChatPayException(result.getErrorCode(),result.getErrorCodeDes());
		}
		return result;
	}

	@Override
	public RedPackInfoResult gethbinfo(String mchBillno) throws WeChatPayException {
		LOGGER.debug("查询红包记录>>>接收业务表单：{}", mchBillno);
		GetRedPackInfoUrl toUrl = new GetRedPackInfoUrl();
		WeChatContext context = new WeChatContextDefault();
		GetRedPackInfoMessage message = new GetRedPackInfoMessage();
		message.setBillType("MCHT");
		message.setMchBillno(mchBillno);
		message.setAppid(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		context.setInput(message);
		LOGGER.debug("查询红包记录>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("查询红包记录>>>接收微信反馈表单：{}", (String) context.getOutput());
		RedPackInfoResult result = XmlUtil.toBean((String)context.getOutput(), RedPackInfoResult.class);
		if(result.getReturnCode().equals("FAIL")){
			LOGGER.error("查询红包记录>>>出错：code:{},msg：{}", result.getReturnCode(), result.getReturnMsg());
			throw new WeChatPayException(result.getReturnCode(),result.getReturnMsg());
		}
		if(result.getResultCode().equals("FAIL")){
			LOGGER.error("查询红包记录>>>出错：code:{},des：{}", result.getErrorCode(), result.getErrorCodeDes());
			throw new WeChatPayException(result.getErrorCode(),result.getErrorCodeDes());
		}
		return result;
	}
}
