// 출근 버튼 클릭 시 호출되는 함수
function handleCheckInButtonClick() {
    console.log("############씨발@@@@@@@@@@@@@@@@@@@@@");
    console.log("############좆같아@@@@@@@@@@@@@@@@@@@@@");
}

// 퇴근 버튼 클릭 시 호출되는 함수
function handleCheckOutButtonClick() {
    // 출근 시간을 가져옵니다.
    var checkInTime = document.getElementById("checkInTime").value; // 출근 시간이 표시된 요소의 ID를 사용하여 값을 가져옵니다.
    
    // 현재 시간을 가져옵니다.
    var checkOutTime = new Date();
    
    // AJAX 요청을 보냅니다.
    $.ajax({
        type: "POST",
        url: "/updateDailyCheckOuttime.do",
        data: {
            checkInTime: checkInTime,
            checkOutTime: checkOutTime
        },
        success: function(response) {
            // 요청이 성공한 경우 처리할 내용을 작성합니다.
             window.location.href = "/main.do";
            alert("퇴근 처리가 완료되었습니다.");
        },
        error: function(xhr, status, error) {
            // 요청이 실패한 경우 처리할 내용을 작성합니다.
            alert("퇴근 처리 중 오류가 발생했습니다.");
        }
    });
}