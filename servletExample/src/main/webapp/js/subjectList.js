(function autoSubjectNumber(){
	// 자동으로 학번 구하기
	$.ajax({
		url: "/servletExample/subjectNumber", //요청 url
		method: "post",
		dataType: "text"	
	}).done(function (data){
		//console.log(data);
		$("#subjectNumber").val(data);
	}).fail(function (xhr, textStatus){
		alert(textStatus + " 발생.\n상태: " + xhr.status);
	});
})();


// 공통 함수
const submitSubjectForm = function(formName, actionUrl){
	$(formName)
		.attr({
			"method":"post",
			"action":actionUrl
		})
		.submit();
}


// "입력완료" 버튼 제어
$(document).on("click", "#insertBtn", ()=>{
	if(!chkData("#subjectName", "학과명을 ")) return;
	
	const isNew = $("#no").val() === "0";
	const actionUrl = isNew ? "/servletExample/insert" : "/servletExample/update";
	submitSubjectForm("#subject",actionUrl);
})




// "다시쓰기" 버튼 제어
$("#resetBtn").on("click", ()=>{
	$("#subjectName").val("");
});





// "수정" 버튼 제어
$(document).on("click", ".updateBtn", function () {
    $(".upResetBtn").remove();

    const $row = $(this).closest("tr");
    const no = $row.data("no"); 
    const subjectNumber = $row.children().eq(1).text().trim();
    const subjectName = $row.children().eq(2).text().trim();

    $("#no").val(no);
    $("#subjectNumber").val(subjectNumber);     //학과번호 ~번의 학과이름 ~ 설정을 여기서  
    $("#subjectName").val(subjectName);

    // "입력완료" → "수정완료"
    $("#insertBtn").text("수정완료");

    // "수정취소" 버튼 추가 (중복 방지)
    if (!$(".upResetBtn").length) {
        const $cancelBtn = $("<button>", {
            type: "button",
            class: "upResetBtn btn btn-secondary ms-2",
            text: "수정취소"
        });
        $("#insertBtn").after($cancelBtn);       //수정 취소 버튼 
    }
});






// "수정취소" 버튼 제어
$(document).on("click", ".upResetBtn", () => {
    $(".upResetBtn").remove();
    $("#insertBtn").text("입력완료");

    // 값 초기화
    $("#subjectName").val("");
    $("#no").val(0);

    // 자동 학과 번호 부여
    autoSubjectNumber();
});





// "삭제" 버튼 제어 (학생 있는 학과 삭제 제어 추가시 이 코드는 주석)
/*
$(document).on("click", ".deleteBtn", function(){
	if(confirm("학과 정보를 삭제하시겠습니까?")){
		const $row = $(this).closest("tr");
		const subjectNumber = $row.find("td:eq(1)").text().trim();
		location.href=`/servletExample/delete?subjectNumber=${subjectNumber}`;
	}
});
*/



// 학생 있는 학과 삭제 제어
$(document).on("click", ".deleteBtn", function(){
	const $row = $(this).closest("tr");
	const subjectNumber = $row.find("td:eq(1)").text().trim();
	
	$.ajax({
		url: "/servletExample/studentCheck",
		method: "post",
		data: { subjectNumber },
		datatype: "text"
	}).done(function (data){
		const studentCount = parseInt(data);
		
		if(studentCount>0){
			alert("소속된 학생이 존재하여 학과 데이터를 삭제할 수 없습니다.");
		}else{
			if(confirm("정말로 해당 학과 정보를 삭제하시겠습니까?")){
				location.href = `/servletExample/delete?subjectNumber=${subjectNumber}`;
			}
		}
	}).fail(function (xhr,textStatus){
		alert(`[오류] ${textStatus} 발생\n상태 코드: ${xhr.status}`);
	});
});



// "학과명 검색" 버튼 제어
$("#searchBtn").on("click", ()=>{
	if(!chkData("#name", "학과명을 ")) return;
	submitSubjectForm("#search", "/servletExample/search");
});



// "전체 검색" 버튼 제어
$("#searchAllBtn").on("click", ()=>{
	location.href = "/servletExample/list";
});



