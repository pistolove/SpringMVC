package com.crys.dao;

import com.crys.model.User;

public interface LoginBaseDao {
	public User get(int id);

	public void insert(User user);

	public void delete(int id);

	public void update(User user);
}
