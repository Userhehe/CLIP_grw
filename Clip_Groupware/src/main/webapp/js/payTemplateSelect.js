window.onload = function(){
	
	 var endDate = document.getElementById('endDate');
	 endDate.addEventListener('change',checkDateorder);
	 var endTime = document.getElementById('endTime');
	 endTime.addEventListener('change',checkTimeOrder);
	 
	 
	var gian1Modal = document.getElementById('previewGian');
	var modalfoot1 = gian1Modal.querySelector('.modal-footer');
//	console.log('modal : ',modalfoot1);
	var submit1 = modalfoot1.getElementsByTagName('button')[1];
//	console.log('submit1 : ',submit1);
	submit1.addEventListener('click',draft_application);
	
	var tempBut1 = document.querySelector('#tempSave');
	
	tempBut1.addEventListener('click', saveApproval);
	 
	 var savedHtml = document.querySelector("#beforeHtml")
	 
	 
}

/**********1tap 구역**************/
function half(event) {
	
	//휴가계 종류에 가져오기
	var selectedOpt = event.options[event.selectedIndex];
	var vaOpt = selectedOpt.textContent;
	
//	console.log(vaOpt);		
	//가져온 종류 미리보기에 넣기
		var htmlmodal = document.getElementById("req_preview1");
		var vaOptSpace = htmlmodal.getElementsByClassName('approval_va_opt')[0];
	if(selectedOpt.value){
		vaOptSpace.textContent = vaOpt;
	} else {
		vaOptSpace.textContent = '';
	}

	
	//반가일 시 시간 선택창 표시
    const show = (event.value === "halfDay"); 
    document.getElementById("startTime").style.display = (show ? "inline" : "none");
    document.getElementById("endTime").style.display = (show ? "inline" : "none");
    document.getElementById("endDate").style.display = (show ? "none" : "inline");
    
	//반가가 아닐 시 시간  초기화
	if(!show){
		document.getElementById("startTime").value = ''; 
		document.getElementById("endTime").value = '';
	}    
	
    
}

