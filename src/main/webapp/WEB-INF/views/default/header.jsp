<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<style type="text/css">
	div{border: solid 1px black;}
	.wrap{
		width: 1500px; height: 1500px;
		margin: 0 auto;
	}
</style>
</head>
<body>
<c:set var="contextPath" value="<%= request.getContextPath() %>"/>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="${contextPath}/member/main">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="${contextPath}/board/notice">Notice</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${contextPath}/board/freeBoard">Board</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${contextPath}/board/imageBoard">Gallery</a>
        </li>
      </ul>
      <form class="d-flex" style="align-items: flex-end;">
        <input class="form-control me-sm-2" type="text" placeholder="Search">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
</body>
</html>