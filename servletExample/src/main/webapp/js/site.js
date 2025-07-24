$("#btn").on("click", function(){
	if (!$("input[name='site']").is(":checked")) {  // is:여부확인. 앞에 !, 즉 '체크가 되어있지 않다면' 
			alert("이동할 사이트를 선택해 주세요");
			return;
	} 
	$("#siteForm").attr({
		"action":"/servletExample/portalSite",
		"method":"get"          //어떤때 요청이고 어떤때 응답이지? 그게 아니고 요청 방식이 get, post 두가지 있는거야.   
	});
	$("#siteForm").submit();
});

