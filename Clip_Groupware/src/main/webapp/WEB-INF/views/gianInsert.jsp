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
				<input type="text" name="gian_name" class="form-control"><br>
				작성자
				<input type="text" name="gian_modifier" class="form-control" readonly="readonly" value="서종우"><br>
				등록하실 기안서의 내용을 입력해주세요.
				<textarea class="form-control" name="gian_html"  rows="10"></textarea><br>
			<button class="btn btn-primary rounded-pill">등록하기</button>
			<button class="btn btn-danger rounded-pill" type="button" onclick="location.href='./paytemplate.do'">취소하기</button>
			</form>
			</div>
		</section>
	</main>
</body>
</html>