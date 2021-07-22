package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.service.MemberService;


@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberService ms;
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	@RequestMapping("login")
		public String login() {
		
		return "member/login";
	}
	@PostMapping("loginChk")
	public String loginChk(HttpServletResponse response, HttpServletRequest request,HttpSession session) {
		int result = ms.loginChk(request, response, session);
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pwd"));
		System.out.println(request.getParameter("rememberId"));
		System.out.println(result);
		if(result == 0) {
			return "redirect:main";
		}else{
			return "redirect:login";
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
	
	@PostMapping("memberReg")
	public String memberReg(){
		
		return "member/login";
	}
}
