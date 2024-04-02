$(document).ready(function() {
    // 수정 모달 열기 버튼 클릭 시
    $(".open-modal-btn").click(function() {
        var $row = $(this).closest("tr");
        var ranksSeqText = $row.find("td:eq(1)").text().trim();
        $('#ranks_seq_modal').val(ranksSeqText);
        $("#ranksCheckModal").modal("show");
    });
        
    // 수정 완료 버튼 클릭 시
    $("#addrankCheck").click(function() {
        updateRanksCheckStatus();
    });

    // 뒤로가기 버튼 클릭 시
    $("#addrankCheckCancel").click(function() {
        $("#ranksCheckModal").modal("hide"); // 수정 모달 닫기
    });

    // 직급 수정 상태 업데이트 함수
    function updateRanksCheckStatus() {
        var ranks_name = $('#ranks_name_modal').val();
        var ranks_seq = $('#ranks_seq_modal').val();
        
        $.ajax({
            type: "POST",
            url: "./updateRanks.do",
            data: {ranks_name: ranks_name, ranks_seq: ranks_seq},
            success: function(response) {
                console.log("수정된 내용이 서버에 전송되었습니다.");                
                var $row = $("tr").find(`.dept_seq:contains('${ranks_seq}')`).closest("tr");
                $row.find(".ranks_name").text(ranks_name);
                alert("수정이 완료되었습니다.");
                $("#ranksCheckModal").modal("hide"); // 수정 모달 닫기
                location.reload(); // 수정이 완료된 후에 화면을 새로고침하여 수정된 내용을 화면에 반영
            },
            error: function(xhr, status, error) {
                console.error("서버에 수정된 내용을 전송하는 중 오류가 발생했습니다.");
                alert("수정하는 도중 오류가 발생했습니다. 다시 시도해주세요.");
            }
        });
    }
});


    $("#addrankCheckCancel").click(function() {
        $("#ranksCheckModal").modal("hide");
    });




$(document).ready(function() {
    // 삭제 버튼 클릭 시
    $(".delete-btn").on("click", function() {
        var ranksSeq = $(this).data("dept-seq"); // 선택한 행의 직급 코드 가져오기
        var ranksName = $(this).data("dept-name"); // 선택한 행의 직급명 가져오기
        
        // SweetAlert를 사용하여 확인 메시지 표시
        swal({
            title: "정말 삭제하시겠습니까?",
            text: "직급명: " + ranksName,
            icon: "warning",
            buttons: ["취소", "삭제"],
            dangerMode: true,
        })
        .then((willDelete) => {
            if (willDelete) {
                var btn = $(this); // 클로저를 사용하여 버튼 요소를 저장
                
                // 삭제 확인 시, AJAX를 사용하여 서버에 삭제 요청 보내기
                $.ajax({
                    type: "POST",
                    url: "./delRanks.do",
                    data: { ranks_seq: ranksSeq },
                    success: function(response) {
                        // 삭제 성공 시, 해당 행 삭제
                        if (response == "success") {
                            swal("삭제되었습니다.", {
                                icon: "success",
                            }).then(() => {
                                // 해당 행 삭제
                                btn.closest("tr").remove();
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














