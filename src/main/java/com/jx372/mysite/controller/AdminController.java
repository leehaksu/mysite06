package com.jx372.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main()
	{
		return "/admin/main";
	}

}
