<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		input {
			width: 50px;
			height: 50px;
			font-size: 40px;
			text-align: center;
		}
	</style>
</head>
<body>
	${input }
	<button>제출</button>
	<div>
		<c:forEach var="hint" items="${hint }">
		<h3>${hint }</h3>		
		</c:forEach>
	</div>
	
	<script>
		var result = `${word }`;
		document.querySelector('button').addEventListener('click',
		function(){
			var input = document.querySelectorAll('.input');
			
			for(let i = 0; i<5; i++){
				if(input[i].value == result[i]){
					input[i].style.background = 'green';
					input[i].setAttribute("readonly", "true");
				}else if(result.includes(input[i].value)){
					input[i].style.background = 'yellow';
				}else {
					input[i].style.background = 'lightgrey';
				}
			}
		})
	</script>
</body>
</html>