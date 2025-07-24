<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>      <!-- 원래 기본값은 false. 실행하고 우클-페이지소스보기 보면 맨위 빈줄 없어짐. 이 코드 없으면 맨위 빈줄 생김 -->  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title>JSP 예제 - scriptlet.jsp</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
		<h4>JSP로 구현한 구구단 - 단을 입력받아 해당하는 단만 출력</h4>
		 <%
		 int dan = 2;
		 if(request.getParameter("dan")!=null){   	 // 실행하고 url 끝에 ?dan=3 넣으면 바뀜반환값 String 이기에 null값 비교 
			 dan = Integer.parseInt(request.getParameter("dan"));  // get방식으로 받아오겠다. 그래서 아래 if문 필요 
		 }
		 
		 if (dan >= 1 && dan <= 9){
		 	for (int i=1; i<=9; i++){
		%>
				 <%=dan %> x <%=i %> = <%=dan*i%><br />
		<%	
			}
		 %>
		 <hr />
		<%
			for (int i=1;i<=9;i++){
				out.print(dan + " x " + i + " = "  + dan*i + "<br>");	
			}
		 } else {
		%>
			<h5 style="color:red">1에서 9사이의 값을 입력해 주세요..</h5>
		<%	
		}
		 %>
		 
	   	<h4>스크립트릿을 이용한 구구단 2 ~ 9단까지 전부 출력 - 1</h4>
		<%	
			int i, j, k;
			out.println("<table border='1'>");
			for (i = 1; i <= 9; i++) {
				out.println("<tr>");
				for (j = 2; j <= 9; j++) {
					k = i * j;
					out.println("<td>");
				    out.println(j + " * " + i + " = " + k);
				    out.println("</td>");
				}
				out.println("</tr>");     
			} 
			out.println("</table>");
    	%>
    	
		<h4>스크립트릿을 이용한 구구단 2 ~ 9단까지 전부 출력- 2</h4>
		<table border="1">
			<% for (i = 1; i <= 9; i++) { %>
			    <tr>
			<% for (j = 2; j <= 9; j++) {
					 k = i * j;
			%>
					<td>
						<%-- out.println(j + " * " + i + " = " + k); --%>
						<%--= j + " * " + i + " = " + k --%>
						<%= j %> * <%=i%> = <%=k %>
					</td>
			<%
				}
			%>
			    </tr> 
			<% } %>
    	</table>	
	</body>
</html>