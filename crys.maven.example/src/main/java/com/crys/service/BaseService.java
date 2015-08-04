package com.crys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crys.dao.FacadeDao;

@Service("baseService")
public class BaseService {

	@Resource
	protected FacadeDao facadeDao;

	public FacadeDao getFacadeDao() {
		return facadeDao;
	}

}
