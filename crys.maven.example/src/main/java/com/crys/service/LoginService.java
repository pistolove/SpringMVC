package com.crys.service;

import org.springframework.stereotype.Service;
import com.crys.model.User;

@Service
public class LoginService extends BaseService{

	public void addUser(User user){
		this.getFacadeDao().getLoginDao().insert(user);
	}
	
}
