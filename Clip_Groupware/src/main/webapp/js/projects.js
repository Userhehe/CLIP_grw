    $(document).ready(function(){
        // 라디오 버튼 변경 감지
        $('input[type="radio"][name="gridRadios"]').change(function(){
            // 선택된 값 가져오기
            var selectedValue = $(this).val();
            
            // 완료 라디오 버튼이 선택되었는지 확인
            if(selectedValue === "option2") {
                // 완료 버튼이 선택되면 여기에 수행할 작업을 작성합니다.
                console.log("완료 라디오 버튼이 선택되었습니다.");
                // 예시로 완료 버튼이 선택되면 경고창을 띄웁니다.
                alert("완료 버튼이 선택되었습니다.");
            }
        });
    });
