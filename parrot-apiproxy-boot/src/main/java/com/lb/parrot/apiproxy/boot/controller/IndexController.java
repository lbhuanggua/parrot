package com.lb.parrot.apiproxy.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lb.parrot.support.response.ResultResponse;

@RestController
public class IndexController {
	
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public ResultResponse index() {
		return new ResultResponse(true, "index");
	}


    
}
