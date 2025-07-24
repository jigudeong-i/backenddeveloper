$(".inputData").on({
    focusout : function(){		// 텍스트 안에 커서가 벗어났을 때 
        if($(this).val().replace(/\s/g, "") === ""){     // this => title    공백은 없애겠다. (g가 없으면 딱 하나만 찾음) 
            $(this).next().html($(this).prev().html() + " 필수항목입니다");  
            return;             // 다음요소(next) 즉span에 html을 출력하라. 이전요소(prev) label:책제목 
        }
    },
    focusin : function(){
        $(this).next().html("");   // 텍스트 안에 커서가 들어갔을 때
    }
});

$("#regBtn").on("click", function () {
    let isValid = true;

    $(".inputData").each(function () {
        if ($(this).val().replace(/\s/g, "") === "") {
            $(this).next().html($(this).prev().html() + " 필수항목입니다");
            isValid = false;
        }
    });

    if (isValid) {
        $("#bookForm").attr({
            "action": "/servletExample/bookInput",
            "method": "post"
        });
        $("#bookForm").submit();
    }
});