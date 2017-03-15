package com.bit2017.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2017.jblog.service.UserService;
import com.bit2017.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("/joinform")
	public String joinform(@ModelAttribute UserVo vo) {
		
		return "/user/join";
	}

	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo vo) {
		System.out.println("첫번쨰 나냐??" + vo);
		service.join(vo);
		System.out.println("왜 오류나냐 " + vo); 
		 return "/user/joinsuccess"; 
	}
 
	@RequestMapping("/loginform")
	public String login() {
		return "/user/login";
	} 
}
