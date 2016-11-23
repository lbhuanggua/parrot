package com.lb.parrot.apiproxy.pay.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.parrot.apiproxy.pay.api.WeChatPayOrderBean;
import com.lb.parrot.apiproxy.pay.model.WeChatCreateOrderModel;
import com.lb.parrot.apiproxy.pay.model.WeChatDownBillModel;
import com.lb.parrot.apiproxy.pay.model.WeChatOrderConditionModel;
import com.lb.parrot.pay.common.PayTradeType;
import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.message.CloseOrderMessage;
import com.lb.parrot.pay.message.DownLoadBillMessage;
import com.lb.parrot.pay.message.OrderQueryMessage;
import com.lb.parrot.pay.message.UnifiedOrderMessage;
import com.lb.parrot.pay.response.H5PayResponse;
import com.lb.parrot.pay.result.CloseOrderResult;
import com.lb.parrot.pay.result.DownloadBillResult;
import com.lb.parrot.pay.result.OrderQueryResult;
import com.lb.parrot.pay.result.PayFailResult;
import com.lb.parrot.pay.result.UnifiedOrderResult;
import com.lb.parrot.pay.result.alias.PayBusinessAliasResult;
import com.lb.parrot.pay.result.pojo.ToServerPayResult;
import com.lb.parrot.pay.url.CloseOrderUrl;
import com.lb.parrot.pay.url.DownLoadBillUrl;
import com.lb.parrot.pay.url.OrderQueryUrl;
import com.lb.parrot.pay.url.UnifiedOrderUrl;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.bean.WeChatContextDefault;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.util.ParserUtil;
import com.lb.parrot.support.util.SignatureUtil;
import com.lb.parrot.support.util.TimeUtils;

