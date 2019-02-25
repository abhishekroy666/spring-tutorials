package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@RequestMapping(value="/open", method=RequestMethod.GET)
	public ModelAndView openForm(Employee emp, ModelMap mm){
		ModelAndView mav = new ModelAndView("emp.jsp");
		mm.addAttribute("employee",emp);
		System.out.println("Form Opened");
		return mav;
	}
	
	@RequestMapping(value="/open", method=RequestMethod.POST)
	public ModelAndView storeEmp(Employee emp, ModelMap mm){
		ModelAndView mav = new ModelAndView("emp.jsp");
		System.out.println(emp.getEmpName());
		mm.addAttribute("employee",emp);
		empService.storeEmpService(emp);
		System.out.println("Employee Stored");
		return mav;
	}
	
}
