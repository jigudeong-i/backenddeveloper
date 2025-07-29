<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>JSTL Core: if/choose (if.jsp)</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
		<h3>JSTL Core Tag: if</h3>
		
		<c:set var="num" value="95" />
		표현언어: ${num > 60} <br />
		점수 ${num}은 

		<c:if test="${num > 60}" var="result">
 			합격입니다.<br />
		</c:if>
		if문의 결과 : ${result}<br />
		
		<c:set var="number" value="4" />
		숫자 ${number}은
		<c:if test="${number mod 2 == 0}">
 			짝수
		</c:if>
		<c:if test="${number mod 2 != 0}">
 			홀수
		</c:if>
		입니다. <br />
				
		<h3>JSTL Core Tag: choose</h3>
	
		<%-- <c:set var="today" value="<%= new java.util.Date()%>" /> --%>
		<jsp:useBean id="today" class="java.util.Date" />
		<c:choose> 
		  <c:when test="${today.hours < 12 }" >
			Good morning!
		  </c:when> 
		  <c:when test="${today.hours < 18 }" > 
			Good afternoon!
		  </c:when> 
		  <c:otherwise> 
			Good evening!
		  </c:otherwise> 
		</c:choose> 
		<hr />
	
		<c:set var="jumsu" value="${param.jumsu}" />
		점수 : <c:out value="${jumsu}" default="0" /> 점  / 학점 : <!-- 0이 기본값 -->
		<c:choose> 
		    <c:when test="${jumsu >=90 }" >
				A
		    </c:when> 
		    <c:when test="${jumsu >=80 }" > 
				B
		    </c:when> 
		    <c:when test="${jumsu >=70 }" > 
				C
		    </c:when> 
		    <c:when test="${jumsu >=60 }" > 
				D
		    </c:when> 
		    <c:otherwise> 
				F
		    </c:otherwise> 
		</c:choose> 
		학점. 
		
	</body>
</html>