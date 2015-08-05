package com.crys.service;

import javax.annotation.Resource;
import com.crys.cache.CacheTemplate;
import com.crys.dao.FacadeDao;

public class BaseService {

	@Resource
	protected FacadeDao facadeDao;

	@Resource
	protected CacheTemplate cacheTemplate;

	public CacheTemplate getCacheTemplate() {
		return cacheTemplate;
	}

	public FacadeDao getFacadeDao() {
		return facadeDao;
	}

}
