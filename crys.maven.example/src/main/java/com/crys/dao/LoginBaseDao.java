package com.crys.dao;

import org.springframework.stereotype.Repository;

import com.crys.model.User;

@Repository("loginBaseDao")
public interface LoginBaseDao {
	public User get(int id);

	public void insert(User user);

	public void delete(int id);

	public void update(User user);
}
