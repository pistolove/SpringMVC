package com.crys.dao;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class FacadeDao {

	@Resource
	protected LoginBaseDao loginBaseDao;

	public LoginBaseDao getLoginDao() {
		return loginBaseDao;
	}

}
