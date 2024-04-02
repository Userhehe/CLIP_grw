<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>직급관리</title>
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
        
        /* 수정 및 삭제 버튼의 스타일 */
        .action-buttons button {
            margin-left: 10px;
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
            <table class="table table-striped" style="margin-top: 10px;">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>직급코드</th>
                        <th>직급명</th>
                        <th>등록일</th>
                        <th class="action-buttons"></th> <!-- 수정 및 삭제 버튼을 담을 공간 -->
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
						    <button class="open-modal-btn" data-dept-seq="${lists.ranks_seq}" data-dept-name="${lists.ranks_name}">수정</button>
						    <button class="btn btn-danger rounded-pill delete-btn" data-dept-seq="${lists.ranks_seq}" data-dept-name="${lists.ranks_name}">삭제</button>
						</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="./insertRanks.do"><button class="btn btn-primary rounded-pill">직급 추가</button></a>
        </section>
    </main>
</body>
</html>
