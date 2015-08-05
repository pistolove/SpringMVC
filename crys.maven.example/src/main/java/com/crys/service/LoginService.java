package com.crys.service;

import org.springframework.stereotype.Component;
import com.crys.model.User;

@Component
public class LoginService extends BaseService {

	public void addUser(User user) {
		this.getFacadeDao().getLoginDao().insert(user);
	}

	public User getUser(int id) {
		return this.getFacadeDao().getLoginDao().get(id);
	}

	public void deleteUser(int id) {
		this.getFacadeDao().getLoginDao().delete(id);
	}

	public void updateUser(User user) {
		this.getFacadeDao().getLoginDao().update(user);
	}

}
