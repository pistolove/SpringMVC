package com.crys.service;

import javax.annotation.Resource;
import com.crys.dao.FacadeDao;

public class BaseService {

	@Resource
	protected FacadeDao facadeDao;

	public FacadeDao getFacadeDao() {
		return facadeDao;
	}

}
