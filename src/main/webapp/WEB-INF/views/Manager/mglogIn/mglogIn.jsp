<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Login</title>
  <link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/signIn.css'/>">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
</head>
<body>
  	<form action="mglogin" method="POST">
  <div class="wrap">
       <div class="login">
           <h2>Admin</h2>
           <div class="login_id">
               <h4>아이디</h4>
               <input type="text" name="mgid" placeholder="관리자 아이디를 입력하세요." minlength="5" maxlength="20" pattern="^[a-zA-Z0-9]+$"/><br>
           </div>
           <div class="login_pw">
               <h4>비밀번호</h4>
               <input type="password" name="mgpasswd" placeholder="관리자 비밀번호를 입력하세요." minlength="5" maxlength="16" pattern="^[a-zA-Z0-9]+$"/><br>
           </div>
           <div class="submit">
             <input type="submit" value="로그인" style="cursor: pointer;">
           </div>
       </div>
   </div>
	</form>
</body>
</html>
