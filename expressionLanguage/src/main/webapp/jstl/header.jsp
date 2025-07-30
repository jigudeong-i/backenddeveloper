<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>JSTL Core: import(header.jsp)</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
		
		<style type="text/css">
			div{color:blud;}
		</style>
	</head>
	<body>
		<c:if test="${param.id != null}"> <!-- id를 받아왔다면 -->
			<hr />
			<div> ${param.id} 님의 방문을 환영합니다.</div>
			<hr />
		</c:if>
	</body>
</html>

<!-- 출력 안 되는게 정상. import.jsp 돌려볼 것 -->