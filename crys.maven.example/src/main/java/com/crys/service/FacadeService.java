package com.crys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("facadeService")
public class FacadeService {

	@Resource
	protected LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

}
