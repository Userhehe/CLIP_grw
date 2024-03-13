function checkAll(bool){
   console.log("checked된 상태", bool);
   var chs = document.getElementsByName("ch");
   for(let i=0; i< chs.length;i++){
      chs[i].checked = bool;
   }
}

$(document).ready(function(){
	console.log("jQuery ready");
	$(".allCheckBox").click(function(){
		console.log("선택된 allCheckBox의 check 상태",this.checked);
		$(".ch").attr("checked",this.checked);
	})
})
window.onload = function(){
   console.log("javascript onload")
   var chs = document.getElementsByName("ch");
   var allCheck = document.getElementById("chCheck")
   for(let i = 0; i< chs.length;i++){
      chs[i].onclick = function(){
         if(chs.length == chsCount()){
            allCheck.checked = true;
         }else{
            allCheck.checked = false;
            
         }
         
      }
         
      }
      
   
}

var chsCount = function(){
   var chs = document.getElementsByName("ch");
   var cnt = 0;
   for(let i=0; i<chs.length; i++){
      if(chs[i].checked){
         cnt++
      }
   }
   //console.log(cnt);
   return cnt;
}

function templateDel(){
	if(chsCount()>0){
		swal({
	  title: "다중삭제확인",
	  text: "삭제를 진행하시겠습니까?",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
	})
	.then((willDelete) => {
	  if (willDelete) {
	    swal("삭제를 실행하겠습니다.", {
	      icon: "success",
	    });
	    console.log("submit 작동실행");
	    submitForm();
	  } else {
	    swal("삭제를 취소하겠습니다.");
	  }
	});
	}else{
		swal('','선택된 글이 없습니다.');
		return false;
	}
	console.log("chsSubmit()마지막라인");
	return false;
}

function submitForm(){
	document.forms[0].submit();
}

function del(val){
	console.log("삭제",val);
	var con = confirm("선택된 글이 삭제됩니다.");
	if(confirm){
		var frm = document.forms[0];
		frm.action="./.do";
		frm.method="post";
		frm.submit();
	}else{
		alert("삭제가 취소되었습니다.");
	}
}


