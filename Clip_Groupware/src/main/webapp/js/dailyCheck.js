$(document).ready(function() {
    $(".open-modal-btn").click(function() {
        console.log("수정 버튼 클릭");
        $("#dailyCheckModal").modal("show");
    });
});

function dailyCheckModal(){
	console.log("씨발 모달 나오라고");
	$("#dailyCheckModal").modal("show");
}