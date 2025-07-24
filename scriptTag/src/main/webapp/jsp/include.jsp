<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>JSP 예제 - include.jsp</title>
	</head>
	<body>
	
		<%@ include file="header.jsp" %>
		<hr />
		<p>사이트의 본문 내용</p>
		<hr />
		<%@ include file="footer.jsp" %>		
		
	</body>
</html>

<!-- 
서블릿 메모장 가보면..

out.write("<div id=\"header\">\r\n");
out.write("	<h2>JSP 지시자 예제</h2>\r\n");
out.write("</div>");

out.write("<div id=\"copyright\">\r\n");
out.write("	Copyright &copy; 2022 KH, Inc. All rights reserved.\r\n");
out.write("	Contact webmaster for more information.\r\n");
out.write("</div>");
-->