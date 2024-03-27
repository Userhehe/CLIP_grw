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

