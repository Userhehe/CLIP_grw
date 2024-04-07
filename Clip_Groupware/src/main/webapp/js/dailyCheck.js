$(document).ready(function() {
	
	  // 모달에서 뒤로가기 버튼을 누를 때 모달이 닫히도록 설정
    $("#addDailyCheckCancel").click(function() {
        $("#dailyCheckModal").modal("hide");
    });
    
    $(".open-modal-btn").click(function() {
        var $row = $(this).closest("tr");
        var $dailySeqElement = $row.find(".daily_seq");

        var dailySeqText = $dailySeqElement.text().trim();
        $('#daily_seq').val(dailySeqText);
        $("#dailyCheckModal").modal("show");
    });
        
    $("#addDailyCheck").click(function() {
        updateDailyCheckStatus();
    });

    function updateDailyCheckStatus() {
        var dailyReasonModify = $('#daily_reasonmodify').val();
        var dailySeq = $('#daily_seq').val();
        var dailystatus = $("#daily_status").val();
        console.log("dailystatus",dailystatus);
        
        $.ajax({
            type: "POST",
            url: "./updateDailyCheckStatus.do",
            data: {daily_reasonmodify: dailyReasonModify, daily_seq: dailySeq, daily_status:dailystatus},
            success: function(response) {
                console.log("수정된 내용이 서버에 전송되었습니다.");
                $("#dailyCheckModal").modal("hide");
                location.reload();
//                var $row = $("tr").find(`.daily_seq:contains('${dailySeq}')`).closest("tr");
//                $row.find(".daily_modify").text('Y');
//                $row.find(".daily_reasonmodify").text(dailyReasonModify); // 수정된 내용 표시
                
            },
            error: function(xhr, status, error) {
                console.error("서버에 수정된 내용을 전송하는 중 오류가 발생했습니다.");
            }
        });
    }

    // 모든 경우에 list.daily_reasonmodify를 표시
    $(".daily_reasonmodify").each(function() {
        var text = $(this).text().trim();
        $(this).text(text);
    });
    
    $("#searchButton").click(function(event) {
        event.preventDefault(); // 기본 이벤트 제거
        $("#searchForm").submit(); // 폼 제출
    });
    
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////   
    
// DOM이 로드된 후 실행되는 함수
document.addEventListener("DOMContentLoaded", function() {
    // 출퇴근 상태 가져오는 함수
    function getDailyStatus() {
        fetch('/selectDailyStatus.do')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(data => {
                console.log('출퇴근 상태:', data);
                // 여기서 가져온 데이터를 화면에 표시
                document.querySelectorAll('#dailyCheckTable tbody tr').forEach(row => {
                    const statusCell = row.querySelector('.daily_status');
                    if (statusCell) {
                        statusCell.textContent = data; // 데이터를 해당 셀에 표시
                    }
                });
            })
            .catch(error => {
                console.error('에러 발생:', error);
            });
    }

    // 페이지 로드 시 출퇴근 상태 가져오기
    getDailyStatus();
});


});