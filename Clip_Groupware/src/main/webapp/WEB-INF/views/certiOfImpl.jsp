<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>재직증명서</title>
<%@ include file="./header.jsp" %>
<link href="./assets/css/certiOfImpl.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/es6-promise/4.1.1/es6-promise.auto.js"></script>
<script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
<script type="text/javascript" src="./js/certiOfImpl.js"></script>
</head>
<body>
	<main id="main" class="main">
		<div id="ct">
			<div id="certCt">
				<c:forEach var="jejicLists" items="${jejicLists}">
					<c:set var="userBirthdaySplit" value="${fn:split(jejicLists.user_birthday, '-')}"/>
					<c:set var="userRegdateSplit" value="${fn:split(jejicLists.user_regdate, '-')}"/>
					<c:set var="todaySplit" value="${fn:split(jejicLists.today, '-')}"/>
					<div id="title">재직증명서</div>
					<div id="first_ct">
						<table id="first_tb">
							<thead>
								<tr>
									<td class="tb_bg_lightgrey tb_bg_lightgrey_first bd_none">소속</td>
									<td colspan="2">&nbsp;${jejicLists.dept_name}팀</td>
									<td class="tb_bg_lightgrey tb_bg_lightgrey_first">직위</td>
									<td colspan="2">&nbsp;${jejicLists.ranks_name}</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="tb_bg_lightgrey">성명</td>
									<td colspan="2">&nbsp;${jejicLists.user_name}</td>
									<td class="tb_bg_lightgrey">생년월일</td>
									<td colspan="2">&nbsp;${userBirthdaySplit[0]}년 ${userBirthdaySplit[1]}월 ${userBirthdaySplit[2]}일</td>
								</tr>
								<tr>
									<td class="tb_bg_lightgrey">입사년월일</td>
									<td colspan="2">&nbsp;${userRegdateSplit[0]}년 ${userRegdateSplit[1]}월 ${userRegdateSplit[2]}일</td>
									<td class="tb_bg_lightgrey">주민등록번호</td>
									<td colspan="2">&nbsp;${jejicLists.user_registnum}</td>
								</tr>
								<tr>
									<td class="tb_bg_lightgrey">주소</td>
									<td colspan="4">${jejicLists.user_address}</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td class="tb_bg_lightgrey">기간</td>
									<td colspan="4">${userRegdateSplit[0]}년 ${userRegdateSplit[1]}월 ${userRegdateSplit[2]}일 ~ ${todaySplit[0]}년 ${todaySplit[1]}월 ${todaySplit[2]}일</td>
								</tr>
							</tfoot>
						</table>
					</div>
					<div id="content">
						<div id="textContent"> ${jejicLists.dept_name}팀 ${jejicLists.positions_name}으로 상기와 같이 재직하고 있음을 증명함</div>
						<div id="today">${todaySplit[0]}년 ${todaySplit[1]}월 ${todaySplit[2]}일</div>
						<div id="companyNameCt">
							<div>주식회사</div>
							<div id="companyName">&nbsp;&nbsp;&nbsp;&nbsp;CLIP&nbsp;&nbsp;&nbsp;&nbsp;</div>
						</div>
						<div id="bossNameCt">
							<div>대표이사</div>
							<div id="bossName">${jejicLists.boss_name}(인)</div>
						</div>
						<img id="signImage" alt="서명" src="${signImage}">
					</div>
				</c:forEach>
			</div>
			<button type="button" id="pdfBtn" class="btn btn-secondary">재직증명서 pdf다운로드</button>
		</div>
	</main>
</body>
</html>