<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>JSTL Core: import(import.jsp)</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />

		<style>
			div.target{margin:5px;}
		</style>
	</head>
	<body>
		<h2>JSTL Core Tag: import</h2>
		<hr />
		<div class="target">
			<c:import url="./foreach.jsp" />
			<hr />
		</div>	
		
		<div class="target"><%-- /expressionLanguage/jstl/if.jsp?jumsu=88 --%>
			<c:import url="/jstl/if.jsp" context="${pageContext.request.contextPath}">
				<c:param name="jumsu" value="88" />
			</c:import>
			<hr />
		</div>	 
		
		<div class="target">
			<c:import url="http://localhost:8080/servletExample/list" />
			<hr />
		</div>
		
		<%-- 외부 사이트를 import 할 수 있으나 외부 파일(css, js파일 등)들이 정상적으로 보여지지 않을 수 있다. --%>
		<c:import url="https://www.hanbit.co.kr/" var="hanbit" /> 
		<%-- <p>	${hanbit} </p> --%> 
		
		
		<c:url var="urlHeader" value="header.jsp" >
			<c:param name="id" value="javauser" />  <!-- param이 id로 javauser를 전달한다. --> 
		</c:url>
		
		<h3>&lt;c:url&gt;  과 &lt;c:param&gt; 태그의 처리 결과 : ${urlHeader} </h3>
		<%-- <a href="${urlHeader}">클릭</a><br /> --%>
		
		<c:import url="${urlHeader}" var="head" /> <!-- var="head": 이 정보를 head에 담아놓겠다(바로아래) -->
		
		<div id="one">
			${head}
		</div>
		
	</body>
</html>






