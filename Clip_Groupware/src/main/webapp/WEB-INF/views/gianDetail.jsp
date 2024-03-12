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
				기안서 코드:<input type="text" class="form-control" value="${vo.gian_seq}" readonly="readonly"><br>
				기안서 구분 :<input type="text" class="form-control" value="${vo.gian_gubun}" readonly="readonly"><br>
				작성자 :<input type="text" class="form-control" value="${vo.gian_modifier}" readonly="readonly"><br>
				등록일 :<input type="text" class="form-control" value="${vo.gian_regdate}" readonly="readonly"><br>
				기안서 내용 :<textarea rows="10" readonly="readonly">${vo.gian_html}</textarea>
			</div>
			<a href="./gianModify.do?gian_seq=${vo.gian_seq}"><button class="btn btn-primary rounded-pill">양식수정</button></a>
			<a href="./paytemplate.do"><button class="btn btn-danger rounded-pill">목록으로</button></a>
		</section>
	</main>
</body>
</html>