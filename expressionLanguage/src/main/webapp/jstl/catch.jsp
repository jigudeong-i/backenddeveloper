<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>JSTL Core Tag: catch</h3>
		
		<c:catch var="errMessage">
			<%--= 2/0 --%>
			<%=request.getParameter("userName").toLowerCase() %>
		</c:catch>
		
		<p>
		<c:if test="${not empty errMessage}">
			예외가 발생하였습니다.
			예외 메시지 : <hr />
			${errMessage}
		</c:if>
		</p>
	</body>
</html>