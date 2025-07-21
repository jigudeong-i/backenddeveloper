<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			int a = (int)(Math.random() * 100);
			int b = (int)(Math.random() * 100);
			int c = (int)(Math.random() * 100);
			int d = Math.max(Math.max(a, b), c);
			out.print(d);

			int [] apple = {12,26,68,98,76,54,8,6,4};
			int max = apple[0];
			
			// 배열의 최댓값을 구하라. 
			
			
		%>
	</body>
</html>