package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginPageController {
	@RequestMapping(method = RequestMethod.GET, value="/login")
	public String getPage(){
		return "login";
	}
}
