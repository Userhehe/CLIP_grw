function modify(){
   console.log("수정 modal 버튼 클릭");
  
  
}

function half(value) {
    const show = (value === "halfDay"); 
    document.getElementById("startTime").style.display = show ? "inline" : "none";
    document.getElementById("endTime").style.display = show ? "inline" : "none";
    
    var htmlOpt = document.getElementsByClassName('approval_va_opt')
	console.log(htmlOpt); 
	
	console.log($("tbody>tr>.approval_va_opt"));
	
	
}





window.onload = function(){
	//세션에 저장된  값
	var name = document.getElementById("session_user_name").value;
	var rank = document.getElementById("session_ranks_name").value;
	var dept = document.getElementById("session_dept_name").value;
	var userId = document.getElementById("session_user_id").value; 
	
	console.log(name,dept,rank, userId);
	
	var htmlmodal = document.getElementById("req_preview1");
	console.log(htmlmodal);
	
	var deptSpace = htmlmodal.getElementsByClassName('approval_user_dept')[0];
	var nameSpace = htmlmodal.getElementsByClassName('approval_user_name')[0];
	var reqUserNameSpace = htmlmodal.getElementsByClassName('create_user_name')[0]
	var rankSpace = htmlmodal.getElementsByClassName('approval_user_rank')[0];
	var vaOptSpace = htmlmodal.getElementsByClassName('approval_va_opt')[0];
	var strDateSpace = htmlmodal.getElementsByClassName('vac_start_date')[0];
	var endDateSpace = htmlmodal.getElementsByClassName('vac_end_date')[0];
	var contentSpace = htmlmodal.getElementsByClassName('approval_content')[0];
	var todaySpace = htmlmodal.getElementsByClassName('approval_create_date')[0];
	
	//세션에 존재하는 값은 미리 로드
	deptSpace.textContent = dept;
	nameSpace.textContent = name;
	reqUserNameSpace.textContent = name;
	rankSpace.textContent = rank;
	
	
	
	
	
	
	
	
	
}




