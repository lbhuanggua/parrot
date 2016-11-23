package com.lb.parrot.demo.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/demo")
public class IndexController{

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("parrot demo client is work");
		ModelAndView mav = new ModelAndView();
		mav.addObject("statu", "parrot demo client is work");
		mav.setViewName("index");
		return mav;
	}

}
