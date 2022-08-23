<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		div input.input {
			width: 50px;
			height: 50px;
			font-size: 40px;
			text-align: center;
		}
		
		.life {
			position: absolute;
		}
		button {
			width: 150px;
			height: 50px;
			background-color: #cb99c5;
			box-shadow: 0 0 0 1px #cb99c5 inset,
				 0 0 0 2px rgba(255, 255, 255, 0.15) inset,
				 0 8px 0 0 rgba(189, 142, 183, .7),
				 0 8px 0 1px rgba(0,0,0, .4),
				 0 8px 8px 1px rgba(0,0,0,0.5);
		}
		button:active {
			box-shadow: 0 0 0 1px #cb99c5 inset,
				0 0 0 2px rgba(255,255,255,0.15) inset,
				0 0 0 1px rgba(0,0,0,0.4);'
		}
		
		#Exit
	</style>
</head> 
<body>
	<div class="life">
		<label>남은 횟수:</label>
		<p Id="life">${life }</p>
	</div>
	<div class="text">
	${input }
	</div>
	<button>입력</button>
	<form method="get" action="/Danmat/main">
	<input type="hidden" id="Exit" value="종료"/>
	</form>
	<div class="text-area">
	<c:forEach items="${hint }" var="hint">
		<h3 class="hint" hidden>${hint }</h3>
	</c:forEach>
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