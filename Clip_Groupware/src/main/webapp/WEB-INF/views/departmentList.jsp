<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>부서관리</title>
    <style>
    
        .action-buttons {
            text-align: right;
        }

     
        .search-container {
            display: flex;
            justify-content: flex-end;
        }

     
        .search-container > * {
            margin-left: 10px;
        }
        
      
        .action-buttons button {
            margin-left: 10px;
        }
    </style>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="./js/dept.js"></script>
    <%@ include file="./header.jsp"%>
</head>
<body>
    <div class="modal fade" id="deptCheckModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="form-group">
                    <div class="modal-header">
                        <input type="text" id="dept_seq_modal" style="display: none;">
                        <h5 class="modal-title" id="exampleModalLabel">부서명을 입력하세요</h5>
                    </div>                        
                    <div class="modal-body">
                        <textarea class="form-control mt-2" id="dept_name_modal" name="re_content" rows="5" placeholder="부서명을 입력하세요"></textarea>
                    </div>
                    <div class="modal-footer">
                        <input class="btn btn-secondary" type="submit" value="수정완료" id="addDeptCheck"> 
                        <input class="btn btn-secondary" type="button" value="뒤로가기" id="addDeptCheckCancel">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <main id="main" class="main">
        <section class="section dashboard">
            <div class="row">
<!--                <div class="search-container"> -->
<!-- 			    <div> -->
<!-- 			        <input style="width: 250px; display: unset;" id="dept_name" class="form-control" type="text" placeholder="부서명 입력해주세요."> -->
<!-- 			        <button class="btn btn-primary rounded-pill" id="deptSearch">검색</button> -->
<!-- 			    </div> -->
<!-- 			</div> -->
            </div>
            <table class="table table-striped" style="margin-top: 10px;">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>부서코드</th>
                        <th>부서명</th>
                        <th>등록일</th>
                        <th class="action-buttons"></th>
                    </tr>
                </thead>
                <tbody id="deptTableBody">
                    <c:forEach var="lists" items="${lists}" varStatus="vr">
                        <tr>
                            <td>${vr.count}</td>
                            <td class="dept_seq">${lists.dept_seq}</td> 
                            <td class="dept_name">${lists.dept_name}</td> 
                            <td>${lists.dept_regdate}</td>
                           <td class="action-buttons">
						    <button class="open-modal-btn btn btn-info rounded-pill" data-dept-seq="${lists.dept_seq}" data-dept-name="${lists.dept_name}">수정</button>
						    <button class="btn btn-danger rounded-pill delete-btn" data-dept-seq="${lists.dept_seq}" data-dept-name="${lists.dept_name}">삭제</button>
						</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="./insertDept.do"><button class="btn btn-primary rounded-pill">부서 추가</button></a>
        </section>
    </main>
</body>
</html>
