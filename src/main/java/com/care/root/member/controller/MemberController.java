package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.member.service.MemberService;


@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberService ms;
	
	@RequestMapping("login")
		public String login() {
		
		return "member/login";
	}
	@PostMapping("loginChk")
	public String loginChk(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		int result = ms.loginChk(request, session);
		if(result == 1) {
			return "main";
		}else {
			return "login";
		}
		
		
	}
	@RequestMapping("register")
	public String register() {
		
		return "member/register";
	}
	@RequestMapping("findAccount")
	public String findAccount() {
		
		return "member/findAccount";
	}
}
