<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>연차 정보 수정</title>
<%@ include file="./header.jsp" %>
<link href="./assets/css/userInfoUpdate.css" rel="stylesheet">
<style>
    .container {
        margin: 0;
    }

    .card-body {
        width: 661.5px;
        margin: auto;
        margin-top: 110px;
        margin-right:170px;
        padding: 20px;
        border-radius: 10px;
        background-color: #f8f9fa;
    }

    .card-title {
        font-size: 20px;
        margin-bottom: 20px;
    }

    .font12 {
        font-size: 12px;
    }

    .form-control {
        width: 249.8px;
    }

    .button {
        width: 150px;
    }

    .table {
        width: 100%;
    }

    .table td {
        padding: 10px;
    }

    .table td:first-child {
        background-color: grey;
        color: white;
        width: 30%;
    }
</style>
</head>
<body>
<main id="main" class="main">
    <div class="container">
        <div class="card-body">
            <h5 class="card-title">연차 수정</h5>
            <form action="./updateAnn.do" method="post">
                <input type="hidden" name="user_id" value="${user_id}"/>
                <!-- 사용자 정보 출력 -->
                <table class="table">
                    <tr>
                        <td>계정 아이디</td>
                        <td>${user_id}</td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td>${user_name}</td>
                    </tr>
                    <tr>
                        <td>부서명</td>
                        <td>${dept_name}</td>
                    </tr>
                    <tr>
                        <td>직책명</td>
                        <td>${positions_name}</td>
                    </tr>
                    <tr>
                        <td>직급명</td>
                        <td>${ranks_name}</td>
                    </tr>
                </table>
                <!-- 연차 수정 입력 폼 -->
             <div class="form-group row text-center">
			    <div class="col-sm-12">
			        <label for="ann_day" class="col-form-label font12" style="font-size: 16px;"><span class="fc_red"></span>연차수정 :</label>
			        <input type="number" id="ann_day" name="ann_day" class="form-control ib" placeholder="수정할 연차를 입력하세요" required="required">
			    </div>
			</div>
			<br>
			<!-- 연차 수정 버튼 -->
			<div class="form-group row text-center">
			    <div class="col-sm-12">
			        <button type="submit" class="btn btn-secondary button">연차 수정</button>
			    </div>
			</div>

            </form>
        </div>
    </div>
</main>

</body>
</html>
