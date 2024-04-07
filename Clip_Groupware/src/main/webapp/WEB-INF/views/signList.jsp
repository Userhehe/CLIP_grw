<%@page import="com.clip.gwr.vo.UserinfoVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>서명 리스트 조회</title>

    <!-- SweetAlert 스크립트 추가 -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <!-- jQuery 스크립트 추가 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- 서명 스크립트 추가 -->
    <script type="text/javascript" src="./js/selpad.js"></script>
    <%@ include file="./header.jsp" %>
    <style>
        /* 추가적인 CSS 스타일링 */
        /* .action-buttons 등의 추가적인 스타일을 여기에 정의할 수 있습니다. */

        /* 테이블 제목 행 스타일링 */
        table th {
            background-color: #f8f9fa; /* 배경색 변경 */
        }

        /* 테이블 행 간격 추가 */
        table tbody tr {
            margin-bottom: 10px;
        }

        /* 삭제 버튼 정렬 */
        .action-buttons {
            text-align: center;
        }
        
          #padnew {
            float: right;
            margin-top: 10px; 
            margin-right: 45px;
        }
        
    </style>
</head>
<body>
    <% UserinfoVo loginUserVo = (UserinfoVo)session.getAttribute("loginVo"); %>
    <main id="main" class="main">
    <h2>서명 리스트 </h2>
        <div id="container" style="margin-top: 50px;">
            <div style="text-align: center;">
                <table class="table table-striped" style="margin-top: 10px;">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>작성자</th>
                            <th>이름</th>
                            <th>제목</th>
                            <th>작성날짜</th>
                            <th class="action-buttons">삭제여부</th>
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
            <div style="text-align: center;">
                <button id="padnew" class="btn btn-secondary rounded-pill" type="button" onclick="location.href='./insertPad.do'">서명생성</button>           
            </div>
        </div>
    </main>
</body>
</html>
