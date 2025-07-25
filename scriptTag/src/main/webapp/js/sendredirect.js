$("#word").on("keyup", function(){
	$("#result").html("");
});

$("#sendBtn").on("click", ()=>{
	if($("#word").val().replace(/\s/g, "")==""){
		//alert("검색할 단어를 입력해 주세요.");
		$("#result").html("검색할 단어를 입력해 주세요.").css("color", "#800000");
		$("#word").val("");
		$("#word").focus();
		return;
	}else{
		$("#form1").attr({
			"method":"post",
			"action":"sendredirect.jsp"
		});
		$("#form1").submit();
	}
});