package com.lb.parrot.demo.callback.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.common.WeChatErrMsg;
import com.lb.parrot.support.exception.WeChatSupportException;

/**
 * 
* <p>Title: 接收微信推送请求</p>
* <p>Description: </p>
* @author lbhuanggua
* @date 2016年10月21日 下午5:43:24
 */
@Controller
@Scope("prototype")
@RequestMapping("/demo/callback")
public class CallBackController{

	private static final Logger LOGGER = LoggerFactory.getLogger(CallBackController.class);
	
	@Autowired
	private WeChatConnector weChatConnector;
	
	@RequestMapping(value = "/handle" , produces = "application/html; charset=utf-8")
	@ResponseBody
	public void receive(HttpServletRequest request, HttpServletResponse response) {
		try{
			weChatConnector.receive(request, response);
		}catch(WeChatSupportException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
		}
	}

}
