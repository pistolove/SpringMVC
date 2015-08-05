package com.crys.dao;

import org.springframework.stereotype.Component;

import com.crys.model.User;

@Component
public interface LoginBaseDao {
	public User get(int id);

	public void insert(User user);

	public void delete(int id);

	public void update(User user);
}
