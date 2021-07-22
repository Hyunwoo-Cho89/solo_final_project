package com.care.root.member.service;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO mapper;
	
	@Override
	public int loginChk(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		int result = 0;
		try {
			MemberDTO dto = mapper.loginChk(request.getParameter("id"));
			
			if(dto != null) {
				// 암호화 되기 전 코드, 암호화 완료 시 수정 필요!
				if(request.getParameter("pwd").equals(dto.getPw())) {
					session.setAttribute("loginUser", request.getParameter("id"));
					if(request.getParameter("rememberId") != null){
						int limitTime = 60 * 60 * 24 * 90;	//90일 동안 세션 유지
						Cookie loginCookie = new Cookie("loginCookie", session.getId());
						loginCookie.setPath("/");
						loginCookie.setMaxAge(limitTime);
						response.addCookie(loginCookie);
					}else {
						int limitTime = 0;	//쿠키 삭제
						Cookie loginCookie = new Cookie("loginCookie", session.getId());
						loginCookie.setPath("/");
						loginCookie.setMaxAge(limitTime);
						response.addCookie(loginCookie);
					}
					result = 0;
				} else {
					PrintWriter out = response.getWriter();
						out.print("<script>alert('비밀번호가 일치하지 않습니다. 다시 확인해 주세요.')</script>");
					result = 1;
				}
			} else {
				PrintWriter out = response.getWriter();
					out.print("<script>alert('존재하지 않는 아이디입니다. 다시 확인해 주세요.')</script>");
				result = 2;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
