<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>부서관리</title>
    <style>
        /* 수정 및 삭제 버튼을 오른쪽으로 정렬 */
        .action-buttons {
            text-align: right;
        }

        /* 오른쪽 정렬을 위한 스타일 */
        .search-container {
            display: flex;
            justify-content: flex-end;
        }

        /* 검색창과 버튼 간격 조정 */
        .search-container > * {
            margin-left: 10px;
        }
    </style>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="./js/dept.js"></script>
    <%@ include file="./header.jsp"%>
</head>
<body>
    <main id="main" class="main">
        <section class="section dashboard">
            <div class="row">
                <div class="search-container">
                    <div>
                        <input style="width: 250px; display: unset;" id="dept_name" class="form-control" type="text" placeholder="부서명 입력해주세요.">
                        <button class="btn btn-primary rounded-pill" id="deptSearch">검색</button>
                    </div>
                </div>
            </div>
            <form action="./tree.do" method="post" onsubmit="return chsSubmit()">
                <table class="table table-striped" style="margin-top: 10px;">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>부서코드</th>
                            <th>부서명</th>
                            <th>등록일</th>
                        </tr>
                    </thead>
                    <tbody id="deptTableBody">
                        <c:forEach var="lists" items="${lists}" varStatus="vr">
                            <tr>
                                <td>${vr.count}</td>
                                <td>${lists.dept_seq}</td>
                                <td>${lists.dept_name}</td>
                                <td>${lists.dept_regdate}</td>
                                <td style="text-align: right;">
                                    <a href="./updateDept.do" style="margin-right: 10px;">
                                        <button class="btn btn-info rounded-pill" >수정</button>
                                    </a>
                                    <a href="./delDept.do">
                                        <button class="btn btn-danger rounded-pill">삭제</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
            <a href="./insertDept.do"><button class="btn btn-primary rounded-pill">부서 추가</button></a>
        </section>
        <script type="text/javascript">
	document.getElementById('deptSearch').addEventListener('click', function() {
	    var searchKeyword = document.getElementById('dept_name').value;
	    fetch('./searchDept.do?dept_name=' + searchKeyword)
	        .then(function(response) {
	            if (!response.ok) {
	                throw new Error('서버 응답 실패');
	            }
	            return response.text();
	        })
	       .then(function(responseText) {
			    document.getElementById('deptTableBody').innerHTML = responseText;
			})
	        .catch(function(error) {
	            console.error('처리가 실패되었습니다.', error);
	        });
	});
	</script>
    </main>
</body>
</html>