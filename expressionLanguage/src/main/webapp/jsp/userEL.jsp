<%@page import="com.book.BookVO" %>
<%@page import="com.grade.StudentGrade" %>
<%@page import="java.util.HashMap" %>
<%@page import="com.test.Apple" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.date.Today" %>
<%@page import="com.member.User" %>
<%@page import="com.member.Address" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//방법1
	User member = new User();
	member.setUname("홍길동");
	member.setUid("goodday");
	member.setUnum(19010001);
	
	//방법2
	com.member.Address add = new com.member.Address();
	add.setCity("서울시 강남구 역삼동");
	add.setZipcode("06123");
	
	member.setAddress(add); //add는 Address 클래스의 객체지만 User 클래스가 필드로 Address 클래스를 가지고 있기에(확인해볼것) User 클래스 메서드를 add로 호출할 수 있는 것. 
	//out.print(member.getUname());
	//out.print(member.getAddress().getCity());
%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>표현언어에서 액션 태그 이용: userEL.jsp</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
		<h3> 접근자로 데이터 출력(표현식 이용)</h3>
		<label>uname :</label><%=member.getUname()%><br />
		<label>uid : </label><% out.print(member.getUid()); %><br />
		<label>unum : </label><%=member.getUnum()%><br />
		
		<label>city :</label><%=member.getAddress().getCity()%><br />
		<label>zipcode : </label><%=member.getAddress().getZipcode()%><br/>

		<h3> 인스턴스 생성 및 필드값 설정(액션태그 이용)</h3>
		<jsp:useBean id="user" class="com.member.User" scope="page"/>
		User user = new User() <br />
		<jsp:setProperty property="uname" name="user" value="김늘봄"/>
		user.setUname("김늘봄") <br />
		<jsp:setProperty property="uid" name="user" value="javauser"/>
		<jsp:setProperty property="unum" name="user" value="19050001"/>
		<%-- has-a 관계 설정 --%>
		<jsp:useBean id="address" class="com.member.Address" scope="page" />
		
		<jsp:setProperty property="city" name="address" value="서울 특별시 강남구 테헤란로"/>
		<jsp:setProperty property="zipcode" name="address" value="04715"/>
		
		<jsp:setProperty property="address" name="user" value="${address}"/>
		
		
		<h3>표현 언어에서 자바빈즈 getter 호출</h3>
		<label>uname :</label> ${user.uname} <br />
		<label>uname :</label> ${user.getUname()} <br />
		<label>uid :</label> ${user.uid} <br />
		<label>unum :</label> ${user.unum}<br />
		
		<h5> 표현언어에서 자바빈즈 getter 호출(has-a관계 출력)</h5>
		<label>address city : </label> ${user.address.city} <br />
		<label>address zipcode : </label> ${user.address.zipcode} <br />
		<hr />
		
		
		<h2>객체의 getter 메서드, 컬렉션 객체의 원소</h2>
		<%
			// 이 예제를 작성하기 전에 com.date 패키지에 Today 클래스를 생성
			pageContext.setAttribute("today", new Today());
			//위에서 설정한 속성을 출력하기 위해 지금까지 아래와 같이 코딩하였습니다. 
			//Today now = (Today)pageContext.getAttribute("today");
			//out.print(now.getYear() + "년 " + now.getMonth() +"월 " + now.getDate()+"일");
		%>
		<%-- 위 속성을 표현언어로 출력하도록 하겠습니다. --%>
		<h3>객체의 멤버 접근</h3>
		<div>${ pageScope.today.year }년 ${ today.month }월 ${ today.date }일</div>
		<%--${객체명.필드명(=속성명)} -> 객체명.getXXX()접근자 호출 --%>
		
		<%
			// 이 예제를 작성하기 전에 com.test 패키지에 Apple 클래스를 생성해야 합니다.
			// 필드는 color를 가집니다.
			ArrayList<Apple> myList = new ArrayList<>();
			myList.add(new Apple("청색"));
			myList.add(new Apple("빨간색"));
			myList.add(new Apple("황색"));
			pageContext.setAttribute("list", myList);
			
			//위에서 설정한 속성을 출력하기 위해 지금까지 아래와 같이 코딩하였습니다.
			//@SuppressWarnings("unchecked")
			//ArrayList<Apple> list = (ArrayList<Apple>)pageContext.getAttribute("list");
			//out.print((list.get(0)).getColor());
		%>

		<h3>컬렉션의 객체 사용(ArrayList / HashMap)</h3>
		<div>${ pageScope.list[0].color }-${list[1].color}-${list[2].color }</div>
		<%--${컬렉션[인덱스].필드명(=속성명)} -> 컬렉션인스턴스명.get(인덱스).getXXX() 호출 --%>

		<%
			HashMap<String, String> map = new HashMap<>();
			map.put("uname", "홍길동");
			map.put("uid", "javauser");
			pageContext.setAttribute("map", map);
			
			//위에서 설정한 속성을 출력하기 위해 지금까지 아래와 같이 코딩하였습니다.
			//@SuppressWarnings("unchecked")
			//HashMap<String, String> map1 = (HashMap<String, String>)pageContext.getAttribute("map");
			//out.print(map1.get("uname"));
		%>
		<div>${ map.uname } - ${ map.uid }</div>
		<%-- ${map인스턴스명.key이름} -> map인스턴스명.get("key이름") 호출 --%>
		
		<%-- 
			이 예제를 작성하기 전에 com.book 패키지에 BookVO 클래스를 생성해야 합니다 
			필드는 title(제목) ,author(저자), publisher(출판사) 가집니다
		--%>
		
		<h3> 책정보 출력 </h3>
		<jsp:useBean id="bookVO" class="com.book.BookVO" scope="page" />
		<jsp:setProperty property="title" name="bookVO" value="가자, 길이 보이지 않아도" />
		<jsp:setProperty property="author" name="bookVO" value="이호준" />
		<jsp:setProperty property="publisher" name="bookVO" value="꽃길" />
		
		<label>책제목 : </label> ${bookVO.title} <br />
		<label>책저자 : </label> ${bookVO.author} <br />
		<label>출판사 : </label> ${bookVO.publisher} <br />
		
		<%-- 이 예제를 작성하기 전에 com.grade 패키지에 StudentGrade 클래스를 생성해야 합니다. --%>
		<h3> EL 메서드 호출 </h3>
		<%
			StudentGrade grade = new StudentGrade();
			request.setAttribute("grade", grade);
			
			BookVO book = new BookVO();
			request.setAttribute("book", book);
		%>
		${grade.setAverage(1,2,3)}
		${"평균 : " += grade.getAverage() } <br />
		
		${book.setTitle("자바")}
		${"제목 : " += book.getTitle() }
	</body>
</html>












