<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>서명 상세정보</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <%@ include file="./header.jsp"%>
    <style>
        /* 추가적인 스타일링을 위한 CSS 코드 */
        body {
            padding-top: 50px;
            font-family: Arial, sans-serif;
        }
        #container {
            text-align: center;
        }
        img {
            max-width: 100%;
            height: auto;
            margin: 0 auto;
            display: block;
        }
    </style>
</head>
<body>
    <main id="main" class="main">
        <div class="container">
            <h2 class="text-center mt-4">서명 이미지</h2>
            <hr>
            <div id="container">
                <img class="img-fluid" alt="서명" src="${sVo.signs_image}">
            </div>
        </div>
    </main>
</body>
</html>
