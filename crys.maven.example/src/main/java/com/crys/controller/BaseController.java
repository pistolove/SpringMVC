package com.crys.controller;

import javax.annotation.Resource;
import com.crys.service.FacadeService;

public class BaseController {

	@Resource
	protected FacadeService facadeService;

	public FacadeService getFacadeService() {
		return facadeService;
	}

}
