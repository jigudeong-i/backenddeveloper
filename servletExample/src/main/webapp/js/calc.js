$("#btnCalc").on("click",function(){
	const numberPattern = /^\d+$/g;      //정수만 갖게 하기. 
	/*정규표현식
	/ /
	^  시작
	$  끝
	\d [0-9]
	+  하나이상
	g  글로벌. 모든 요소에서 다 찾아라 */
	
	 
	if($("#num1").val().replace(/\s/g,"")==""){ //공백문자를(\s) 공백제거로("")대체했는데(replace) 그게 공백이라면(=="") 
		alert("숫자를 입력해 주세요");
		$("#num1").val("");  			//경고문구를 띄운 후에 칸을 지우고   
		$("#num1").focus();	 			//커서가 들어가게 하겠다.
		return;
	} else{
		if($("#num1").val().search(numberPattern) < 0){   //공백은 아닌데 숫자도 아니라면
			alert("문자를 입력할 수 없습니다.");
			$("#num1").val("");
			$("#num1").focus();
			return;
		}
	}						
	
	if($("#num2").val().replace(/\s/g,"")==""){
		alert("숫자를 입력해 주세요");
		$("#num2").val("");
		$("#num2").focus();
		return;
	} else{
		if($("#num2").val().search(numberPattern) < 0){
			alert("문자를 입력할 수 없습니다.");
			$("#num2").val("");
			$("#num2").focus();
			return;
		}
	}
	
	// 결과값을 새로운 html에 출력하기 
	 $("#frm").attr({
		"method":"post",						//어떤 형식으로 보낼건가
		"action":"/servletExample/calcServlet"  //어디로 데이터 보낼건가
	});
	$("#frm").submit(); 					    //form에 있는 값 보내겠다. 
});
	
	// html은 그대로 두고 결과값을 서버로부터 받아오기. 
	/*$.ajax({
		url:"/servletExample/calcServlet2", // 요청을 전달할 주소 (요청 url) calcServlet2에서 계산해서 받아오겠다.      
		method:"post",                      // 전송방식은 '요청'
		data:{								// 값이 여러개라 중괄호 
			"num1":$("#num1").val(),
			"num2":$("#num2").val(),
			"operator":$("#operator").val()
		},
		//data: $("#frm").serialize(),  // 서버에 전달한 파라미터(serialize():폼전체 데이터 전송하는 메서드)
		dataType:"text"                // 서버로부터 응답받을 문서 타입(text/json/xml)   
	}).done(function (data) {
		console.log(data);
		$("#result").val(data);
	}).fail(function(xhr, status) {
		alert(status + " 발생.\n상태: " + xhr.status);
	});
});*/










