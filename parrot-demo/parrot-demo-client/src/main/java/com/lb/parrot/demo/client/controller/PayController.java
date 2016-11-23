package com.lb.parrot.demo.client.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lb.parrot.apiproxy.pay.api.WeChatPayNotifyBean;
import com.lb.parrot.apiproxy.pay.api.WeChatPayOrderBean;
import com.lb.parrot.apiproxy.pay.model.WeChatCreateOrderModel;
import com.lb.parrot.apiproxy.pay.model.WeChatDownBillModel;
import com.lb.parrot.apiproxy.pay.model.WeChatOrderConditionModel;
import com.lb.parrot.pay.exception.WeChatPayException;
import com.lb.parrot.pay.from.PayNotifyBusiness;
import com.lb.parrot.pay.response.H5PayResponse;
import com.lb.parrot.pay.response.PayNotifyResult;
import com.lb.parrot.pay.result.BillField;
import com.lb.parrot.pay.result.DownloadBillResult;
import com.lb.parrot.pay.result.OrderQueryResult;
import com.lb.parrot.support.response.ResultResponse;


@Controller
@RequestMapping("/demo/pay")
public class PayController{

	private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);
	
	@Autowired
	private WeChatPayOrderBean weChatPayOrderBean;
	
	@Autowired
	private WeChatPayNotifyBean weChatPayNotifyBean;
	
	@RequestMapping(value = "/unified/{totalFee}", method = { RequestMethod.POST })
	@ResponseBody
	public ResultResponse unified(@PathVariable("totalFee") int totalFee){
		H5PayResponse H5PayResponse = null;
		try{
			WeChatCreateOrderModel model = new WeChatCreateOrderModel();
			
			model.setDeviceInfo("WEB");
			model.setBody("若水优品-黄心猕猴桃");
			model.setOutTradeNo(System.currentTimeMillis() + "");
			model.setTotalFee(totalFee);
			model.setSpbillCreateIp("61.148.25.23");
			model.setNotifyUrl("http://www.zenwater.cn/demo/pay/notify/");
			model.setOpenId("oO_pHxO-IsHxKX-ChmS445TBPeRo");

			H5PayResponse = weChatPayOrderBean.unified(model);
			LOGGER.debug(H5PayResponse.toString());
		} catch (WeChatPayException e) {
			return new ResultResponse(false, e.getMessage());
		}
		return new ResultResponse(true, H5PayResponse.toString());
	}
	
	@RequestMapping(value = "/query/{id}", method = { RequestMethod.GET })
	@ResponseBody
	public ResultResponse query(@PathVariable("id") String orderId){
		try{
			WeChatOrderConditionModel model = new WeChatOrderConditionModel(orderId);
			OrderQueryResult result = weChatPayOrderBean.query(model);
			LOGGER.debug(result.toString());
			return new ResultResponse(true, JSON.toJSONString(result));
		} catch (WeChatPayException e) {
			return new ResultResponse(false, e.getMessage());
		}
	}
	
	@RequestMapping(value = "/close/{id}", method = { RequestMethod.GET })
	@ResponseBody
	public ResultResponse close(@PathVariable("id") String orderId){
		try{
			WeChatOrderConditionModel model = new WeChatOrderConditionModel(orderId);
			weChatPayOrderBean.close(model);
			LOGGER.debug("关闭成功");
			return new ResultResponse(true, "success");
		} catch (WeChatPayException e) {
			return new ResultResponse(false, e.getMessage());
		}
	}

	@RequestMapping(value = "/notify", method = { RequestMethod.POST })
	public void notify(HttpServletRequest request, HttpServletResponse response){
		LOGGER.info("接收微信支付结果通知开始");
		PayNotifyResult notifyReturn = new PayNotifyResult("SUCCESS", "OK");
		try {
			InputStream postInputStream = request.getInputStream();
			@SuppressWarnings("unused")
			PayNotifyBusiness notifyMessage = weChatPayNotifyBean.readNotifyStreamAndCheckSign(postInputStream);
			/*
			 * notifyMessage 微信支付通知返回对象
			 * 1、微信查询订单接口确定支付状态
			 * 2、处理业务逻辑，更改业务系统订单状态及关联系统记录状态（此步注意：同步问题、事务问题）
			 * 3、反馈结果给微信商户系统
			 */
			response.getWriter().write(notifyReturn.toString());
		} catch (IOException e1) {
			notifyReturn = new PayNotifyResult("FAIL", e1.getMessage());
			LOGGER.error(e1.getMessage(), e1);
		} catch (WeChatPayException e2) {
			notifyReturn = new PayNotifyResult("FAIL", e2.getErrorMsg());
			LOGGER.error(e2.getMessage(), e2);
		}
		LOGGER.info(notifyReturn.toString());
		try {
			response.getWriter().write(notifyReturn.toString());
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info("接收微信支付结果通知结束");
	}
	
	@RequestMapping(value = "/down/{dateString}", method = { RequestMethod.GET })
	@ResponseBody
	public ResultResponse down(@PathVariable("dateString") String dateString){
		try{
			WeChatDownBillModel model = new WeChatDownBillModel(dateString);
			DownloadBillResult result = weChatPayOrderBean.down(model);
			
			BillField totalField = result.getTotalField();
			LOGGER.debug("总交易单数:{},总交易额:{},总退款金额:{},总代金券或立减优惠退款金额:{},手续费总金额:{}" ,
					totalField.getValue("总交易单数"),
					totalField.getValue("总交易额"),
					totalField.getValue("总退款金额"),
					totalField.getValue("总代金券或立减优惠退款金额"),
					totalField.getValue("手续费总金额"));
			
			List<BillField> dataFieldList = result.getDataFieldList();
			for (BillField billField : dataFieldList) {
				LOGGER.debug("交易时间:{},公众账号ID:{},商户号,子商户号,设备号,微信订单号,商户订单号,用户标识,交易类型,交易状态,付款银行,货币种类,总金额:{},代金券或立减优惠金额,微信退款单号,商户退款单号,退款金额,代金券或立减优惠退款金额,退款类型,退款状态,商品名称,商户数据包,手续费,费率", 
						billField.getValue("交易时间"),
						billField.getValue("公众账号ID"),
						billField.getValue("总金额"));
			}
			return new ResultResponse(true, "success");
		} catch (WeChatPayException e) {
			return new ResultResponse(false, e.getMessage());
		}
	}
	
}
