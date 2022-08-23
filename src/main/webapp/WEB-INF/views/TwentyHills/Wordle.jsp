<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Danmat/resources/css/Wordle.css"/>
</head> 
<body>
	<div class="wrap">
		<div class="life">
			<label>남은 횟수:</label>
			<p Id="life">${life }</p>
		</div>
		<div class="text-area">
		<c:forEach items="${hint }" var="hint">
			<h3 class="hint" hidden>${hint }</h3>
		</c:forEach>
		</div>
		${input }
		<div class="btn">
		<button>입력</button>
		</div>
		<form method="get" action="/Danmat/main">
		<input type="hidden" id="Exit" value="종료"/>
		</form>
	</div>
	
	<script>
		var result = `${word }`;
		var count = 0;
		var h_count = 0;
		var life = ${life};
		document.querySelectorAll('.hint')[h_count].removeAttribute("hidden");
		document.querySelector('button').addEventListener('click',
		function(){
			var input = document.querySelectorAll('.input');
			
			for(let i = 0; i<result.length; i++){
				if(input[i].value == result[i]){
					input[i].style.background = 'green';
					count++;
				}else if(result.includes(input[i].value)){
					input[i].style.background = 'yellow';
				}else {
					input[i].style.background = 'lightgrey';
				}
			}
			h_count++;
			if(document.querySelectorAll(".hint").length <= h_count){
				alert("더 이상 힌트가 없습니다.");
			}else {
			document.querySelectorAll(".hint")[h_count].removeAttribute("hidden");				
			}
			if(result.length == count){
				alert("정답입니다. \n 총 점수 : " + (life*10) + "점 입니다.");
				document.querySelector('button').setAttribute("hidden", "true");
				document.querySelector('#Exit').setAttribute("type","submit");
				document.querySelector('p').setAttribute("hidden","true");
			}
			if(life > 0){
			life--;
			document.getElementById("life").innerHTML = life;
			}else {
				alert("Game Over");
				document.querySelector('button').setAttribute("hidden","true");
				document.querySelector('#Exit').setAttribute("type","submit");
			}
			count = 0;
		})
	</script>
</body>
</html>