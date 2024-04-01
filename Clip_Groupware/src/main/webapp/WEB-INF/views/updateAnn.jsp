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
</head>
<body>
	<main id="main" class="main">
    <div class="container" style="margin: 0;">
        <div class="card-body w661_5px">
            <h5 class="card-title font20">연차 수정</h5>
            <form action="./updateAnn.do" method="post">
                <input type="hidden" name="user_id" value="${user_id}"/>
                <!-- 사용자 정보 출력 -->
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label font12">계정 아이디</label>
                    <div class="col-sm-10">
                        <span>${user_id}</span>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label font12">이름</label>
                    <div class="col-sm-10">
                        <span>${user_name}</span>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label font12">부서명</label>
                    <div class="col-sm-10">
                        <span>${dept_name}</span>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label font12">직책명</label>
                    <div class="col-sm-10">
                        <span>${positions_name}</span>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label font12">직급명</label>
                    <div class="col-sm-10">
                        <span>${ranks_name}</span>
                    </div>
                </div>
                <!-- 연차 수정 입력 폼 -->
                <div class="row mb-3">
                    <label for="ann_day" class="col-sm-2 col-form-label font12"><span class="fc_red">&nbsp;</span>연차수정</label>
                    <div class="col-sm-10">
                        <input type="number" id="ann_day" name="ann_day" class="form-control w249_8px ib" placeholder="수정할 연차를 입력하세요" required="required">
                    </div>
                </div>
                <br>
                <!-- 연차 수정 버튼 -->
                <div class="row mb-3">
                    <div>
                        <button type="submit" class="btn btn-secondary button">연차 수정</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</main>

</body>
</html>