<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style type="text/css">
	body {
		color: #fff;
		background: #3598dc;
		font-family: 'Roboto', sans-serif;
	}
	/*div{ border: 1px solid white;}*/
	.wrap{
		padding-top: 300px;
		width: 1500px; height: 1000px;
		margin: 0 auto;
		display: flex;
		justify-content: center;
	}
	.findId{
	 width:45%; height: 500px;
	 margin-right: 20px;
	 border: 1px solid white;
	 padding-top: 50px;
	}
	.findPwd{
	 width:45%; height: 500px;
	 border: 1px solid white;
	 padding-top: 50px;
	}	
	
	 .form-control{
		height: 41px;
		background: #f2f2f2;
		box-shadow: none !important;
		border: none;
	}
	.form-control:focus{
		background: #e2e2e2;
	}
    .form-control, .btn{        
        border-radius: 3px;
    }
	.signup-form{
		width: 390px;
		margin: 30px auto;
	}
	.signup-form form{
		color: #999;
		border-radius: 3px;
    	margin-bottom: 15px;
        background: #fff;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
	.signup-form h2 {
		color: #333;
		font-weight: bold;
        margin-top: 0;
    }
    .signup-form hr {
        margin: 0 -30px 20px;
    }    
	.signup-form .form-group{
		margin-bottom: 20px;
	}
	.signup-form input[type="checkbox"]{
		margin-top: 3px;
	}
	.signup-form .row div:first-child{
		padding-right: 10px;
	}
	.signup-form .row div:last-child{
		padding-left: 10px;
	}
    .signup-form .btn{        
        font-size: 16px;
        font-weight: bold;
		background: #3598dc;
		border: none;
		min-width: 140px;
    }
	.signup-form .btn:hover, .signup-form .btn:focus{
		background: #2389cd !important;
        outline: none;
	}
    .signup-form a{
		color: #fff;
		text-decoration: underline;
	}
	.signup-form a:hover{
		text-decoration: none;
	}
	.signup-form form a{
		color: #3598dc;
		text-decoration: none;
	}	
	.signup-form form a:hover{
		text-decoration: underline;
	}
    .signup-form .hint-text {
		padding-bottom: 15px;
		text-align: center;
    }
</style>
<script type="text/javascript">
function findId(){
	 let form = {"name" : $('#name').val(), "email" : $('#idEmail').val()}
	 $.ajax({
			url:"findId", type:"POST", dataType:"json",
			data:JSON.stringify(form),
			contentType:"application/json;charset=utf-8",
			success: function(rep){
				if(rep.result != 'null'){
					alert('고객님의 아이디는 '+rep.result+'입니다.');
				}else{
					alert('찾으시는 아이디가 없습니다. 정보를 정확히 입력하세요');
				}
			}, error:function(){
				alert('문제 발생')
			}
		})
}

function findPwd(){
	 let form = {"id" : $('#id').val(), "email" : $('#pwdEmail').val()}
	 $.ajax({
			url:"findPw", type:"POST", dataType:"json",
			data:JSON.stringify(form),
			contentType:"application/json;charset=utf-8",
			success: function(rep){
				if(rep.result != 'null'){
					alert('가입하신 메일로 임시 비밀번호가 전송되었습니다.');
				}else{
					alert('찾으시는 가입 정보가 없습니다.');
				}
			}, error:function(){
				alert('문제 발생')
			}
		})
}


</script>

</head>
<body>
<div class="wrap">
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
	<div class="findId">
		
<div class="signup-form">
    <form action="${contextPath}/member/memberReg" method="post">
		<h2>Find ID</h2>
		<p>Please fill in this form to find an account!</p>
		<hr>
		<div class="form-group">
        	<input type="text" class="form-control" id="name" name="name" placeholder="Name" required="required">
        </div>
        <div class="form-group">
        	<input type="email" class="form-control" id="idEmail" name="idEmail" placeholder="Email" required="required">
        </div>
		<div class="form-group">
            <button type="button" class="btn btn-primary btn-lg" onclick="findId()">Find ID</button>
        </div>
    </form>
	<div class="hint-text">Already have an account? <a href="${contextPath}/member/login">Login here</a></div>
</div>
	
	</div>
	<div class="findPwd">
	<div class="signup-form">
    <form action="${contextPath}/member/memberReg" method="post">
		<h2>Find Password</h2>
		<p>Please fill in this form to find an account!</p>
		<hr>
		<div class="form-group">
        	<input type="text" class="form-control" id="id" name="id" placeholder="input ID" required="required">
        </div>
        <div class="form-group">
        	<input type="email" class="form-control" id="pwdEmail" name="pwdEmail" placeholder="Email" required="required">
        </div>
		<div class="form-group">
            <button type="button" class="btn btn-primary btn-lg" onclick="findPwd()">Find Password</button>
        </div>
    </form>
	<div class="hint-text">Already have an account? <a href="${contextPath}/member/login">Login here</a></div>
</div>
	</div>

</div>
</body>
</html>