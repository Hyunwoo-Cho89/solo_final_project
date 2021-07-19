package com.care.root.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {

	@RequestMapping("login")
		public String login() {
		
		return "member/login";
	}
	@PostMapping("loginChk")
	public String loginChk(HttpSession session, Model model) {
		
		
		return null;
	}
	@RequestMapping("register")
	public String register() {
		
		return "member/register";
	}
}
