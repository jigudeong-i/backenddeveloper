<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>EL 예제 - scopeEL.jsp</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
		<h2>저장된 객체 추출</h2>
		<hr />
		<% 
			pageContext.setAttribute("message1", "PageContext 객체에 저장된 문자열객체"); 
			request.setAttribute("message", "HttpServletRequest 객체에 저장된 문자열객체");
			session.setAttribute("message3", "HttpSession 객체에 저장된 문자열객체");
			application.setAttribute("message", "ServletContext 객체에 저장된 문자열객체");
			
			//out.println((String)pageContext.getAttribute("message1") + "<br />");
			//out.println((String)request.getAttribute("message") + "<br />"); //...
		%>
		pageScope 객체에서 추출 : ${ pageScope.message1 }<br />
		requestScope 객체에서 추출 : ${ requestScope.message }<br />
		sessionScope 객체에서 추출 : ${ sessionScope.message3 }<br />
		applicationScope 객체에서 추출 : ${ applicationScope.message }<br />
		
		<hr />
		message 추출 : ${message}   <!-- 변수가 아닌 '속성' -->
	</body>
</html>



