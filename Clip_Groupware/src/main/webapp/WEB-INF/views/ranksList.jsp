<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>직급관리</title>
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

        /* 직급 추가 버튼 오른쪽 정렬 */
        .add-rank-btn-container {
            text-align: right;
            margin-top: 10px; /* 버튼과 테이블 사이 간격 조정 */
            margin-right: 30px;
        }

        /* section.dashboard의 위쪽 여백 설정 */
        section.dashboard {
            margin-top: 50px;
        }
    </style>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="./js/ranks.js"></script>
    <%@ include file="./header.jsp"%>
</head>
<body>
    <div class="modal fade" id="ranksCheckModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="form-group">
                    <div class="modal-header">
                        <input type="text" id="ranks_seq_modal" style="display: none;">
                        <h5 class="modal-title" id="exampleModalLabel">직급명을 입력하세요</h5>
                    </div>                        
                    <div class="modal-body">
                        <textarea class="form-control mt-2" id="ranks_name_modal" name="re_content" rows="5" placeholder="직급명을 입력하세요"></textarea>
                    </div>
                    <div class="modal-footer">
                        <input class="btn btn-secondary" type="submit" value="수정완료" id="addrankCheck"> 
                        <input class="btn btn-secondary" type="button" value="뒤로가기" id="addrankCheckCancel">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <main id="main" class="main">
        <section class="section dashboard">
            <div class="row">
            </div>
            <h2>직급 관리</h2>  <br>
            <table class="table table-striped" style="margin-top: 10px;">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>직급코드</th>
                        <th>직급명</th>
                        <th>등록일</th>
                        <th class="action-buttons"></th>
                    </tr>
                </thead>
                <tbody id="ranksTableBody">
                    <c:forEach var="lists" items="${lists}" varStatus="vr">
                        <tr>
                            <td>${vr.count}</td>
                            <td class="ranks_seq">${lists.ranks_seq}</td> 
                            <td class="ranks_name">${lists.ranks_name}</td> 
                            <td>${lists.ranks_regdate}</td>
                           <td class="action-buttons">
						    <button class="open-modal-btn btn btn-secondary  rounded-pill" data-dept-seq="${lists.ranks_seq}" data-dept-name="${lists.ranks_name}">수정</button>
						    <button class="btn btn-danger rounded-pill delete-btn" data-dept-seq="${lists.ranks_seq}" data-dept-name="${lists.ranks_name}">삭제</button>
						</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <!-- 직급 추가 버튼을 오른쪽에 배치 -->
            <div class="add-rank-btn-container">
                <a href="./insertRanks.do"><button class="btn btn-secondary ">직급 추가</button></a>
            </div>
        </section>
    </main>
</body>
</html>
