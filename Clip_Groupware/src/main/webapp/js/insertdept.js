function checkDuplicate() {
    var deptName = document.getElementById('dept_name').value.replace(/\s+/g, ''); 
    $.ajax({
        url: './checkDuplicateDept.do',
        type: 'POST',
        data: { dept_name: deptName },
        success: function(data) {
            if (data > 0) {
                document.getElementById('duplicateMessage').innerText = '부서명이 이미 존재합니다.';
                document.getElementById('submitBtn').disabled = true;
            } else {
                document.getElementById('duplicateMessage').innerText = '';
                document.getElementById('submitBtn').disabled = false;
            }
        },
        error: function() {
            console.error('중복 검사 오류');
        }
    });
}