function gatheringInfo(){
	//세션에 저장된  값
	var name = document.getElementById("session_user_name").value;
	var rank = document.getElementById("session_ranks_name").value;
	var dept = document.getElementById("session_dept_name").value;
	var userId = document.getElementById("session_user_id").value;
	
		
//	console.log(name,dept,rank, userId);
	
	//양식 미리보기 창 영역
	var htmlmodal = document.getElementById("req_preview1");
//	console.log(htmlmodal);

	//미리보기 창의 정보 입력 위치들
	var deptSpace = htmlmodal.getElementsByClassName('approval_user_dept')[0];
	var nameSpace = htmlmodal.getElementsByClassName('approval_user_name')[0];
	var reqUserNameSpace = htmlmodal.getElementsByClassName('create_user_name')[0]
	var rankSpace = htmlmodal.getElementsByClassName('approval_user_rank')[0];
	var strDateSpace = htmlmodal.getElementsByClassName('vac_start_date')[0];
	var endDateSpace = htmlmodal.getElementsByClassName('vac_end_date')[0];
	var contentSpace = htmlmodal.getElementsByClassName('approval_content')[0];
	var todaySpace = htmlmodal.getElementsByClassName('approval_create_date')[0];
	
	//세션에 존재하는 값은 미리 로드
	deptSpace.textContent = dept;
	nameSpace.textContent = name;
	reqUserNameSpace.textContent = name;
	rankSpace.textContent = rank;
	
	//결재라인 지정 시 미리보기 창에 보여주기
	
	//테이블을 붙일 공간
	var infoArea = htmlmodal.querySelector('.modal-body');
	var paySpace = infoArea.querySelectorAll('div')[1];
	
//	console.log(paySpace);
	var beforeTable = paySpace.querySelector('table');
	
	//미리보기 창을 다시 열 시 기존에 있던 테이블 지우기.
	if(beforeTable){
		beforeTable.parentNode.removeChild(beforeTable);
	}
	
	var selectedPayLine = document.getElementById('selectedPayLine');
	
    // table 요소
	if (selectedPayLine && selectedPayLine.children.length > 0) {
		
    var table = selectedPayLine.querySelector('table');
   
    
    // table이 존재하면 작업을 수행
    if (table) {
	
		 //깊은 복사를 위한 true 값
	    var cloneTable = table.cloneNode(true);
			    
//	    console.log(table, cloneTable);

        // 복사한 테이블의 tbody 요소.
        var tbody = cloneTable.querySelector('tbody');
        
//        console.log(tbody);
        
        if (tbody) {
            // 복사한 tbody에 float: right, margin-right 속성 추가.
            tbody.style.float = 'right';
            tbody.style.marginRight = '15%';
            tbody.style.border = '1px';
        }
        
        // th 태그를 감싸고 있는 tr 태그를 제거.
        var thRow = cloneTable.querySelector('tr');
        if (thRow) {
            thRow.parentNode.removeChild(thRow);
        }
        
        // 기존의 td 태그를 가진 tr 태그를 복제하여 추가.
        var tdCols = cloneTable.querySelectorAll('td');
        if (tdCols && tdCols.length > 0) {
			var newRow = document.createElement('tr');
			newRow.setAttribute('style', 'height:60px');
            for (var i = 0; i < tdCols.length; i++) {
                newRow.appendChild(document.createElement('td'));
            }
                tbody.appendChild(newRow);
        }
        
        // paySpace에 복사한 table을 추가.
         paySpace.appendChild(cloneTable);
    }
    
	}
	
	
	//시작일 종료일
	var startDate = document.getElementById('startDate');
	var endDate = document.getElementById('endDate');
	
	//시작시간/종료시간
	var startTime = document.getElementById('startTime');
	var endTime = document.getElementById('endTime');
	
	//반가일 시 종료날짜 지정은 없애고 종료일과 시작일을 같게 만듦
	if(endDate.style.display == 'none'){
		endDate.value = startDate.value;
	}
	
	//시간 설정 없을 시 날짜만 표시되게
	let vaStart;
	let vaEnd;
	if(startTime.value != '' && endTime.value != ''){
		vaStart = startDate.value + ' / ' + startTime.value;
		vaEnd = endDate.value + ' / ' + endTime.value;
	}
	else{
		vaStart = startDate.value;
		vaEnd = endDate.value ;
	}
	
	strDateSpace.textContent = vaStart;
	endDateSpace.textContent = vaEnd;
	
	 //현재 날짜 생성
	 var today = new Date();
	 var year = today.getFullYear();
	 var month = today.getMonth() + 1;
	 var day = today.getDate();
	 
	 if (month < 10) {
    month = '0' + month;
	}
	if (day < 10) {
	    day = '0' + day;
	}
	 
	 var todate = year + " 년 " + month + " 월 " + day + " 일 ";
	 todaySpace.textContent = todate; 
	
	var inputContent = document.getElementById('approvalContent').value;
//	console.log(inputContent);
	contentSpace.querySelector('span').style.wordWrap = 'break-word';  
	contentSpace.querySelector('span').textContent = inputContent;
	
	app_content = htmlmodal.getElementsByClassName('modal-body')[0].innerHTML;
	
	
	
	
}


