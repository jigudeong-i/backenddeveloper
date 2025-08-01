$("#boardUpdateBtn").on("click", function(){
	if (!chkData("#title", "제목을")) return;
	else if (!chkData("#content", "작성할 내용을")) return;
	else {
		actionProcess("#f_updateForm", "post", "/board/updateBoard.do");
	}
});

$("#boardListBtn").on("click", function(){
	locationProcess("/board/getBoardList.do");
});