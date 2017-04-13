package com.lb.parrot.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.result.AccessToken;
import com.lb.parrot.support.result.JsApiSignature;
import com.lb.parrot.support.result.JsApiTicket;

@RestController
public class IndexController {
    
	//private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	@Autowired WeChatClient weChatClient;
	@Autowired WeChatConnector weChatConnector;
	
	@RequestMapping(value = "/access_token", method = { RequestMethod.GET})
	public AccessToken token() {
		return weChatConnector.getAccessToken();
	}
	
	@RequestMapping(value = "/js_ticket", method = { RequestMethod.GET})
	public JsApiTicket getJsTicket() {
		return weChatConnector.getJsApiTicket();
	}

	@RequestMapping(value = "/js_signature", method = { RequestMethod.GET})
	public JsApiSignature getJsSignature(@RequestParam(value = "url", required = true) String url){
		return weChatConnector.getJsApiSignature(weChatClient.getAppid(), url);
	}
	
/*	@RequestMapping(value = "/access_token", method = { RequestMethod.GET})
	public ResultResponse getAccessToken() {
		try{
			AccessToken accessToken = weChatConnector.getAccessToken();
			LOGGER.debug("parrot-token access_token : {}", accessToken.toString());
			return new ResultResponse(true, JSON.parse(JSON.toJSONString(accessToken)));
		}catch(WeChatAbstractException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			return new ResultResponse(false, e.getMessage());
		}
	}*/

/*	@RequestMapping(value = "/js_ticket", method = { RequestMethod.GET})
	public ResultResponse getJsTicket() {
		try{
			JsApiTicket jsApiTicket = weChatConnector.getJsApiTicket();
			LOGGER.debug("parrot-token js_ticket : {}", jsApiTicket.toString());
			return new ResultResponse(true, jsApiTicket);
		}catch(WeChatSupportException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			return new ResultResponse(false, e.getMessage());
		}
	}*/

/*	@RequestMapping(value = "/js_signature", method = { RequestMethod.GET})
	public ResultResponse getJsSignature(@RequestParam(value = "url", required = true) String url){
		try{
			JsApiSignature jsApiSignature = weChatConnector.getJsApiSignature(weChatClient.getAppid(), url);
			LOGGER.debug("parrot-token js_signature : {}", jsApiSignature.toString());
			return new ResultResponse(true, jsApiSignature);
		}catch(WeChatSupportException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			return new ResultResponse(false, e.getMessage());
		}	
	}*/
 
}
