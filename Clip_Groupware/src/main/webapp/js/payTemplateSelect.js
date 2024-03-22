function modify(){
   console.log("수정 modal 버튼 클릭");
  
  
}

function half(value) {
    const show = (value === "halfDay" || value ==="halfHalfDay"); 
    document.getElementById("startTime").style.display = show ? "inline" : "none";
    document.getElementById("endTime").style.display = show ? "inline" : "none";
}