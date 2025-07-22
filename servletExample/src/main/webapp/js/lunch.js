$("#submitBtn").on("click", function(){
	if($("select[name='lunch'] > option:selected").index() < 0){
		alert("점심 메뉴를 선택해 주세요.");
		return;
	}else{
		if($("select[name='lunch'] > option:selected").length < 2){
			alert("두개 이상의 메뉴를 골라주세요.");
			return;
		}
		
		// $(선택자).attr({"속성명":"값", "속성명":"값"})
		// <태그명 속성명="값" 속성명="값" />으로 추가
		$("#form").attr({
			"method":"post",
			"action":"/servletExample/todayMenu"
		});
		$("#form").submit();
	}
});