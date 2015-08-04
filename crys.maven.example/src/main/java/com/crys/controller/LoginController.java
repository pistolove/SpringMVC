package com.crys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.crys.model.User;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/view")
	public void add(Model model) {
		User user = new User();
		user.setId(20);
		user.setName("jack");
		log.info("age="+user.getId()+";name="+user.getName());
		this.facadeService.getLoginService().addUser(user);
	}
}
