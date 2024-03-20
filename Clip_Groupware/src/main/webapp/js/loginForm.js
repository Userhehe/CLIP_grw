// 아이디 찾기 모달창 숨기기
document.addEventListener('DOMContentLoaded', function(){
	var modal = document.getElementById("idFindModal");
	modal.style.display = "none";
});

// 아이디 찾기 모달창 활성화
function openIdModal() {
	var modal = document.getElementById("idFindModal");
	modal.style.display = "block";
}

// 아이디 찾기 모달창 비활성화
function closeIdModal() {
	var modal = document.getElementById("idFindModal");
	modal.style.display = "none";
}