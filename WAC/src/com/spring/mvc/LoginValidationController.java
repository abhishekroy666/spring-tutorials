package com.spring.mvc;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.msg.MyMessage;
import com.user.MyUser;

@Controller
@SessionAttributes("currentUser")

public class LoginValidationController implements ServletContextAware{
		private ServletContext ctx;
	@RequestMapping(method = RequestMethod.POST, value = "/validate")
	public String validate(@RequestParam("userName")String uid, @RequestParam("password")String pwd, Model model){
		WebApplicationContext wctx = WebApplicationContextUtils.getWebApplicationContext(ctx);
		
		System.out.println("validate() called...");
		if(uid.equals("admin") && pwd.equals("administrator")){
			MyMessage m1 = (MyMessage)wctx.getBean("successMsg");
			MyUser user = (MyUser)wctx.getBean("userBean");
			MyUser mu = (MyUser)wctx.getBean("uBean");
			
			user.setUserName(uid);
			mu.setUserName(uid);
			model.addAttribute("message", m1);
			model.addAttribute("currentUser", user);
			return "success";
		}
		else {
			MyMessage m1 =(MyMessage)wctx.getBean("failureMsg");
			model.addAttribute("message", m1);
			return "failure";
		}
	}

	@Override
	public void setServletContext(ServletContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("Inside setSerletContext()");
		this.ctx = ctx;
		
	}
}
