<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style type="text/css">
  div{border: 1px solid black}
  .wrap{width: 1500px; height: 1500px; margin: 0 auto;}
  .login{width: 500px; height: 300px; margin: auto; margin-top: 200px;}
  </style>
  <script type="text/javascript">
  function login(){
	  var inputId = document.getElementById("id").value;
	  var inputPwd = document.getElementById("pwd").value;
	  if(inputId.length == 0  || inputPwd.length == 0){
		  alert('로그인 정보를 정확히 입력하세요')
	  }else{
		  loginChk.submit();
	  }
  }
  
  function register(){
	  location.href="register";
  }
  </script>
</head>

<body>
	<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
	<div class="wrap">
		<div class="login">
		<form action="member/loginChk" method="post" id="loginChk">
		아이디 : <input type="text" name="id" id="id"> <br>
		비밀번호 : <input type="password" name="pwd" id="pwd"><br>
		<input type="button" value="로그인" onclick="login()"> <input type="button" value="회원가입" onclick="register()">
		</form>
		</div>
	</div>
</body>
</html>