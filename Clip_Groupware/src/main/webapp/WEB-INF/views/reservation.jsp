<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회의실 예약</title>
<%@ include file="./header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
<script type="text/javascript" src="./js/reservation.js"></script>
<style type="text/css">
	ul.jstree-container-ul>li>a>i.jstree-checkbox {
		display: none;
	}
</style>
</head>
<body>
	<main id="main" class="main">
		<div class="row">

			<select name="me_room" id="me_room">
				<c:forEach var="vo" items="${meeTingRoomVo}">
					<option value="${vo.me_room}">${vo.me_room}번회의실</option>
				</c:forEach>
			</select> <label for="re_start" class="col-form-label">시작 날짜</label>
			<div class="input-group">
				<input type="text" class="form-control" readonly="readonly"
					ondblclick="return false" id="re_start" name="re_start"> <span
					class="input-group-addon" id="re_start_img"><i
					class="glyphicon glyphicon-calendar"></i></span>
			</div>
			<br> <input type="button" value="예약가능시간 보기"
				onclick="selectPossibleMeRoomButton()"> <br>
			<div id="nawarayo" style="display: nones">
				<div class="input-group">
					<input type="text" class="form-control" readonly="readonly"
						ondblclick="return false" id="re_start_time" name="re_start_time">
					<span class="input-group-addon" id="re_start_time_img"><i
						class="glyphicon glyphicon-calendar"></i></span>
				</div>
			</div>





		</div>
	</main>
</body>
</html>