<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인 페이지</title>
</head>
<body>
<h1>
Admin Main
</h1>
	<P>${serverTime}</P>
	<form action="mgMain" method="get">
	<a href="/Danmat/manager/searchUser">회원 관리</a><br><br>
	<a href="/danmat/category/add_category">카테고리</a><br>
	<a href="/Danmat/main">Main</a>
	</form>
</body>
</html> 