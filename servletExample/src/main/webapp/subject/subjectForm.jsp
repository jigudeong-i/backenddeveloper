<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>subject 테이블 예지 : subjectForm.jsp</title>
		<link href="/servletExample/image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
		<h3>테이블 subject 학과 정보 등록</h3>
		<hr />
		
		<form name="subject" id="subject" class="row row=cols-lg-auto g-3 align-items-center">
			<input type="hidden" name="no" id="no" value="0" />
			<div class="col-12">
				<label class="visually-hidden" for="subjectNumber">학과번호</label>
				<div class="input-group">
					<input type="text" name="subjectNumber" id="subjectNumber" class="form-control" placeholder="학과번호" readonly />
				</div>
			</div>
			
			<div class="col-12">
				<label class="visually-hidden" for="subjectName">학과명</label>
				<div class="input-group">
					<input type="text" name="subjectName" id="subjectName" class="form-contrl" placeholder="학과명" />
				</div>
			</div>
			
			<div class="col-12">
				<button type="button" id="insertBtn" class="btn btn-success">입력완료</button>
				<button type="button" id="resetBtn" class="btn btn-success">다시쓰기</button>    <!-- type=reset 아닌 이유는 학과명만 지우고 학과번호는 남기려고. -->  
			</div>
		</form>			
	</body>
</html>


















