<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Bootstrap Simple Login Form with Blue Background</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style>
	body {
		color: #fff;
		background: #3598dc;
		font-family: 'Roboto', sans-serif;
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
 function idChk(){
	 let form = {"id" : $('#id').val()}
	 $.ajax({
			url:"idChk", type:"POST", dataType:"json",
			data:JSON.stringify(form),
			contentType:"application/json;charset=utf-8",
			success: function(rep){
				if(rep.result == '0'){
					$('#checkId').val('??????');
				}else{
					$('#checkId').val('?????? ?????? ??????');
					alert('?????? ???????????? ????????? ?????????.');
				}
			}, error:function(){
				alert('?????? ??????')
			}
		})
 }
 
 function register(){
	 let id = $('#checkId').val();
	 let pwd = $('#pwd').val();
	 let pwd2 = $('#pwd2').val();
	 if(id != "??????"){
		 alert("????????? ?????? ????????? ????????? ?????????.")
	 }else{
		 if(pwd != pwd2){
			 alert("??????????????? ???????????? ????????????.")
		 }else{
			fmt.submit();
		 }
		 
	 }
 }

</script>
</head>
<body>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<div class="signup-form">
    <form action="${contextPath}/member/memberReg" id="fmt" method="post">
		<h2>Sign Up</h2>
		<p>Please fill in this form to create an account!</p>
		<hr>
        <div class="form-group">
			<div class="row">
				<div class="col-xs-6"><input type="text" class="form-control" id="id" name="id" placeholder="Input ID" required="required"></div>
				<div class="col-xs-6"><input type="button" class="btn btn-primary btn-lg" id="checkId" value="?????? ?????? ??????" onclick="idChk()"></div>
			</div>        	
        </div>
        <div class="form-group">
			<div class="row">
				<div class="col-xs-6"><input type="text" class="form-control" name="familyName" placeholder="Family Name (???)" required="required"></div>
				<div class="col-xs-6"><input type="text" class="form-control" name="firstName" placeholder="First Name (??????)" required="required"></div>
			</div>        	
        </div>
        <div class="form-group">
        	<input type="email" class="form-control" name="email" placeholder="Email" required="required">
        </div>
		<div class="form-group">
            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password" required="required">
        </div>
		<div class="form-group">
            <input type="password" class="form-control" id="pwd2" name="confirm_password" placeholder="Confirm Password" required="required">
        </div>        
        <div class="form-group">
			<label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a></label>
		</div>
		<div class="form-group">
            <button type="button" class="btn btn-primary btn-lg" onclick="register()">Sign Up</button>
        </div>
    </form>
	<div class="hint-text">Already have an account? <a href="${contextPath}/member/login">Login here</a></div>
</div>
</body>
</html>