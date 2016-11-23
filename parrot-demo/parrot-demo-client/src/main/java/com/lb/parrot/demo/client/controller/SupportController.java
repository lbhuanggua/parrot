package com.lb.parrot.demo.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lb.parrot.apiproxy.account.api.WeChatQrCodeBean;
import com.lb.parrot.apiproxy.support.api.WeChatAccessTokenBean;
import com.lb.parrot.support.common.WeChatErrMsg;
import com.lb.parrot.support.exception.WeChatAbstractException;
import com.lb.parrot.support.exception.WeChatSupportException;
import com.lb.parrot.support.message.ActionInfo;
import com.lb.parrot.support.message.QrcodeCreateMessage;
import com.lb.parrot.support.message.Scene;
import com.lb.parrot.support.response.ResultResponse;
import com.lb.parrot.support.result.AccessToken;
import com.lb.parrot.support.result.QrcodeResult;


@Controller
@RequestMapping("/demo/support")
public class SupportController{

	private static final Logger LOGGER = LoggerFactory.getLogger(SupportController.class);
	
	@Autowired
	WeChatAccessTokenBean weChatAccessTokenBean;
	
	@Autowired
	WeChatQrCodeBean weChatQrCodeBean;

	@RequestMapping(value = "/token", method = { RequestMethod.GET })
	@ResponseBody
	public ResultResponse getAccessToken() {
		try{
			AccessToken accessToken = weChatAccessTokenBean.getAccessToken();
			LOGGER.debug("accessToken:{}", accessToken.toString());
			return new ResultResponse(true, JSON.toJSONString(accessToken));
		}catch(WeChatAbstractException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			return new ResultResponse(false, e.getMessage());
		}
	}
	
	@RequestMapping(value = "/qrcode/create/temp", method = { RequestMethod.GET })
	@ResponseBody
	public ResultResponse createQrCodeTemp() {
		try{
			QrcodeCreateMessage message = new QrcodeCreateMessage(604800L, "QR_SCENE", new ActionInfo(new Scene(123)));
			QrcodeResult result = weChatQrCodeBean.createTempQrCode(message);
			LOGGER.debug("result:{}", result.toString());
			return new ResultResponse(true, JSON.toJSONString(result));
		}catch(WeChatSupportException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			return new ResultResponse(false, e.getMessage());
		}
	}
	
}
