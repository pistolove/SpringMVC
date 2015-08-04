package com.crys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.crys.service.FacadeService;

@Controller("baseController")
public class BaseController {

	@Resource
	protected FacadeService facadeService;

	public FacadeService getFacadeService() {
		return facadeService;
	}

}
