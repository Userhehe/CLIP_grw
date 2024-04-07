<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>	
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>CLIP GROUPWARE</title>
<%@ include file="./header.jsp" %>
<!-- SmartEditor2 라이브러리  -->
<script type="text/javascript" src="se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>
	<main id="main" class="main">
		<section class="section dashboard">
			<form action="./gianMod.do<%-- ?gian_seq=${vo.gian_seq} --%>" method="post">
				<div class="row">
					기안서 코드:<input type="text" name="gian_seq" class="form-control" value="${vo.gian_seq}" readonly="readonly"><br>
					기안서 분류코드:<input type="text" name="gian_gubun" class="form-control" value="${vo.gian_gubun}" readonly="readonly"><br>
					기안서 내용 :
	 			<!-- SmartEditor2 구역 -->
				<div class="jsx-2303464893 editor" name="gian_html">
					<div class="fr-box fr-basic fr-top" role="application">
						<div class="fr-wrapper show-placeholder" dir="auto" style="overflow: scroll;">
							<textarea name="gian_html" id="smartEditor" style="width: 100%; height: 412px;">${vo.gian_html}</textarea>							
						</div>
					</div>
				</div>
	 			</div>
			<button class="btn btn-warning " id="savebutton">수정하기</button>
			 <button class="btn btn-secondary " type="button" onclick="location.href='./paytemplate.do'">취소하기</button>
 			</form>
		</section>
	</main>
</body>
</html>
<!-- editor.js는  html 젤 아래에 넣어야 충돌이 발생 안됨. -->
<script type="text/javascript">
var oEditors = [];

nhn.husky.EZCreator.createInIFrame({
	oAppRef : oEditors,
	elPlaceHolder : "smartEditor", //저는 textarea의 id와 똑같이 적어줬습니다.
	sSkinURI : "se2/SmartEditor2Skin.html", //경로를 꼭 맞춰주세요!
	fCreator : "createSEditor2",
	htParams : {
		// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseToolbar : true,

		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : false,

		// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : false
	}
});
$(function() {
	$("#savebutton").click(function() {
		oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []); 
		//textarea의 id를 적어줍니다.
		var gian_html = document.getElementById("smartEditor").value;;

		if(gian_html == "" || gian_html == null || gian_html == '&nbsp;' || 
				gian_html == '<br>' || gian_html == '<br/>' || gian_html == '<p>&nbsp;</p>'){
			alert("기안서내용을 작성해주세요.");
			oEditors.getById["smartEditor"].exec("FOCUS"); //포커싱
			return false;
		}
		
		var result = confirm("수정을 완료하시겠습니까?");
		
		if(result){
			alert("수정이 완료되었습니다.");
			$("#noticeWriteForm").submit();
		}else{
			return false;
		}
	});
})
</script>