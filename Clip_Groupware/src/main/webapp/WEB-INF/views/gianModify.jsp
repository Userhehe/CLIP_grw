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
			<form action="./gianMod.do<%-- ?gian_seq=${vo.gian_seq} --%>" method="post">
				<div class="row">
					기안서 코드:<input type="text" name="gian_seq" class="form-control" value="${vo.gian_seq}" readonly="readonly"><br>
					기안서 분류코드:<input type="text" name="gian_gubun" class="form-control" value="${vo.gian_gubun}" readonly="readonly"><br>
					기안서 내용 :<textarea rows="10" name="gian_html" >${vo.gian_html}</textarea><br>
	 			</div>
			<button class="btn btn-primary rounded-pill">수정하기</button>
			 <button class="btn btn-danger rounded-pill" type="button" onclick="location.href='./paytemplate.do'">취소하기</button>
 			</form>
		</section>
	</main>
</body>
</html>