<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>JSTL Core: out(out.jsp)</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
		<h2>JSTL Core Tag: out</h2> 
		
		<c:out value="<hr />" escapeXml="true"/>
		<c:out value="<hr />" escapeXml="false" />
		
		<p>
		<c:out value="${param.userid}">
			파라미터값이 존재하지 않습니다.
		</c:out>
		</p>
		
		<c:out value="${param.userid}" default="파라미터값이 존재하지 않습니다." />
		<p>\${param.userid} = ${param.userid}</p>
		
	</body>
</html>