package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginValidationController {
	@RequestMapping(method = RequestMethod.POST, value = "/validate")
	public String validate(@RequestParam("userName")String uid, @RequestParam("password")String pwd){
		if(uid.equals("admin") && pwd.equals("administrator")){
			return "success";
		}
		else {
			return "failure";
		}
	}
}
