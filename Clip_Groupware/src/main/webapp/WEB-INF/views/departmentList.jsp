<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>부서관리</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<%@ include file="./header.jsp"%>
</head>
<body>
<main id="main" class="main">
    <section class="section dashboard">
        <div class="row">
            <div style="margin-left: 560px;">
                <select style="width: 10%; display: unset;" class="form-select" name="dept_search">
                    <option value="">구분</option>
                    <option value="dept_name">부서명</option>
                </select>
                <input style="width: 250px; display: unset;" id="dept_name" class="form-control" type="text" placeholder="검색어를 입력해주세요.">
                <button class="btn btn-primary rounded-pill" id="deptSearch">검색</button>
            </div>
            <form action="./searchDept.do" method="post" onsubmit="return chsSubmit()">
                <table class="table table-striped" style="margin-top: 10px;">
                    <thead>
                    <tr>
                        <th><input type="checkbox" class="allCheckBox" id="chCheck" onclick="checkAll(this.checked)"></th>
                        <th>부서코드</th>
                        <th>부서명</th>
                        <th>등록일</th>
                    </tr>
                    </thead>
                    <tbody id="tableBody">
                    <c:forEach var="lists" items="${lists}" varStatus="vr">
                        <tr>
                            <td>${vr.count}</td>
                            <td>${lists.dept_seq}</td>
                            <td>${lists.dept_name}</td>
                            <td>${lists.dept_regdate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
        <a href="./insertDept.do"><button class="btn btn-primary rounded-pill">부서 추가</button></a>
        <a href="./updateDept.do"><button class="btn btn-danger rounded-pill" >부서 수정</button></a>
    </section>
</main>
</body>
</html>
