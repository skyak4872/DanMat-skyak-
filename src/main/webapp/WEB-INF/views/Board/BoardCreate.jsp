<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
.center{
margin: 5px 25px; padding: 20px
}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Create</title>
</head>
<body>
    <form:form class="center" method="post">
        <h2>게시글 작성</h2>
        <form:form method="post" modelAttribute="board">
        	<label>유저id</label><form:input path="userId" value="session.userId"/><br>
        	<label>제목</label><form:input path="title"/><br> 
        	<label>내용</label><form:input path="content"/><br>  
    		<button type="submit" class="btn btn-outline-info">등록</button>
     	</form:form>       
    </form:form>
    <button type="button" class="btn btn-outline-info"><a href="/dm/board/">돌아가기</a></button>
</body>
</html>