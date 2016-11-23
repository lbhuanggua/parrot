package com.lb.parrot.demo.client.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lb.parrot.apiproxy.template.api.WeChatTemplateBean;
import com.lb.parrot.support.common.WeChatErrMsg;
import com.lb.parrot.support.response.ResultResponse;
import com.lb.parrot.template.exception.WeChatTemplateException;
import com.lb.parrot.template.message.SendTemplateMessage;
import com.lb.parrot.template.message.TemplateDataTheme;
import com.lb.parrot.template.result.SendTemplateResult;


@Controller
@RequestMapping("/demo/template")
public class TemplateController{

	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);
	
	@Autowired
	WeChatTemplateBean weChatTemplateBean;

	@RequestMapping(value = "/send", method = { RequestMethod.GET })
	@ResponseBody
	public ResultResponse send() {
		try{
			Map<String, TemplateDataTheme> data = new HashMap<String, TemplateDataTheme>();
			data.put("first", new TemplateDataTheme("你好，你已报名成功","#173177" ));
			data.put("keynote1", new TemplateDataTheme("XXX","#173177" ));
			data.put("keynote2", new TemplateDataTheme("某日某时","#173177" ));
			data.put("keynote3", new TemplateDataTheme("某地","#173177" ));
			data.put("remark", new TemplateDataTheme("如有问题，请联系红毯客服。","#173177" ));
			
			SendTemplateMessage message = new SendTemplateMessage();
			message.setTouser("oO_pHxO-IsHxKX-ChmS445TBPeRo");
			message.setTemplateId("cPH7VkOBbM5ZvbSQ-fa8OtFcd-5UycQW-dFNJjebbX8");
			message.setUrl("http://www.zenwater.cn/common/m-index.html");
			message.setData(data);
			SendTemplateResult result = weChatTemplateBean.send(message);
			LOGGER.debug("result:{}", result.toString());
			return new ResultResponse(true, JSON.toJSONString(result));
		}catch(WeChatTemplateException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			return new ResultResponse(false, e.getMessage());
		}
	}
	

	
}
