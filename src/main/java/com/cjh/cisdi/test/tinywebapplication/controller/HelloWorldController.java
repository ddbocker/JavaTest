package com.cjh.cisdi.test.tinywebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("singlePerson",new Object());
        model.addAttribute("people",new Object());
		return "index";
	}

	@RequestMapping("/list")
	public String list(Model model) {
//		List<User> users = userService.getUserList();
//		model.addAttribute("users", users);
		return "list";
	}
	
	

}
