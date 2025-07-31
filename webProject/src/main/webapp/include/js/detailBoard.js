$("#updateFormBtn").on("click", function(){
	actionProcess("#dataForm", "get", "/board/updateForm.do");
});

$("#insertFormBtn").on("click", function(){
	locationProcess("/board/insertForm.do");
});

$("#boardListBtn").on("click", function(){
	locationProcess("/board/getBoardList.do");
});

