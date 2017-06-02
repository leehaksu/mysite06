package com.jx372.mysite.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jx372.mysite.service.UserService;
import com.jx372.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	//로그 생성
	private static final Log LOG = LogFactory.getLog(UserController.class );
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String Join() {
		return "/user/join";
	}
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String Join(@ModelAttribute UserVo uservo) {
		userService.join(uservo);
		return "redirect:/user/joinsuccess";
	}
	@RequestMapping(value = "/joinsuccess", method = RequestMethod.GET)
	public String Joinsuccess() {
		return "/user/joinsuccess";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "/user/login";
	}
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String auth(HttpSession httpsession,@ModelAttribute UserVo uservo) {
		uservo=userService.login(uservo, httpsession);
		LOG.debug(uservo);
		httpsession.setAttribute("authUser", uservo);
		return "redirect:/main";
	}
	//@Auth
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(HttpSession authUser, @ModelAttribute UserVo uservo,Model model)
	{
		uservo=(UserVo) authUser.getAttribute("authUser");
		uservo=userService.getInformData(uservo);
		model.addAttribute("no",uservo.getNo());
		model.addAttribute("email",uservo.getEmail());
		model.addAttribute("gender",uservo.getGender());
		return "/user/modify";
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpSession httpsession,@ModelAttribute UserVo uservo)
	{
		userService.modify(uservo);
		uservo=userService.getInformData(uservo);
		httpsession.setAttribute("authUser", uservo);
		return "redirect:/main";
	}
}
