$(document).ready(function() {
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
        
        $.ajax({
            type: "POST",
            url: "./updateDailyCheckStatus.do",
            data: {daily_reasonmodify: dailyReasonModify, daily_seq: dailySeq},
            success: function(response) {
                console.log("수정된 내용이 서버에 전송되었습니다.");
                $("#dailyCheckModal").modal("hide");
                var $row = $("tr").find(`.daily_seq:contains('${dailySeq}')`).closest("tr");
                $row.find(".daily_modify").text('Y');
                $row.find(".daily_reasonmodify").text(dailyReasonModify); // 수정된 내용 표시
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
});
