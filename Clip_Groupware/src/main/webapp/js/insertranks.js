function checkDuplicate() {
    var ranksName = $('#ranks_name').val().replace(/\s+/g, ''); // 앞, 뒤 및 중간 공백 제거
    $.ajax({
        url: './duplicateRanks.do',
        type: 'POST',
        data: { ranks_name: ranksName },
        success: function(data) {
            console.log('중복 검사 결과:', data);
            if (data > 0) {
                $('#duplicateMessage').text('직급명이 이미 존재합니다.');
                $('#submitBtn').prop('disabled', true);
            } else {
                $('#duplicateMessage').text('');
                $('#submitBtn').prop('disabled', false);
            }
        },
        error: function() {
            console.error('중복 검사 오류');
        }
    });
}
