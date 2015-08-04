package com.crys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.crys.model.User;

@Controller("loginController")
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/add")
	public void add(Model model) {
		User user = new User();
		user.setId(1);
		user.setName("jack");
		log.info("age="+user.getId()+";name="+user.getName());
		this.facadeService.getLoginService().addUser(user);
	}
	
	@RequestMapping("/get")
	public void get() {
		this.facadeService.getLoginService().getUser(1);
	}
	
	@RequestMapping("/delete")
	public void delete() {
		this.facadeService.getLoginService().deleteUser(1);
	}
	
	@RequestMapping("/update")
	public void update() {
		User user = new User();
		user.setId(20);
		user.setName("jack");
		log.info("age="+user.getId()+";name="+user.getName());
		this.facadeService.getLoginService().addUser(user);
	}
	
}
