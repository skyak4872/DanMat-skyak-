<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberShip Find User Id</title>
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/signIn.css'/>">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
</head>
<body>
	<form action="findId" method="POST">
  <div class="wrap">
       <div class="login">
           <h2>Find ID</h2>
           <div class="login_id">
               <h4>이메일</h4>
               <input type="email" placeholder="이메일 형식을 입력해주세요." name="email" maxlength="20"/><br>
           </div>
           <div class="login_etc">
               <a href="signUp">회원가입</a>
               <div class="checkbox">
                 <a href="logIn" style="margin-left: 40px;" >로그인</a>
               </div>
               <div class="forgot_pw">
                 <a href="findPassword" style="margin-left: 40px;">비밀번호 찾기</a>
           </div>
           </div>
           <div class="submit">
             <input type="submit" value="다음" style="cursor: pointer;">
             <p class="main"><a href="main">메인페이지</a></p>
           </div>
       </div>
   </div>
	</form>
</body>
</html>
