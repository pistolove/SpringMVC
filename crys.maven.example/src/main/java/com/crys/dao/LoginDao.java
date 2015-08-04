package com.crys.dao;

import org.springframework.stereotype.Repository;

import com.crys.model.User;

@Repository
public class LoginDao implements LoginBaseDao{

	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(User user) {
		System.err.println("insert successful" +user.getId()+"; "+user.getName());
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public void update(User user) {
		// TODO Auto-generated method stub

	}

}
