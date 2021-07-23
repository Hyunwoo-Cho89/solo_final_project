package com.care.root.member.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO mapper;
	@Autowired JavaMailSender mailSender;
	
	@Override
	public String loginChk(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String message = null;
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
					message = "<script>location.href='"+request.getContextPath()+
								"/member/main';</script>";
				} else {
					message = "<script>alert('비밀번호가 일치하지 않습니다. 다시 확인해 주세요.');";
					message += "location.href='"+request.getContextPath()+
								"/member/login';</script>";
				}
			} else {
				message = "<script>alert('존재하지 않는 아이디입니다. 다시 확인해 주세요.');";
				message += "location.href='"+request.getContextPath()+
							"/member/login';</script>";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public int idChk(String id) {
		
		return mapper.idChk(id);
	}

	@Override
	public String memberReg(HttpServletRequest request, HttpServletResponse response) {
		String message = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", request.getParameter("id"));
		map.put("name", request.getParameter("familyName")+request.getParameter("firstName"));
		map.put("email", request.getParameter("email"));
		map.put("pw", request.getParameter("pwd"));
		
		int result = mapper.memberReg(map);
		if(result != 1) {
			message = "<script>alert('회원가입 오류 발생. 다시 등록 하세요.');";
			message += "location.href='"+request.getContextPath()+
						"/member/register';</script>";
		}else {
			message = "<script>alert('회원가입 완료! 환영합니다.');";
			message += "location.href='"+request.getContextPath()+
						"/member/login';</script>";
		}
		return message;
	}

	@Override
	public String findId(Map<String, Object> map) {
		System.out.println((String)map.get("name"));
		System.out.println((String)map.get("email"));
		return mapper.findId((String)map.get("name"), (String)map.get("email"));
	}

	@Override
	public String findPw(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
		String pw = mapper.findPw((String)map.get("id"), (String)map.get("email"));
		String name = (String)map.get("id");
		String email = (String)map.get("email");
		if(pw != null) {
			//임시 비밀번호 발급 후 전송
			
			//7자리 임시 비밀번호 발급
			//StringBuffer tempPw = new StringBuffer();
			String tempPw = "";
			Random rnd = new Random();
			for (int i = 0; i < 7; i++) {
			    int rIndex = rnd.nextInt(3);
			    switch (rIndex) {
			    case 0:
			        // a-z
			        //tempPw.append((char) ((int) (rnd.nextInt(26)) + 97));
			        tempPw += ((char) ((int) (rnd.nextInt(26)) + 97));
			        break;
			    case 1:
			        // A-Z
			        //tempPw.append((char) ((int) (rnd.nextInt(26)) + 65));
			    	tempPw += ((char) ((int) (rnd.nextInt(26)) + 97));
			        break;
			    case 2:
			        // 0-9
			        //tempPw.append((rnd.nextInt(10)));
			    	tempPw += ((char) ((int) (rnd.nextInt(26)) + 97));
			        break;
			    }
			}
			System.out.println(tempPw);

			//임시 비밀번호 메일 전송
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.setContentType("text/html;charset=utf-8");
			//PrintWriter out = response.getWriter();	//사용자에게 응답을 하기 위해 writer를 얻어온 뒤 printWriter로 응답
			String str = "";
			str += "<html><body>";
			str += "<h2>" + name + " 님의 임시 비밀번호</h2>";
			str += "비밀번호 찾기를 통해 임시 비밀번호가 발급되었습니다.<br>";
			str += "보안을 위해 정보 수정에서 비밀번호를 다시 변경해 주세요.<br>";
			str += "발급된 임시 비밀번호 : <font style=\"color:blue;\"><u>" + tempPw;
			str += "</u></font></body></html>";

			sendMail(email, name + " 님 커뮤니티 임시 비밀번호 발급", str);
			System.out.println("메일 발송 성공");
			
			int result = mapper.tempPwUdate(tempPw, (String)map.get("id"));
			if(result == 1) {
				System.out.println("업데이트 성공");
			}
			else {
				System.out.println("업데이트 실패");
			}
		}
		return pw;
	}
	
	private void sendMail(String to, String title, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject(title);
			messageHelper.setTo(to);
			messageHelper.setText(body, true);	//true : HTML 태그를 번역한 뒤 메일을 보내기 위함
			mailSender.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
