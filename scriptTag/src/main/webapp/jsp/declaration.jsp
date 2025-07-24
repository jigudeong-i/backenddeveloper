<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%> <!-- 페이지 소스 보기에서 맨위 빈줄 없애겠다. -->
<%@ page import="java.util.Calendar"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title>JSP 예제 - declaration.jsp</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
		<%! double radius = 4.8; %>  
		<%! 
			// 원의 면적을 구하는 메서드
			public double getArea(double r) {
				return r * r * 3.14;	
			}
		%>     
		<%-- %!는 선언문으로 메서드의 선언이나 멤버변수를 정의하고자 할 때 사용. --%>
		반지름이 <%= radius %>인    <!-- 이 태그가 서블릿(메모장)에선 out.print로 표현되어있음. out.print(radius); -->
		원의 면적은 <%= getArea(radius) %>이다.
		
		
		
		<%!
			char getKorDay() {
			    char result=' ';
				int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);   
				switch(day) {
					case 1 : result = '일'; break;
					case 2 : result = '월'; break;
					case 3 : result = '화'; break;
					case 4 : result = '수'; break;
					case 5 : result = '목'; break;
					case 6 : result = '금'; break;
					case 7 : result = '토'; 
				}
			    return result;	
		   }
		%>
		<p>오늘은 <%=  getKorDay() %>요일입니다.</p>




		<p>
			<% int i = 0; %>   <!-- 스크립트릿로 해버리면 _jsp.service의 매서드 변수로 선언한 것. 즉, 메서드 안에서만 사용가능.-->
			<label>[지역변수] i = <%= ++i %></label> 
		</p>
		<p>
			<label>[전역변수/필드] fieldi = <%= ++fieldi %></label> 
			<%! int fieldi  = 0; %>
		</p>
		<!-- 실행하고 계속 새로고침 해보라. -->
		
		
		
	
		<!-- 1부터 10까지의 합 구하기 -->
		<p>
			<%! int sum = 0; %>
			
			<%! 
				public int sum(int a, int b){
					int hap = 0;
					for(int i=a; i<=b; i++){
						hap += i;
					}
					return hap;
				}
			%>
			
			<%= "1부터 10까지 합은 " + sum(1, 10) + " 입니다" %> <br />
				1부터 10까지의 합은 <%= sum(1, 10) %> 입니다.
		</p>
	</body>
</html>










