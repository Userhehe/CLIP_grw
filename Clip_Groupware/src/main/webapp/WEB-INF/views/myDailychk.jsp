<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>나의 근태 조회</title>
    <%@ include file="./header.jsp"%>
    <link href="./assets/css/dailyCheck.css" rel="stylesheet">
    <style>
        .card-body {
            margin-top: 60px;
        }
    </style>
</head>
<body>
<main id="main" class="main">
    <div class="card-body">
        <h2 class="card-title">나의 근태 조회</h2>
        <br>
        <table class="table table-hover" id="dailyCheckTable">
            <thead>
            <tr>               
                <th scope="col">출근시간</th>
                <th scope="col">퇴근시간</th>
                <th scope="col">출퇴근여부</th>
                <th scope="col">날짜</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="list" items="${lists}">
                <tr>
                    <td>${list.daily_intime}</td>
                    <td>${list.daily_outtime}</td>
                    <td>${list.daily_status}</td>
                    <td>${fn:substring(list.daily_regdate, 0, 10)}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>
