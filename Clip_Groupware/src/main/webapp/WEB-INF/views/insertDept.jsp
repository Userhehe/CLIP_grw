<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>부서 등록</title>
<%@ include file="./header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/insertdept.js"></script>
<style>
    .dashboard {
        display: flex;
        justify-content: center;
        align-items: flex-start; /* 아래 정렬 */
        height: 100vh;
    }

    .form-container {
        width: 400px; /* 폼의 너비 조절 */
        padding: 20px;
        border-radius: 10px;
        background-color: #f9f9f9;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        margin-top: 200px; /* 수정된 부분 */
    }

    .form-container form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 5px;
        outline: none;
    }

    button {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        box-sizing: border-box;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        outline: none;
    }

    button.check-duplicate {
        background-color: #007bff;
        color: white;
    }

    button[type="submit"] {
        background-color: #28a745;
        color: white;
        width: auto;
    }

    #duplicateMessage {
        color: red;
        margin-top: 10px;
    }

    h2 {
        text-align: center;
    }
    
</style>
</head>
<body>
    <main id="main" class="main">
        <section class="section dashboard">
            <div class="form-container">
                <h2>부서 등록</h2>
                <form action="./insertDept.do" method="post" id="deptForm">
                    <label for="dept_name">부서명을 입력하세요 </label>
                    <input type="text" id="dept_name" name="dept_name">
                    <button type="button" class="btn btn-primary rounded-pill check-duplicate" onclick="checkDuplicate()">중복검사</button>
                    <br> 
                    <input type="submit" value="등록" id="submitBtn"  disabled>
                </form>
                <div id="duplicateMessage"></div>
            </div>
        </section>
    </main> 
</body>
</html>
