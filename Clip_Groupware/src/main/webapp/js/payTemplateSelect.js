function modify(){
   console.log("수정 modal 버튼 클릭");
  
  
}

function half(event) {
	
	//휴가계 종류에 가져오기
	var selectedOpt = event.options[event.selectedIndex];
	var vaOpt = selectedOpt.textContent;
//	console.log(vaOpt);		
	//가져온 종류 미리보기에 넣기
	var htmlmodal = document.getElementById("req_preview1");
	var vaOptSpace = htmlmodal.getElementsByClassName('approval_va_opt')[0];
	vaOptSpace.textContent = vaOpt;

	
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
	console.log(inputContent);
	
	contentSpace.textContent = inputContent;
	
	app_content = htmlmodal.getElementsByClassName('modal-body')[0].innerHTML;
}





window.onload = function(){
	
	 var endDate = document.getElementById('endDate');
	 endDate.addEventListener('change',checkDateorder);
	 var endTime = document.getElementById('endTime');
	 endTime.addEventListener('change',checkTimeOrder);
	 
	
	 
	 
	 
}





//날짜 지정 옵션
function checkDateorder(){
	var endDate = document.getElementById('endDate');
	var startDate = document.getElementById('startDate');
	
	var frontDate = new Date(startDate.value);
	var backDate = new Date(endDate.value);
	console.log(frontDate, backDate);	

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
	console.log(startTime, endTime);
	
	if(startTime > endTimeVal){
		endTime.value = '';
		endTime.focus;
		alert('종료시간은 시작시간보다 이를 수 없습니다.');
		return;
	}
	
}




