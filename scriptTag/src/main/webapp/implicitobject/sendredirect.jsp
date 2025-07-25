<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title>예제 sendredirect.jsp</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
	</head> 
	<body>
	<% 
		String URL = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8";
		String keyword = request.getParameter("word");
		URL += "&query=" + keyword; 
		response.sendRedirect(URL);
	%>
	</body>
</html>

