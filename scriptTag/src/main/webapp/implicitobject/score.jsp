<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<% 
	String apple = request.getParameter("score"); 
	int score = 0;
	if(apple != null){
		score = Integer.parseInt(apple);
	}
%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title>스크립트릿을 활용한 학점 구하기 예제 - score.jsp</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
	</head>  
	<body>
		<%
			String hakjum = "";
			if(score >= 90 && score <= 100){
				hakjum = "A";
			} else if(score >= 80){
				hakjum = "B";
			} else if(score >= 70){
				hakjum = "C";
			} else if(score >= 60){
				hakjum = "D";
			} else {
				hakjum = "F";
			}
			
			//out.print("<div>입력한 점수는 " + score +"입니다</div>");
			//out.print("<div>입력한 점수는 " + hakjum + "입니다</div>");
		%>
		<div>입력한 점수는 <%= score %>입니다</div>
		<div>학점은 <%= hakjum %>입니다.</div>
		
	</body>
</html>