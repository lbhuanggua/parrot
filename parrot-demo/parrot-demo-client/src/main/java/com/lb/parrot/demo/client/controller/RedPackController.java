package com.lb.parrot.demo.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lb.parrot.apiproxy.pay.api.WeChatRedPackBean;


@Controller
@RequestMapping("/demo/red")
public class RedPackController{

	private static final Logger LOGGER = LoggerFactory.getLogger(RedPackController.class);
	
	@Autowired
	private WeChatRedPackBean weChatRedPackBean;
	
	
	
}
