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
	function submitReq(){
	
	
	var textarea = document.querySelector('#smartEditor1');

	var textarea2 = $('#smartEditor1');

//	var deptarea = textarea.getElementsByClassName('approval_user_dept')[0];
//	var namearea = textarea.getElementsByClassName('approval_user_name')[0];
//	var rankarea = textarea.getElementsByClassName('approval_user_rank')[0];
	
	console.log(textarea,textarea2);
	
	}
	
	document.getElementById('sunbmitReq').addEventListener('click', submitReq);
}


