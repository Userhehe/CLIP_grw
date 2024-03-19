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
			<div class="row">
				기안서 코드:<input type="text" class="form-control" value="${vo.gian_seq}" readonly="readonly"><br>
				기안서 구분 :<input type="text" class="form-control" value="${vo.gian_gubun}" readonly="readonly"><br>
				작성자 :<input type="text" class="form-control" value="${vo.gian_modifier}" readonly="readonly"><br>
				등록일 :<input type="text" class="form-control" value="${vo.gian_regdate}" readonly="readonly"><br>
				기안서 내용 :<textarea name="gian_html" id="smartEditor" style="width: 100%; height: 412px;">${vo.gian_html}</textarea>	
			<div style="margin-top:40px;">
				<a href="./gianModify.do?gian_seq=${vo.gian_seq}"><button class="btn btn-primary rounded-pill">양식수정</button></a>
				<a href="./paytemplate.do"><button class="btn btn-danger rounded-pill">목록으로</button></a>
			</div>
		</section>
	</main>
</body>
</html>
<script type="text/javascript">
var oEditors = [];

nhn.husky.EZCreator.createInIFrame({
	oAppRef : oEditors,
	elPlaceHolder : "smartEditor", //저는 textarea의 id와 똑같이 적어줬습니다.
	sSkinURI : "se2/SmartEditor2Skin.html", //경로를 꼭 맞춰주세요!
	fCreator : "createSEditor2",
	htParams : {
		// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseToolbar : false,

		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : false,

		// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : false
	},
	 fOnAppLoad: function(){
	        // 에디터 로드 후 읽기 전용 모드 설정
	        oEditors.getById["smartEditor"].exec("DISABLE", []); // 에디터를 비활성화합니다.
	    }
});
</script>