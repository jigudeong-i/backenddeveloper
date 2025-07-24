$("#submitBtn").on("click", function(){
	if($("select[name='lunch'] > option:selected").index() < 0){   // name이 lunch에 일치하는 속성.    0보다 작다 : 선택되지 않은
		alert("점심 메뉴를 선택해 주세요.");
		return;
	}else{
		if($("select[name='lunch'] > option:selected").length < 2){   // 2개 이상 선택 안 했을 때 
			alert("두개 이상의 메뉴를 골라주세요.");
			return;
		}
		
		// $(선택자).attr({"속성명":"값", "속성명":"값"})
		// <태그명 속성명="값" 속성명="값" />으로 추가
		$("#form").attr({
			"method":"post",            // post
			"action":"/servletExample/todayMenu"
		});
		$("#form").submit();
	}
});