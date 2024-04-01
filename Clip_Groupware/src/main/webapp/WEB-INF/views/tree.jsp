<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tree Management</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>
<script type="text/javascript" src="./js/dept.js"></script>

  
<script>
    $(document).ready(function () {
        $('#tree').jstree({
            'core': {
                'data': {
                    'url': '/loadTreeData.do', // 서버에서 트리 데이터를 로드하는 엔드포인트
                    'dataType': 'json'
                }
            },
            'plugins': ['types', 'dnd']
        });
    });
</script>
</head>
<body>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tree Management</title>
</head>
<body>
    <div id="jstree"></div>

    <button onclick="addNode()">Add Node</button>
    <button onclick="editNode()">Edit Node</button>
    <button onclick="deleteNode()">Delete Node</button>
 
</body>
</html>
