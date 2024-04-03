$(document).ready(function() {

    // 새 클라이언트 등록
    $("#cliInsertBtn").on("click", function(){

        var formData = $('#insertClient').serialize();

        console.log("클라이언트 세이브세이브");
        console.log(formData);
        $.ajax({
            type:"post",
            url:"./addClient.do",
            data:formData,
            success:function(result){
                console.log(result);
                if(result>0) {
                    console.log('등록성공!');
                    //페이지 이동
                    window.location.href = "./projectsProgress.do";
                    selectProjectListAll();
                    //인풋칸 초기화해주는 구문 추가
                    $("#insertClient :input").each(function() {
                        // 각 필드의 값을 빈 문자열로 설정합니다.
                        $(this).val("");
                    });
                } else {
                    console.log('error!');
                }
            }
        });

    });
});