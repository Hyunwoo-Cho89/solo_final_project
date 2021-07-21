package com.care.root.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Override
	public int loginChk(HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		return 1;
	}

}
