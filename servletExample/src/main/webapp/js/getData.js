$("#submitBtn").on("click", function(){
	//console.log("확인");
	if($("#name").val().replace(/\s/g,"")==""){       // '/ /g' 정규표현식 
		alert("이름을 입력해 주세요");
		$("#name").val("");			// 공백이 들어가있다면 초기화합시다.  
		$("#name").focus();			
		return;
	}
	if($("#address").val().replace(/\s/g,"")==""){
		alert("주소를 입력해 주세요.");
		$("#address").val("");
		$("#address").focus();
		return;
	}
	
	/* 폼에 속성을 추가하는 작업 - 1
	$("#dataForm").attr("method","post");     폼에 속성을 추가할건데 메서드 방식이 포스트. 
	$("#dataForm").attr("action","/servletExample/getData");   액션의 방식이 ~다. 
	$("#dataForm").submit(); */
	
	/* 폼에 속성을 추가하는 작업 - 2 
	$("#dataForm").attr("method","post").attr("action","/servletExample/getData");
	$("#dataForm").submit(); */
	
	// 형식 : $("선택자").attr({"속성":"값", "속성":"값" });
	$("#dataForm").attr({       //속성을 한꺼번에 주기 
		"method":"post",
		"action":"/servletExample/getData"   //액션은 summit의 url 패턴으로. 
	});
	$("#dataForm").submit();
});