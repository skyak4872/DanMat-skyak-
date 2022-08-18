<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search User list</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/signIn.css'/>">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
</head>
<body>
<form:form  action="searchUser" method="Post">
		<select name="type">
			<option>--선택--</option>
			<option name="type" value="Id">아이디</option>
			<option name="type" value="Email">이메일</option>
		</select>
			<input type="text" name="Name"/>
			<input type="submit" value="검색">
	</form:form>
  <div class="wrap">
       <div class="img"><img src="<c:url value='/resources/images/logo_transparent.png'/>" alt=""></div>
      		<c:forEach var="searchList" items="${user_list }">
           <h3 class="searchInfo"> 유저 목록</h3>
           <br><p>아이디: ${searchList.userid }</p>
           <br><p>이메일: ${searchList.email }</p>
            </c:forEach>
           </div>

           <div class="submit">
             <p class="mgMain"><a href="mgMain" style="color: #fff;">메인페이지</a></p>
           </div>
</body>
</html>
