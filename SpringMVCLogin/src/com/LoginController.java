package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value="/open", method=RequestMethod.GET)
	public ModelAndView openForm(LoginBean lb, ModelMap mm){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp");
		mm.addAttribute("login",lb);
		return mav;
	}
	
	@RequestMapping(value="/open",method=RequestMethod.POST)
	public ModelAndView checkLogin(LoginBean lb,ModelMap mm){
		ModelAndView mav = null;
		mm.addAttribute("login",lb);
		if(lb.getUname().equals("Raj") && lb.getPass().equals("123")){
			mav = new ModelAndView("success.jsp");
		}else{
			mav = new ModelAndView("failure.jsp");
		}
		return mav;
	}
}
