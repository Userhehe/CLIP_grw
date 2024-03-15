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
			<form action="./gianInsert.do" method="post">
					등록하실 기안서의 분류코드를 선택해주세요.
					<select class="form-select" name="gian_gubun">
						<option value="">--분류코드를 선택해주세요.--</option>
						<option value="휴가">VA(휴가)</option>
						<option value="비용">PAY(비용)</option>
						<option value="기타">기타(ETC)</option>
					</select><br>
				등록하실 기안서의 이름을 입력해주세요.
				<input type="text" name="gian_name" id="gian_name" class="form-control"><br>
				작성자
				<input type="text" name="gian_modifier" class="form-control" readonly="readonly" value="서종우"><br>
				등록하실 기안서의 내용을 입력해주세요.
				<!-- SmartEditor2 구역 -->
				<div class="jsx-2303464893 editor" name="gian_html">
					<div class="fr-box fr-basic fr-top" role="application">
						<div class="fr-wrapper show-placeholder" dir="auto" style="overflow: scroll;">
							<textarea name="gian_html" id="smartEditor" style="width: 100%; height: 412px;"></textarea>							
						</div>
					</div>
				</div>
			<button class="btn btn-primary rounded-pill" id="savebutton">등록하기</button>
			<button class="btn btn-danger rounded-pill" type="button" onclick="location.href='./paytemplate.do'">취소하기</button>
			</form>
			</div>
		</section>
	</main>
</body>
</html>
<!-- editor.js는  html 젤 아래에 넣어야 충돌이 발생 안됨. -->
<script type="text/javascript" src="./js/editor.js"></script>