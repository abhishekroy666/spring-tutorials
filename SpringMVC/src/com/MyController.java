package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping(value="/welcome")
	public ModelAndView sayHello(){
		System.out.println("Hello");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("display.jsp");
		return mav;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView checkLogin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = null;
		String user = request.getParameter("uname");
		String pass = request.getParameter("pass");
		if(user.equals("Raj") && pass.equals("123")){
			mav = new ModelAndView("success.jsp");
		}else{
			mav = new ModelAndView("failure.jsp");
		}
		return mav;
	}
}
