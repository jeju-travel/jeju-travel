<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>관리자모드</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
    *{ 
        margin: auto;
        padding: 0;
    }
    body{
        padding-top: 60px;
        margin: auto;
    }
    input{
        margin-top: 10px;
        margin-left: 10px;
        width: 600px;
        height: 30px;
    }
    h1{
        text-align: center;
    }
    .mainadminlink{
    	background-color:black;
    }
    
</style>
</head>
<body>
	<form method="post" action="adminmain">
		<h1>관리자 모드 <메인></h1>
        
        <!-- a링크 이용하여 이전,삭제 변경 -->
    <!-- <center> -->
    <div class="mainadminlink">
        <!--  <button type="submit" class="btn btn-primary">이전</button> -->
        
        <a href="lodging_input">숙소 추가</a>
        <a href="lodging_detail">숙소 수정 및 삭제</a>
    </div>
    <!-- </center> -->
	</form>
</body>
</html>