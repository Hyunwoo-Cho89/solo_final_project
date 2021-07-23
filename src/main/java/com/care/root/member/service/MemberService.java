package com.care.root.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface MemberService {
	public String loginChk(HttpServletRequest request, HttpServletResponse response,HttpSession session);
	public int idChk(String id);
	public String memberReg(HttpServletRequest request, HttpServletResponse response);
	public String findId(Map<String, Object> map);
	public String findPw(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response);
}
