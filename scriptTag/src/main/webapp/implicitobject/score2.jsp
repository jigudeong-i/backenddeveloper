<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>    
<% 
	String data = request.getParameter("score"); 
	int score = 0;
	if(data != null){
		score = Integer.parseInt(data);
	}
	
	String hakjum = "";
	if(score >=90 && score<=100 ){
		hakjum = "A";
	} else if(score >=80){
		hakjum = "B";
	} else if(score >=70){
		hakjum = "C";
	} else if(score >=60){
		hakjum = "D";
	} else {
		hakjum = "F";
	}
	out.print(hakjum);
%>