//기안 신청 함수
function draft_application(){
	
	//입력 내용들을 체크.
	var modal = document.querySelector('#req_preview1');
	
	var dept = modal.getElementsByClassName('approval_user_dept')[0].textContent;
	var name = modal.getElementsByClassName('approval_user_name')[0].textContent;
	var reqUserName = modal.getElementsByClassName('create_user_name')[0].textContent;
	
//	console.log(dept, name, reqUserName);
	if(!(dept&&name&&reqUserName)){
		alert('로그인 정보를 확인해 주세요.');
		return;
	}
	
//	var table = modal.querySelector('.ec-editable');
	var payOp = modal.querySelector('.approval_va_opt').textContent;
	
	if(!payOp){
		alert('연차 종류를 선택해주세요.');
		return;
	}
	
	var strDate = modal.querySelector('.vac_start_date').textContent;
	var endDate = modal.querySelector('.vac_end_date').textContent;
	
	if(!(strDate&&endDate)){
		alert('기간을 지정해주세요.');
		return;
	}
	
	var appContent = modal.querySelector('.approval_content').textContent;
	if(!appContent){
		alert('사유를 입력해주세요.');
		return;
	}
	
	var body = modal.querySelector('.modal-body');
//	console.log(body);
	var payTable = body.querySelectorAll('div')[1].querySelector('table')
	if(!payTable){
		alert('결재라인 지정은 필수 입니다.');
		return;
	}

	//입력내용 체크 종료
	
	//요청을 보낼 데이터 모으기
	
	//전자결재 테이블 정보
	var user_id = document.querySelector('[name = "user_id"]').value;
	var app_title = document.querySelector('[name = "app_title"]').value;
	var app_content = body.innerHTML;
	var gian_seq = 'GIAN_1';
	var app_strdate = document.querySelector('#startDate').value;
	var app_enddate = document.querySelector('#endDate').value;
	var approval = {
		"user_id" : user_id,
		"app_title" : app_title,
		"app_content" : app_content,
		"gian_seq" : gian_seq,
		"app_strdate" : app_strdate,
		"app_enddate" : app_enddate
	}
	
//	console.log('전자결재 정보 : ',approval);
	
	//결재라인 테이블정보
	let paymentLine = [];
//	지정한 결재인 만큼의 수를 반복하여 결재인 데이터 만들기.
	var lineTable = document.querySelector('#selectedPayLine').querySelector('table');
	var rows = lineTable.querySelectorAll('td');
	for(let i = 0; rows.length > i; i++){
		var pay_num = rows[i].getAttribute('name');
		var pay_user = rows[i].getAttribute('value');
		var pay = {"pay_num" : pay_num,
					"pay_user" : pay_user};
//		생성된 객체 하나씩 배열에 넣기
		paymentLine.push(pay);
	}
//	console.log(paymentLine);
	
	var jsonForm = JSON.stringify({'ApprovalVo' : approval, 'PaymentlineVoList' : paymentLine});
	
//	console.log('제이슨 형태로 만들어 보자 : ',jsonForm);
//	console.log('데이터 타입은? : ',typeof jsonForm);
//	var appro = JSON.stringify(approval); 

	fetch('./myPayInsert.do', {
		method : 'POST',
		headers : {'Content-Type' : 'application/json'},
		body : jsonForm
	}).then(response => {
		if (!response.ok) {
	        throw new Error('요청에 실패하였습니다!');
	    }
	    return response.text();
	}).then(data => {
		if(data === 'success'){
		 console.log('Success:', data);
		 alert('결재신청에 성공하였습니다.');
		 window.location.href = './myPayList.do'
		 return;
		 }
		 alert('결재신청에 실패하였습니다. 다시 시도해주세요.');
		 console.log('Fail:', data);
	}).catch(error => {
	    console.error('Error:', error);
	});
	
	
}




//날짜 지정 옵션
function checkDateorder(){
	var endDate = document.getElementById('endDate');
	var startDate = document.getElementById('startDate');
	
	var frontDate = new Date(startDate.value);
	var backDate = new Date(endDate.value);
//	console.log(frontDate, backDate);	

	if(frontDate > backDate) {
		endDate.value = '';
		endDate.focus;
		alert('종료일은 시작일보다 이를 수 없습니다.');
		return;
	}
}

