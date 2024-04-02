$(document).ready(function() {
    $(".open-modal-btn").click(function() {
        var $row = $(this).closest("tr");
        var deptSeqText = $row.find("td:eq(1)").text().trim();
        $('#dept_seq_modal').val(deptSeqText);
        $("#deptCheckModal").modal("show");
    });
        
    $("#addDeptCheck").click(function() {
        updateDeptCheckStatus();
    });

    $("#addDeptCheck").click(function() {
        updateDeptCheckStatus();
    });

    function updateDeptCheckStatus() {
        var dept_name = $('#dept_name_modal').val();
        var dept_seq = $('#dept_seq_modal').val();
        
        $.ajax({
            type: "POST",
            url: "./updateDept.do",
            data: {dept_name: dept_name, dept_seq: dept_seq},
            success: function(response) {
                console.log("수정된 내용이 서버에 전송되었습니다.");                
                var $row = $("tr").find(`.dept_seq:contains('${dept_seq}')`).closest("tr");
                $row.find(".dept_name").text(dept_name);
                alert("수정이 완료되었습니다.");
                $("#deptCheckModal").modal("hide");
            },
            error: function(xhr, status, error) {
                console.error("서버에 수정된 내용을 전송하는 중 오류가 발생했습니다.");
            }
        });
    }

    $("#addDeptCheckCancel").click(function() {
        $("#deptCheckModal").modal("hide");
    });
});


$(document).ready(function() {
    // 삭제 버튼 클릭 시
    $(".delete-btn").on("click", function() {
        var deptSeq = $(this).data("dept-seq"); // 선택한 행의 부서 코드 가져오기
        var deptName = $(this).data("dept-name"); // 선택한 행의 부서명 가져오기
        
        // SweetAlert를 사용하여 확인 메시지 표시
        swal({
            title: "정말 삭제하시겠습니까?",
            text: "부서명: " + deptName,
            icon: "warning",
            buttons: ["취소", "삭제"],
            dangerMode: true,
        })
        .then((willDelete) => {
            if (willDelete) {
                // 삭제 확인 시, AJAX를 사용하여 서버에 삭제 요청 보내기
                $.ajax({
                    type: "POST",
                    url: "./delDept.do",
                    data: { dept_seq: deptSeq },
                    success: function(response) {
                        // 삭제 성공 시, 해당 행 삭제
                        if (response == "success") {
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
//    $(document).ready(function() {
//    // 부서 검색 버튼 클릭 시
//    $("#deptSearch").click(function() {
//        var deptName = $("#dept_name").val(); // 검색할 부서명 가져오기
//        searchDepartment(deptName); // 부서 검색 함수 호출
//    });
//
//    // 부서 검색 함수 정의
//    function searchDepartment(deptName) {
//        $.ajax({
//            type: "GET",
//            url: "./searchDept.do",
//            data: { dept_name: deptName },
//            success: function(response) {
//                // 서버로부터 받은 HTML을 테이블에 업데이트
//                $("#deptTableBody").html(response);
//            },
//            error: function(xhr, status, error) {
//                console.error("부서 검색 중 오류 발생:", error);
//            }
//        });
//    }
//});

});











