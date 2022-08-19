<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search User Information</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/signIn.css'/>">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
</head>
<body>
  		<div class="wrap">
    	   <div class="img"><img src="<c:url value='/resources/images/logo_transparent.png'/>" alt=""></div>
    	   <h3 class="searchInfo">회원님의 아이디 정보는 <br> '${searchEmail.userId }' 입니다.</h3>
    	   <h3 class="searchInfo">회원님의 이메일 정보는 <br> '${searchEmail.email }' 입니다.</h3>
             <p class="mgMain"><a href="/Manager/mgMain" style="color: #fff;">메인페이지</a></p>
           </div>
      </div>
	</form>
</body>
</html>
