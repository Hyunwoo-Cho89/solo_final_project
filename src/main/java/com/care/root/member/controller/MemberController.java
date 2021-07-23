package com.care.root.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public void loginChk(HttpServletResponse response, HttpServletRequest request,HttpSession session) throws Exception {
		String message = ms.loginChk(request, response, session);
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pwd"));
		System.out.println(request.getParameter("rememberId"));
		//System.out.println(result);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		out.print(message);
	}
	
	@RequestMapping("register")
	public String register() {
		
		return "member/register";
	}
	
	@PostMapping("memberReg")
	public void memberReg(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String message = ms.memberReg(request, response);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		out.print(message);
		
	}
	
	@PostMapping(value="idChk", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String idChk(@RequestBody Map<String,Object> map, HttpServletResponse response, HttpServletRequest request) {
		int result = ms.idChk((String)map.get("id"));
		String result2 = result+"";
		
		return "{\"result\":\"" + result2 + "\"}";
		
	}
	
	@RequestMapping("findAccount")
	public String findAccount() {
		
		return "member/findAccount";
	}
	
	@PostMapping(value="findId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findId(@RequestBody Map<String,Object> map, HttpServletResponse response, HttpServletRequest request) {
		String id = ms.findId(map);
		
		return "{\"result\":\"" + id + "\"}";
	}
	
	@PostMapping(value="findPw", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findPw(@RequestBody Map <String,Object> map, HttpServletRequest request,  HttpServletResponse response) {
		String tempPw = ms.findPw(map, request, response);
		return "{\"result\":\"" + tempPw + "\"}";
	}
}
