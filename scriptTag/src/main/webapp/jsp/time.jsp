<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>	
<%@ page import="java.time.LocalDate, java.time.LocalTime, java.time.format.DateTimeFormatter"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title>스크립트 확인 - time.jsp</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
		<h2>첫 번째 JSP 테스트 예제입니다.</h2>
		<hr />
		오늘 날짜 : <%= LocalDate.now() %><br />
		<%
    		LocalTime time = LocalTime.now();
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		%>
		현재 시간 : <%= time.format(formatter) %><br />
		
		<%
			String name = "홍길동";       
			out.print(name);		// out은 어디에 정의? jsp는 실행시 서비스 메서드 호출. 거기에 정의돼 있음. 객체 따로 만들 필요없음. 이걸 내장객체라 함. 인스턴스 생성 안하고 쓸수 있는 객체들. 메모장 파일. (out = pageContext.getOut();)  
									// C:\backenddeveloper\JSPCoding\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\scriptTag\org\apache\jsp\jsp
		%>		
	</body>
</html>


