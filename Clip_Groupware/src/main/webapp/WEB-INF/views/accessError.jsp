<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Access Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            max-width: 700px; /* 수정된 부분: 원하는 최대 너비로 조정 */
            width: 80%; /* 추가: 화면 너비에 따라 가변적으로 조정 */
            margin: auto; /* 추가: 가운데 정렬 */
        }
        h1 {
            color: #d9534f;
        }
        p {
            color: #333;
            margin-top: 10px;
        }
        .btn {
            padding: 10px 20px;
            background-color: #d9534f;
            color: #fff;
            border: none;
            border-radius: 3px;
            text-decoration: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #c9302c;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>오류</h1>
        <p>허용되지 않은 IP 주소입니다.</p>
        <p>관리자에게 문의하세요</p>
        <a href="./main.do" class="btn">메인으로 돌아가기</a>
    </div>
</body>
</html>
