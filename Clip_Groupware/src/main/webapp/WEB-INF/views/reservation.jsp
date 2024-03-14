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
<%@ include file="./header.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
<script type="text/javascript" src="./js/reservation.js"></script>
</head>
<body>
	<main id="main" class="main">
		<div class="row">
		
			<select>
				<c:forEach var="vo" items="${meeTingRoomVo}">
					<option value="${vo.me_room}">${vo.me_room}번 회의실</option>
				</c:forEach>
			</select>
			<label for="re_start" class="col-form-label">시작 날짜</label>
            <div class="input-group">
               <input type="text" class="form-control" readonly="readonly" ondblclick="return false" id="re_start" name="re_start">
               <span class="input-group-addon" id="re_start_img"><i class="glyphicon glyphicon-calendar"></i></span>
            </div>
            
            
            
			
               
		</div>
	</main>
</body>
</html>