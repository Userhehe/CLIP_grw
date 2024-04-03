$(document).ready(function() {
    // 삭제 버튼 클릭 시
    $(".delete-btn").on("click", function() {
        var signs_seq = $(this).data("signs-seq"); // 선택한 행의 서명 번호 가져오기
        
        // SweetAlert를 사용하여 확인 메시지 표시
        swal({
            title: "정말 삭제하시겠습니까?",
            icon: "warning",
            buttons: ["취소", "삭제"],
            dangerMode: true,
        })
        .then((willDelete) => {
            if (willDelete) {
                // 삭제 확인 시, AJAX를 사용하여 서버에 삭제 요청 보내기
                $.ajax({
                    type: "POST",
                    url: "./deletePad.do",
                    data: { signs_seq: signs_seq },
                    success: function(response) {
                        // 삭제 성공 시, 해당 행 삭제
                        if (response === "success") {
                            swal("삭제되었습니다.", {
                                icon: "success",
                            }).then(() => {
                                window.location.reload(); // 페이지 새로고침
                            });
                        } else {
                            swal("삭제 실패", {
                                icon: "error",
                            });
                        }
                    },
                    error: function(xhr, status, error) {
                        swal("오류 발생", {
                            icon: "error",
                        });
                    }
                });
            }
        });
    });
});
