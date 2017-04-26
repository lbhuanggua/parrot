package com.lb.parrot.apiproxy.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lb.parrot.apiproxy.pay.api.WeChatPayNotifyBean;
import com.lb.parrot.apiproxy.pay.api.WeChatPayOrderBean;
import com.lb.parrot.apiproxy.pay.model.WeChatCreateOrderModel;
import com.lb.parrot.apiproxy.pay.model.WeChatDownBillModel;
import com.lb.parrot.apiproxy.pay.model.WeChatOrderConditionModel;
import com.lb.parrot.pay.from.PayNotifyBusiness;
import com.lb.parrot.pay.response.H5PayResponse;
import com.lb.parrot.pay.result.DownloadBillResult;
import com.lb.parrot.pay.result.OrderQueryResult;

@RestController
@RequestMapping(value = "/pay")
public class PayController {
	
	@Autowired WeChatPayOrderBean weChatPayOrderBean;
	@Autowired WeChatPayNotifyBean weChatPayNotifyBean;
	
	@RequestMapping(value = "/unified", method = { RequestMethod.POST })
	public H5PayResponse unified(@RequestBody(required = true) WeChatCreateOrderModel message) {
		return weChatPayOrderBean.unified(message);
	}

	@RequestMapping(value = "/query", method = { RequestMethod.POST })
	public OrderQueryResult query(@RequestBody(required = true) WeChatOrderConditionModel message) {
		return weChatPayOrderBean.query(message);
	}
	
	@RequestMapping(value = "/close", method = { RequestMethod.POST })
	public void close(@RequestBody(required = true) WeChatOrderConditionModel message) {
		weChatPayOrderBean.close(message);
	}
	
	@RequestMapping(value = "/down", method = { RequestMethod.POST })
	public DownloadBillResult down(@RequestBody(required = true) WeChatDownBillModel message) {
		return weChatPayOrderBean.down(message);
	}
	
	@RequestMapping(value = "/notity", method = { RequestMethod.POST })
	public PayNotifyBusiness notity(@RequestBody(required = true) String in) {
		return weChatPayNotifyBean.readNotifyStreamAndCheckSign((String)in);
	}
	
	
}
