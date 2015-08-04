package com.crys.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class FacadeDao {

	@Resource
	protected BaseDao baseDao;

	public BaseDao getLoginDao() {
		return baseDao;
	}

}
