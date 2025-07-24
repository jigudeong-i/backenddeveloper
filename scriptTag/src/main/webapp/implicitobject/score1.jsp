<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title>스크립트릿을 활용한 학점 구하기 예제 - score1.jsp</title>
		<link href="/scriptTag/image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
		<% String hakjum = (String)request.getAttribute("hakjum"); %>
		<div>입력한 점수는 <%= request.getParameter("score") %>입니다</div>
		<div>학점은 <%=hakjum%>입니다.</div>
	</body>
</html>


