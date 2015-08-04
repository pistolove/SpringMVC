package com.crys.service;

import org.springframework.stereotype.Service;
import com.crys.model.User;

@Service("loginService")
public class LoginService extends BaseService {

	public void addUser(User user) {
		this.getFacadeDao().getLoginDao().insert(user);
	}

	public void getUser(int id) {
		this.getFacadeDao().getLoginDao().get(id);
	}

	public void deleteUser(int id) {
		this.getFacadeDao().getLoginDao().delete(id);
	}

	public void updateUser(User user) {
		this.getFacadeDao().getLoginDao().insert(user);
	}

}
