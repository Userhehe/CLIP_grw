$(document).ready(function() {
    $(".open-modal-btn").click(function() {
        console.log("수정 버튼 클릭");

        var $clickedButton = $(this);
        var $row = $clickedButton.closest("tr");
        var $contentElement = $row.find(".daily_modify");
        var content = $contentElement.text().trim(); 
        $("#re_content").val(content);

        $("#dailyCheckModal").modal("show");

        $("#addDailyCheck").off("click").on("click", function() {
            var newContent = $("#re_content").val(); 
            $contentElement.text(newContent); 
            $clickedButton.hide(); 
            
            $row.append('<td>' + newContent + '</td>');
            $row.find(".daily_modify").text("Y"); 

            // AJAX 요청을 통해 수정 내용을 서버에 전송
            var dailySeq = $row.find(".daily_seq").text();
            updateDailyCheckStatus(dailySeq, newContent);
        });

        $("#addDailyCheckCancel").click(function() {
            $("#dailyCheckModal").modal("hide");
        });
    });
function updateDailyCheckStatus(dailySeq, reasonContent) {
    $.ajax({
        type: "POST",
        url: "./Clip_Groupware/updateDailyCheckStatus.do", // 수정된 URL
        data: {
            daily_seq: dailySeq,
            re_content: reasonContent
        },
        success: function(response) {
            console.log("수정된 내용이 서버에 전송되었습니다.");
            window.location.href = "/Clip_Groupware/selectDailyCheckList.do"; // 수정된 URL
        },
        error: function(xhr, status, error) {
            console.error("서버에 수정된 내용을 전송하는 중 오류가 발생했습니다.");
        }
    });
}

    // 검색 버튼 클릭 시 폼 제출
    $("#searchButton").click(function() {
        $("#searchForm").submit();
    });
});
