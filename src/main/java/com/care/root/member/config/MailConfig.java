package com.care.root.member.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		jms.setHost("smtp.gmail.com");	//google stmp 서버 설정
		jms.setPort(587);	//google smtp 메일 서버 포트
		jms.setUsername("*");
		jms.setPassword("*");
		
		/** 메일 전달 프로토콜 세부 설정 */
		Properties prop = new Properties();	
		prop.setProperty("mail.transport.protocol", "smtp");	//메일 사용
		prop.setProperty("mail.smtp.auth", "true");	//사용자 인증 시도
		prop.setProperty("mail.smtp.starttls.enable", "true");	//tls 방식으로 처리 | tls : 명시적 보안
		//prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");	//오류 뜰 때 추가해 보기
		//prop.setProperty("mail.debug", "true");
		
		jms.setJavaMailProperties(prop);
		
		return jms;
	}
}
