<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>관리자모드<메인></title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>관리자 모드<메인></title>
    <style>
        *{ 
            margin: auto;
            padding: 0;
        }
        body{
            padding-top: 60px;
            margin: auto;
            /* text-align: center; */
            /* justify-content: space-between; */
        }
        h1{
            text-align: center;
        }
        a{
            display: block;
            position: relative;
            margin-top: 10px;
        }
        .mainadminair{
            width: 150px;
            display: block;
            margin-top: 32px;
            margin-left: 19%;
            float: left;
        }
        .mainadminair a{
            width: 250px;
            height: 60px;
            line-height: 60px;
            text-align: center;
            margin-top: 60px;
            background-color: rgb(36, 34, 182);
            color:white;
            text-decoration: none;
        }
        .mainadminlodging{
            width: 150px;
            display: block;
            margin-top: 100px;
            margin-left: 41%;
        }
        .mainadminlodging a{
            width: 250px;
            height: 60px;
            line-height: 60px;
            text-align: center;
            margin-top: 60px;
            background-color: rgb(36, 34, 182);
            color:white;
            text-decoration: none;
        }
        .mainadmincar{
            width: 150px;
            display: block;
            margin-top: -240px;
            margin-right: 27%;
            float: right;
        }
        .mainadmincar a{
            width: 250px;
            height: 60px;
            line-height: 60px;
            text-align: center;
            margin-top: 60px;
            background-color: rgb(36, 34, 182);
            color:white;
            text-decoration: none;
        }        
    </style>
</head>
<body>    
		<h1>관리자 모드 <메인></h1>
        
        <!-- a링크 이용하여 이전,삭제 변경 -->
    <!-- <center> -->
    <div class="mainadminair">
        <a href="air_input">항공 추가</a>
        <a href="air_list">항공 리스트</a>
    </div>

    <div class="mainadminlodging">
        <!--  <button type="submit" class="btn btn-primary">이전</button> -->
        <a href="lodging_input">숙소 추가</a>
        <a href="lodging_list">숙소 리스트</a>
    </div>

    <div class="mainadmincar">
        <a href="car_input">렌트카 추가</a>
        <a href="car_search?reqPage=1">렌트카 리스트</a>
    </div>
    <!-- </center> -->
	
</body>
</html>