//시간 지정 옵션
function checkTimeOrder(){
	var startTime = document.getElementById('startTime').value;
	var endTime = document.getElementById('endTime');
	var endTimeVal = endTime.value;
	
//	var frontTime = new Date(startTime.value);
//	var backTime = new Date(endTime.value);
//	console.log(startTime, endTime);
	
	if(startTime > endTimeVal){
		endTime.value = '';
		endTime.focus;
		alert('종료시간은 시작시간보다 이를 수 없습니다.');
		return;
	}
	
}


//결재 임시저장
function saveApproval(){
	
	//입력 내용들을 체크.
	var modal = document.querySelector('#req_preview1');
	
	var dept = modal.getElementsByClassName('approval_user_dept')[0].textContent;
	var name = modal.getElementsByClassName('approval_user_name')[0].textContent;
	var reqUserName = modal.getElementsByClassName('create_user_name')[0].textContent;
	
	if(!(dept&&name&&reqUserName)){
		alert('로그인 정보를 확인해 주세요.');
		return;
	}
	
	var payOp = modal.querySelector('.approval_va_opt').textContent;
	
	if(!payOp){
		alert('연차 종류를 선택해주세요.');
		return;
	}
	
	var strDate = modal.querySelector('.vac_start_date').textContent;
	var endDate = modal.querySelector('.vac_end_date').textContent;
	
	if(!(strDate&&endDate)){
		alert('기간을 지정해주세요.');
		return;
	}
	
	var appContent = modal.querySelector('.approval_content').textContent;
	if(!appContent){
		alert('사유를 입력해주세요.');
		return;
	}
	
	var body = modal.querySelector('.modal-body');
//	console.log(body);
	var payTable = body.querySelectorAll('div')[1].querySelector('table')
	if(!payTable){
		alert('결재라인 지정은 필수 입니다.');
		return;
	}

	//입력내용 체크 종료
	
	//요청을 보낼 데이터 모으기
	
	//전자결재 테이블 정보
	var user_id = document.querySelector('[name = "user_id"]').value;
	var app_title = document.querySelector('[name = "app_title"]').value;
	var app_content = body.innerHTML;
	var gian_seq = 'GIAN_1';

	var approval = {
		"user_id" : user_id,
		"app_title" : app_title,
		"app_content" : app_content,
		"gian_seq" : gian_seq,
	}
	
	console.log(approval);
	
	let paymentLine = [];
//	지정한 결재인 만큼의 수를 반복하여 결재인 데이터 만들기.
	var lineTable = document.querySelector('#selectedPayLine').querySelector('table');
	var rows = lineTable.querySelectorAll('td');
	for(let i = 0; rows.length > i; i++){
		var pay_num = rows[i].getAttribute('name');
		var pay_user = rows[i].getAttribute('value');
		var pay = {"pay_num" : pay_num,
					"pay_user" : pay_user};
//		생성된 객체 하나씩 배열에 넣기
		paymentLine.push(pay);
	}
	
	var jsonForm = JSON.stringify({'ApprovalVo' : approval, 'PaymentlineVoList' : paymentLine});
	
//	console.log('제이슨 형태로 만들어 보자 : ',jsonForm);
//	console.log('데이터 타입은? : ',typeof jsonForm);
//	var appro = JSON.stringify(approval); 

	fetch('./myTempInsert.do', {
		method : 'POST',
		headers : {'Content-Type' : 'application/json'},
		body : jsonForm
	}).then(response => {
		if (!response.ok) {
	        throw new Error('요청에 실패하였습니다!');
	    }
	    return response.text();
	}).then(data => {
		if(data === 'success'){
		 console.log('Success:', data);
		 alert('임시저장에 성공하였습니다.');
		 location.reload();
		 return;
		 }
		 alert('임시저장에 실패하였습니다. 다시 시도해주세요.');
		 console.log('Fail:', data);
	}).catch(error => {
	    console.error('Error:', error);
	});
	
	
}




/********** 1탭 끝*************/

