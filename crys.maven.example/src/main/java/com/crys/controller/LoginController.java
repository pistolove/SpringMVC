package com.crys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crys.model.User;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping("/add")
	public void insert() {
		User user = new User();
		user.setId(1);
		user.setName("jack");
		log.info("age="+user.getId()+";name="+user.getName());
		this.facadeService.getLoginService().addUser(user);
	}
	
	@RequestMapping("/get")
	public void get() {
		User user = this.facadeService.getLoginService().getUser(1);
		log.info("get: "+user.getId()+"---"+user.getName());
		System.err.println("get: "+user.getId()+"---"+user.getName());
	}
	
	@RequestMapping("/delete")
	public void delete() {
		this.facadeService.getLoginService().deleteUser(1);
		log.info("delete: "+1);
		System.err.println("delete: "+1);
	}
	
	@RequestMapping("/update")
	public void update() {
		User user = this.facadeService.getLoginService().getUser(1);
		user.setName("jone");
		log.info("age="+user.getId()+";name="+user.getName());
		this.facadeService.getLoginService().updateUser(user);
	}
	
}
