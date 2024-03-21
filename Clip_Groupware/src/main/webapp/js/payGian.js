var oEditors1 = [];
var oEditors2 = [];
var oEditors3 = [];

nhn.husky.EZCreator.createInIFrame({
	oAppRef : oEditors1,
	elPlaceHolder : "smartEditor1", //저는 textarea의 id와 똑같이 적어줬습니다.
	sSkinURI : "se2/SmartEditor2Skin.html", //경로를 꼭 맞춰주세요!
	fCreator : "createSEditor2",
	htParams : {
		// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseToolbar : true,

		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : false,

		// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : false,
		fonBeforeUnload:function(){
			
		}
	}
});
nhn.husky.EZCreator.createInIFrame({
	oAppRef : oEditors2,
	elPlaceHolder : "smartEditor2", //저는 textarea의 id와 똑같이 적어줬습니다.
	sSkinURI : "se2/SmartEditor2Skin.html", //경로를 꼭 맞춰주세요!
	fCreator : "createSEditor2",
	htParams : {
		// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseToolbar : true,

		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : false,

		// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : false,
		fonBeforeUnload:function(){
			
		}
	}
});

nhn.husky.EZCreator.createInIFrame({
	oAppRef : oEditors3,
	elPlaceHolder : "smartEditor3", //저는 textarea의 id와 똑같이 적어줬습니다.
	sSkinURI : "se2/SmartEditor2Skin.html", //경로를 꼭 맞춰주세요!
	fCreator : "createSEditor2",
	htParams : {
		// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseToolbar : true,

		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : false,

		// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : false,
		fonBeforeUnload:function(){
			
		}
	}
});

document.getElementById('tempSave').addEventListener('click', function(event) {
	event.preventDefault(); //폼 이벤트 막아줌
	var formData = new FormData(document.getElementById('insertForm'));
    
    fetch('./tempSave.do', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        alert('임시저장되었습니다.');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('저장 중 오류가 발생했습니다.');
    });
});

/* $(function() {
	$("#savebutton").click(function() {
		oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []); 
		//textarea의 id를 적어줍니다.

		//var selcatd = $("#selcatd > option:selected").val();
		var gian_name = $("#gian_name").val();
		var gian_html = document.getElementById("smartEditor").value;;

		if (gian_name == null || gian_name == "") {
			alert("기안서명을 입력해주세요.");
			$("#gian_name").focus();
			 return false;
		}
		if(gian_html == "" || gian_html == null || gian_html == '&nbsp;' || 
				gian_html == '<br>' || gian_html == '<br/>' || gian_html == '<p>&nbsp;</p>'){
			alert("기안서내용을 작성해주세요.");
			oEditors.getById["smartEditor"].exec("FOCUS"); //포커싱
			return false;
		}
		
		var result = confirm("작성을 완료하시겠습니까?");
		
		if(result){
			alert("입력이 완료되었습니다.");
			$("#noticeWriteForm").submit();
		}else{
			return false;
		}
	});
}) */