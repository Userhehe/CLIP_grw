// 출근 버튼 클릭 시 호출되는 함수
function handleCheckInButtonClick() {
    console.log("############씨발@@@@@@@@@@@@@@@@@@@@@");
    // 출근 버튼을 숨깁니다.
    document.getElementById("checkInButton").style.display = "none";
    // 퇴근 버튼을 표시합니다.
    document.getElementById("checkOutButton").style.display = "block";
}