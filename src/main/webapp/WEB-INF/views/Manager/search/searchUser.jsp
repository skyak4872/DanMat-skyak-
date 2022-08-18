<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search User</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/signIn.css'/>">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
</head>
<body>
	<form action="searchUser" method="POST">
  		<div class="wrap">
        	 <h4>ID</h4>
        	 <input type="id" name="id" maxlength="20"/><br>
             <h4>이메일</h4>
             <input type="email" name="email" maxlength="20"/><br>
        </div>
           <div class="submit">
             <input type="submit" value="확인" style="cursor: pointer;">
             <p class="mgMain"><a href="mgMain">메인페이지</a></p>
           </div>
	</form>
</body>
</html>
