<%@page import="com.clip.gwr.vo.UserinfoVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>사인 리스트 조회</title>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/selpad.js"></script>
    <%@ include file="./header.jsp" %>
</head>
<body>
<%
UserinfoVo loginUserVo = (UserinfoVo)session.getAttribute("loginVo");
%>
<main id="main" class="main">
    <div id="container" style="margin-top: 200px;">
        <div style="text-align: center;">
            <table class="table table-striped" style="margin-top: 10px;">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>작성자</th>
                        <th>이름</th>
                        <th>제목</th>
                        <th>작성날짜</th>   
                        <th class="action-buttons"></th>                  
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="lists" items="${lists}" varStatus="vr">
                        <tr class="row-clickable" data-signs-seq="${lists.signs_seq}">
                            <td>${lists.signs_seq}</td>
                            <td>${lists.user_id}</td>
                            <td>${lists.user_name}</td>
                            <td><a href="./selectPad.do?signs_seq=${lists.signs_seq}">${lists.signs_name}</a></td>
                            <td>${lists.signs_regdate}</td>
                             <td class="action-buttons">
                            <button class="btn btn-danger rounded-pill delete-btn" data-signs-seq="${lists.signs_seq}"  onclick="deleteSign(this)">삭제</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <button class="btn btn-info" type="button" onclick="location.href='./insertPad.do'">서명생성</button>
            <button class="btn btn-danger" type="button" onclick="location.href='./delPad.do'">서명삭제</button>
        </div>
    </div>
</main>
</body>
</html>
