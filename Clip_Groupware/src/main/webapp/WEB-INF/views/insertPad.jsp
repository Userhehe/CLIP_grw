<%@page import="com.clip.gwr.vo.UserinfoVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<script src="https://cdnjs.cloudflare.com/ajax/libs/signature_pad/1.5.3/signature_pad.min.js"></script>
<link rel="stylesheet" href="./css/sign.css">
<title>서명등록</title>
<%@ include file="./header.jsp" %>
</head>
<body>
<%
UserinfoVo loginUserVo = (UserinfoVo)session.getAttribute("loginVo");
%>
<main id="main" class="main" style="margin-top: 50px;">
<div id="container">
    <div style="text-align: center;">
    <input type="hidden" id="userId" value="${user_id}">
    <input type="hidden" id="userName" value="${user_name}">
        <canvas id="signpad" width="800" height="500"></canvas><br>
         서명 제목 : <input type="text" name="signs_name" id="signs_name" placeholder="서명 제목을 입력하세요"><br>
        <div>
            <button class="btn btn-secondary rounded-pill" id="save">저장</button>
            <button class="btn btn-secondary rounded-pill" id="clear">새로고침</button>
            <button class="btn btn-secondary rounded-pill" id="back">뒤로가기</button>
        </div>
    </div>  
</div>
<script type="text/javascript" src="./js/sign.js"></script> 
</main>
</body>
</html>
