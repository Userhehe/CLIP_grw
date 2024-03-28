$(document).ready(function() {
    // 라디오 버튼 클릭 이벤트 핸들러
    $("input[name='gridRadios']").click(function() {
        var selectedValue = $(this).val(); // 클릭된 라디오 버튼의 값 가져오기

        // 완료 상태일 때
        if (selectedValue === 'option2') {
            // AJAX 요청
            $.ajax({
                url: "/projectsProgressDone.do", // 완료 프로젝트 리스트를 가져올 URL
                type: "GET", // GET 또는 POST 방식 선택
                dataType: "json", // 서버에서 받아올 데이터 타입 (JSON 형식으로 예상)
                success: function(data) {
                    // 성공적으로 데이터를 받아왔을 때의 처리
                    // 받아온 데이터를 이용하여 화면에 프로젝트 리스트를 업데이트하는 등의 작업 수행
                },
                error: function(error) {
                    // 에러가 발생했을 때의 처리
                    console.error('에러 발생:', error);
                }
            });
        }
    });
});