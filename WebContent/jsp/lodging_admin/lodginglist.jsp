<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>숙소 리스트</title>
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
    	tr{
			text-align:center;
    	}
    	.updatedelete{
    		text-decoration:none;
    	}
    	.titlename{
    		font-size:20px;
    	}
    	td{
    		font-size:12px;
    		font-weight:bold;
    	}
    	.lodgingimage{
    		width:100px;
      		height: auto;
      		background-size:cover;
      		background: no-repeat;
    	}
    	td{
    		line-height:70px;
    	}
    	
  	</style>
</head>
<body>
<div class="container mt-3">
        <div class="title">
        	<h1>숙소 리스트<관리자모드></h1>
        	<a class="btn btn-primary" href="lodging_input">숙소 추가</a>
        </div>
        <hr>
        <c:if test="${!empty lodgingList}">
        <table class="table table-dark table-hover">
        	<tr>
        		<th class="titlename">숙소 이름</th>
        		<th class="titlename">숙소 위치</th>
        		<th class="titlename">숙소 전화번호</th>
        		<th class="titlename">숙소 가격</th>
        		<th class="titlename">숙소 이미지</th>
        		<th class="titlename">숙소 수정 및 삭제</th>
        	</tr>
        	<c:forEach var="list" items="${lodgingList}">
               <tr>
                  <td>${list.lodging_name}</td>
                  <td>${list.lodging_loc}</td>
                  <td>${list.lodging_phone}</td>
                  <td>${list.lodging_price}</td>
                  <td><div class="lodgingimage"><img src="${list.lodging_image}" style="max-width: 100%; height: auto;"></div></td>
                  <td><a class="updatedelete" href="lodging_detail?lodging_no=${list.lodging_no}">상세보기</a>
               </tr>
            </c:forEach>
        </table>
        </c:if>
        <c:if test="${empty lodgingList }">등록된 숙소가 없습니다.</c:if>
</div>
</body>
</html>