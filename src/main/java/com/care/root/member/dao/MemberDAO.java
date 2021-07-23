package com.care.root.member.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.care.root.member.dto.MemberDTO;

public interface MemberDAO {
	public MemberDTO loginChk(@Param("id") String id);
	public int idChk(@Param("id")String id);
	public int memberReg(Map<String, Object>map);
	public String findId(@Param("name")String name, @Param("email")String email);
	public String findPw(@Param("id")String id, @Param("email")String email);
	public int tempPwUdate(@Param("tempPw")String tempPw, @Param("id")String id);
}
