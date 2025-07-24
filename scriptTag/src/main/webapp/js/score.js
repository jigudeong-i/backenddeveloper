const form = document.getElementById("scoreForm");
const score = document.getElementById("score");

score.addEventListener("input", function () {
 	 score.setCustomValidity("");	 // 에러 메세지가 한번 뜨면 다음엔 지워지게. 이거 없으면 계속 뜸.
});

form.addEventListener("submit", function (e) {
	  e.preventDefault();    	// 원래 가지고 있던 이벤트 제거. submit의 기본은 '전송'. 그걸 해제.  

	  const pattern = /^(100|[1-9][0-9]?|0)$/;  //  |:or  100점 이거나 1~99점 이거나 0점 
	  
	  if (!pattern.test(score.value)) {    // 패턴에 만족하지 않았을 때 
	    score.setCustomValidity("점수는 0 ~ 100점으로 입력해 주세요.");  // 띄울 메세지 설정하고 '반영' 아래 코드 필요
	    score.reportValidity();			// 반영하려면 이 코드 필요 
		score.value = "";				// 공백은 지우겠다.
		return;
	  }
	  
	  form.method = "post";
	  // 수정1
	  // form.action = "/scriptTag/implicitobject/score.jsp"; //form.action = "score.jsp";
	  // 수정2
	  form.action = "/scriptTag/score";  // 맵핑 이름으로 부른다. 
	  form.submit();
});








