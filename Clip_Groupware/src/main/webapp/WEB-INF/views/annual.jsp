<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>연차관리</title>
    <%@ include file="./header.jsp"%>
</head>
<body>
<main id="main" class="main">
    <div class="card">
        <div class="card-body">
            <section class="section dashboard">
                <div class="row justify-content-end">
                    <div class="col-md-4">
                        <form action="./searchAnnual.do" class="form-inline" method="GET">
                            <div class="input-group">
                                <input type="text" class="form-control" id="user_name" name="user_name" placeholder="사용자 이름을 입력하세요">
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-primary">검색</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <table class="table table-hover" style="margin-top: 10px;">
                    <thead>
                        <tr>
                            <th>이름</th>
                            <th>아이디</th>
                            <th>남은 연차</th>
                        </tr>
                    </thead>
                    <tbody id="annualTableBody">
                        <!-- 전체 조회 결과 출력 -->
                        <c:forEach var="anlist" items="${anlist}" varStatus="vs">
                            <tr style="cursor: pointer;" onclick="location.href='./detailAnn.do?user_id=${anlist.user_id}'">
                                <td>${anlist.user_name}</td>
                                <td>${anlist.user_id}</td>
                                <td>${anlist.ann_leov - anlist.ann_useday}</td>
                            </tr>
                        </c:forEach>
                        <!-- 검색 결과 출력 -->
                        <c:forEach var="searchResult" items="${searchResult}" varStatus="vs">
                            <tr style="cursor: pointer;" onclick="location.href='./detailAnn.do?user_id=${searchResult.user_id}'">
                                <td>${searchResult.user_name}</td>
                                <td>${searchResult.user_id}</td>
                                <td>${searchResult.ann_leov - searchResult.ann_useday}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
        </div>
        <div class="datatable-bottom paging" style=" margin: 0 auto;">
			    <nav class="datatable-pagination"><ul class="datatable-pagination-list"><li class="datatable-pagination-list-item datatable-hidden datatable-disabled"><button data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">‹</button></li><li class="datatable-pagination-list-item datatable-active"><button data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">1</button></li><li class="datatable-pagination-list-item"><button data-page="2" class="datatable-pagination-list-item-link" aria-label="Page 2">2</button></li><li class="datatable-pagination-list-item"><button data-page="3" class="datatable-pagination-list-item-link" aria-label="Page 3">3</button></li><li class="datatable-pagination-list-item"><button data-page="4" class="datatable-pagination-list-item-link" aria-label="Page 4">4</button></li><li class="datatable-pagination-list-item"><button data-page="5" class="datatable-pagination-list-item-link" aria-label="Page 5">5</button></li><li class="datatable-pagination-list-item"><button data-page="6" class="datatable-pagination-list-item-link" aria-label="Page 6">6</button></li><li class="datatable-pagination-list-item"><button data-page="7" class="datatable-pagination-list-item-link" aria-label="Page 7">7</button></li><li class="datatable-pagination-list-item datatable-ellipsis datatable-disabled"><button class="datatable-pagination-list-item-link">…</button></li><li class="datatable-pagination-list-item"><button data-page="10" class="datatable-pagination-list-item-link" aria-label="Page 10">10</button></li><li class="datatable-pagination-list-item"><button data-page="2" class="datatable-pagination-list-item-link" aria-label="Page 2">›</button></li></ul></nav>
			</div>
    </div>
</main>
</body>
</html>
