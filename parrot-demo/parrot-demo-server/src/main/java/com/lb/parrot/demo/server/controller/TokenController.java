package com.lb.parrot.demo.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lb.parrot.apiproxy.support.api.WeChatAccessTokenBean;
import com.lb.parrot.support.common.WeChatErrMsg;
import com.lb.parrot.support.exception.WeChatAbstractException;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.response.ResultResponse;
import com.lb.parrot.support.result.AccessToken;
import com.lb.parrot.support.result.JsApiSignature;
import com.lb.parrot.support.result.JsApiTicket;

@Controller
@RequestMapping("/demo/control")
public class TokenController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TokenController.class);
	
	@Autowired
	private WeChatAccessTokenBean weChatAccessTokenBean;
	
	@RequestMapping(value = "/token", method = { RequestMethod.GET })
	@ResponseBody
	public ResultResponse getAccessToken() {
		try{
			AccessToken accessToken = weChatAccessTokenBean.getAccessToken();
			LOGGER.debug("AccessToken:{}", accessToken.toString());
			return new ResultResponse(true, JSON.toJSONString(accessToken));
		}catch(WeChatAbstractException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			return new ResultResponse(false, e.getMessage());
		}
	}

	@RequestMapping(value = "/js_ticket", method = { RequestMethod.GET })
	@ResponseBody
	public ResultResponse getJsTicket() {
		try{
			JsApiTicket jsApiTicket = weChatAccessTokenBean.getJsApiTicket();
			LOGGER.debug("JsApiTicket:{}", jsApiTicket.toString());
			return new ResultResponse(true, JSON.toJSONString(jsApiTicket));
		}catch(WeChatSupportException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			return new ResultResponse(false, e.getMessage());
		}
	}

	@RequestMapping(value = "/js_config", method = { RequestMethod.GET })
	@ResponseBody
	public ResultResponse getJsSignature(@RequestParam(value = "url", required = true) String url){
		try{
			JsApiSignature jsApiSignature = weChatAccessTokenBean.getJsApiSignature(url);
			LOGGER.debug("jsApiSignature:{}", jsApiSignature.toString());
			return new ResultResponse(true, JSON.toJSONString(jsApiSignature));
		}catch(WeChatSupportException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			return new ResultResponse(false, e.getMessage());
		}	
	}

}
