<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 신청</title>
<%@ include file="./header.jsp" %>
<script type="text/javascript" src="./js/payTemplateSelect.js"></script>
<!-- SmartEditor2 라이브러리  -->
<script type="text/javascript" src="se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>
	<main id="main" class="main">
		<section class="section dashboard">
              <h5 class="card-title">결재 신청하실 기안서를 선택해주세요.</h5>

              <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">연차 신청서</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="true" >지출 결의서</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false" tabindex="-1">출장 보고서</button>
                </li>
              </ul>
              <div class="tab-content pt-2" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
        	 <!--  연차신청서탭 시작 -->
        	 <div class="container"><br><br>
        <h2 style="text-align:center;">연차 신청서</h2>
        <form id="annualLeaveForm">
            <div class="form-group">
                <label for="applicantName">신청자 이름</label>
                <input type="text" class="form-control" id="applicantName" name="applicantName" required>
            </div>
            <div class="form-group">
                <label for="department">부서</label>
                <input type="text" id="department" class="form-control" name="department" required>
            </div>
            <div class="form-group">
                <label for="position">직위</label>
                <input type="text" id="position" class="form-control" name="position" required>
            </div>
            <div class="form-group">
                <label for="leaveType">연차 종류</label>
                <select id="leaveType" class="form-select" name="leaveType" required>
                    <option value="">선택하세요</option>
                    <option value="fullDay">연차</option>
                    <option value="halfDay">반차</option>
                    <option value="halfhalfDay">반반차</option>
                    <option value="myLifeDay">경조사</option>
                </select>
            </div>
            <div class="form-group">
                <label for="startDate">시작 날짜</label>
                <input type="date" class="form-control" id="startDate" name="startDate" required>
            </div>
            <div class="form-group">
                <label for="endDate">종료 날짜</label>
                <input type="date" class="form-control" id="endDate" name="endDate" required>
            </div>
            <div class="form-group">
                <label for="reason">신청 사유</label>
                <textarea name="registerWhy" id="smartEditor" style="width: 100%; height: 412px;"></textarea>
            </div>
            <button type="submit" class="btn btn-primary rounded-pill">신청하기</button>
		        </form>
		    </div>
            <!--  연차신청서탭 끝 -->
                <div class="tab-pane fade active show" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                   <h2 style="text-align:center;">지출 품의서</h2>
                </div>
                <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
				   <h2 style="text-align:center;">출장 보고서</h2>
                </div>
              </div>
              </div>
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
</script>