@Service("weChatPayOrderBean")
public class WeChatPayOrderBeanImpl implements WeChatPayOrderBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatPayOrderBeanImpl.class);
	
	@Autowired
	WeChatConnector weChatConnector;
	
	@Autowired
	WeChatClient weChatClient;

	public H5PayResponse unified(WeChatCreateOrderModel model) throws WeChatPayException{
		LOGGER.debug("统一下单>>>接收业务表单：{}", model.toString());
		H5PayResponse H5PayResponse = null;
		UnifiedOrderUrl toUrl = new UnifiedOrderUrl();
		WeChatContext context = new WeChatContextDefault();
		UnifiedOrderMessage message = new UnifiedOrderMessage();
		BeanUtils.copyProperties(model, message);
		message.setAppId(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		message.setTradeType(PayTradeType.JSAPI.toString());
		context.setInput(message);
		LOGGER.debug("统一下单>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("统一下单>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		ToServerPayResult payResult = ParserUtil.parse((String)context.getOutput(), ConvertMode.SEND);
		if(payResult instanceof UnifiedOrderResult){
			UnifiedOrderResult result = (UnifiedOrderResult) payResult;
			H5PayResponse = new H5PayResponse();
			H5PayResponse.setAppId(result.getAppId());
			H5PayResponse.setTimeStamp(TimeUtils.currentTimeSecondsStr());
			H5PayResponse.setNonceStr(SignatureUtil.getRandomStr());
			H5PayResponse.setPrepayId("prepay_id="+result.getPrepayId());
			H5PayResponse.setSignType("MD5");
			H5PayResponse.setPaySign(SignatureUtil.createPaySignatureJSON(H5PayResponse, weChatClient.getPayToken()));
			LOGGER.debug("统一下单>>>转换H5启动对象：{}", H5PayResponse.toString());
		}else if(payResult instanceof PayBusinessAliasResult){
			PayBusinessAliasResult result = (PayBusinessAliasResult) payResult;
			LOGGER.error("统一下单>>>下单出错：code:{},des：{}", result.getErrorCode(), result.getErrorCodeDes());
			throw new WeChatPayException(result.getErrorCode(),result.getErrorCodeDes());
		}else if(payResult instanceof PayFailResult){
			PayFailResult result = (PayFailResult) payResult;
			LOGGER.error("统一下单>>>下单出错：code:{},msg：{}", result.getReturnCode(), result.getReturnMsg());
			throw new WeChatPayException(result.getReturnCode(), result.getReturnMsg());
		}
		return H5PayResponse;
	}
	
	public OrderQueryResult query(WeChatOrderConditionModel model) throws WeChatPayException {
		LOGGER.debug("查询订单>>>接收业务表单：{}", model.toString());
		OrderQueryUrl toUrl = new OrderQueryUrl();
		WeChatContext context = new WeChatContextDefault();
		OrderQueryMessage message = new OrderQueryMessage();
		BeanUtils.copyProperties(model, message);
		message.setAppId(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		context.setInput(message);
		LOGGER.debug("查询订单>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("查询订单>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		ToServerPayResult payResult = ParserUtil.parse((String)context.getOutput(),  ConvertMode.SEND);
		if(payResult instanceof PayBusinessAliasResult){
			PayBusinessAliasResult result = (PayBusinessAliasResult) payResult;
			LOGGER.error("查询订单>>>下单出错：code:{},des：{}", result.getErrorCode(), result.getErrorCodeDes());
			throw new WeChatPayException(result.getErrorCode(),result.getErrorCodeDes());
		}else if(payResult instanceof PayFailResult){
			PayFailResult result = (PayFailResult) payResult;
			LOGGER.error("查询订单>>>下单出错：code:{},msg：{}", result.getReturnCode(), result.getReturnMsg());
			throw new WeChatPayException(result.getReturnCode(), result.getReturnMsg());
		}
		return (OrderQueryResult) payResult;
	}

	public void close(WeChatOrderConditionModel model) throws WeChatPayException{
		LOGGER.debug("关闭订单>>>接收业务表单：{}", model.toString());
		CloseOrderUrl toUrl = new CloseOrderUrl();
		WeChatContext context = new WeChatContextDefault();
		CloseOrderMessage message = new CloseOrderMessage();
		BeanUtils.copyProperties(model, message);
		message.setAppId(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		context.setInput(message);
		LOGGER.debug("关闭订单>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("关闭订单>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		ToServerPayResult payResult = ParserUtil.parse((String)context.getOutput(),  ConvertMode.SEND);
		if (payResult instanceof PayFailResult) {
			PayFailResult result = (PayFailResult) payResult;
			LOGGER.error("关闭订单>>>下单出错：code:{},msg：{}", result.getReturnCode(), result.getReturnMsg());
			throw new WeChatPayException(result.getReturnCode(), result.getReturnMsg());
		}else if(payResult instanceof CloseOrderResult){
			CloseOrderResult result = (CloseOrderResult) payResult;
			if(result.getResultCode().equals("FAIL")){
				LOGGER.error("关闭订单>>>下单出错：code:{},msg：{}", result.getResultCode(), result.getResultMsg());
				throw new WeChatPayException(result.getResultCode(), result.getResultMsg());
			}
			LOGGER.debug("关闭订单成功：{}", result.getResultMsg());
		}
	}

	@Override
	public DownloadBillResult down(WeChatDownBillModel model) throws WeChatPayException {
		LOGGER.debug("下载对账单>>>接收业务表单：{}", model.toString());
		DownLoadBillUrl toUrl = new DownLoadBillUrl();
		WeChatContext context = new WeChatContextDefault();
		DownLoadBillMessage message = new DownLoadBillMessage();
		BeanUtils.copyProperties(model, message);
		message.setAppId(weChatClient.getAppid());
		message.setMchId(weChatClient.getMchId());
		message.setNonceStr(SignatureUtil.getRandomStr());
		message.setSignType("MD5");
		context.setInput(message);
		LOGGER.debug("下载对账单>>>转换微信表单：{}", message.toString());
		weChatConnector.send(toUrl, context);
		LOGGER.debug("下载对账单>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		ToServerPayResult result = ParserUtil.parse((String)context.getOutput(), ConvertMode.SEND);
		if(result instanceof PayFailResult){
			PayFailResult err = (PayFailResult) result;
			LOGGER.error("下载对账单>>>下单出错：code:{},msg：{}", err.getReturnCode(), err.getReturnMsg());
			throw new WeChatPayException(err.getReturnCode(), err.getReturnMsg());
		}
		return (DownloadBillResult)result;
	}
	
}
