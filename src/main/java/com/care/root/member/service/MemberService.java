package com.care.root.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

public interface MemberService {
	public int loginChk(HttpServletRequest request, HttpSession session);
}
