package com.crys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crys.cache.CacheUnit;
import com.crys.model.User;
import com.crys.response.Response;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping("/add")
	public String insert(HttpServletRequest request,HttpSession session) {
		User user = new User();
		user.setId(1);
		user.setName("jack");
		log.info("age="+user.getId()+";name="+user.getName());
		this.facadeService.getLoginService().addUser(user);
		session.setAttribute("user", user);
		return "insert";
	}
	
	@RequestMapping("/get")
	public String get() {
		User user = this.facadeService.getLoginService().getUser(1);
		log.info("get: "+user.getId()+"---"+user.getName());
		System.err.println("get: "+user.getId()+"---"+user.getName());
		
		return "get";

	}
	
	@RequestMapping("/delete")
	public String delete() {
		this.facadeService.getLoginService().deleteUser(1);
		log.info("delete: "+1);
		System.err.println("delete: "+1);
		
		return "delete";
	}
	
	@RequestMapping("/update")
	public String update() {
		User user = this.facadeService.getLoginService().getUser(1);
		user.setName("jone");
		log.info("age="+user.getId()+";name="+user.getName());
		this.facadeService.getLoginService().updateUser(user);
		
		return "update";
	}
	
	
    @RequestMapping(value = "/cache")
    public Response<String> data(HttpServletRequest request, @RequestParam(value = "id", required = false) String id,
            Model model1, Model model2) {
        log.info("request:data:" + id);
        CacheUnit tpCache = this.facadeService.getLoginService().testTpCache("key1");
        Response<String> response = new Response<String>();
        response.setErrorCode("001");
        response.setData(id + "," + tpCache.getName());
        model1.addAttribute("testkey1", "testvalue1");
        model2.addAttribute("testkey2", "testvalue2");

        return response;
    }
	
}
