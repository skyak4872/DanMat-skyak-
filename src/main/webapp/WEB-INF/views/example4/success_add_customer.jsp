<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h3>회원가입</h3>
	<p>회원가입 성공</p>
	<p>이메일: ${customerCommand.email }</p>
	<p>비밀번호: ${customerCommand.passwd }</p>
	<p>이름 : ${customerCommand.name }</p>
	<p>주민번호 : ${customerCommand.ssn }</p>
	<p>전화번호 : ${customerCommand.phone }</p>
</body>
</html>