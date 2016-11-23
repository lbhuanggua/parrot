package com.lb.parrot.demo.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/demo")
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = "/index")
	@ResponseBody
	public String index(HttpServletRequest request) {
		LOGGER.debug("微信API代理层服务运行正常");
		return "parrot apiproxy server work";
	}
}
