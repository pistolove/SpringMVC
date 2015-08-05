package com.crys.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class FacadeService {

	@Resource
	protected LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

}
