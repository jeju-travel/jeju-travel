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
    	.dateselect{
    		margin-right:30%;
    	}
    	hr{
    		background-color:black;
    	}
    	.lodgingimage{
    		width:100px;
      		height: auto;
      		background-size:cover;
      		background: no-repeat;
    	}
  	</style>
</head>
<body>
<div class="lodginglist">
        <h5>경로 표시</h5>
        <!-- 이부분은 어떻게 가져올 것인지 생각 후 value에 가져오는 코드 입력 -->
        <table class="dateselect">
        	<tr>
        		<th><input type="date">~</th>
        		<th><input type="date" style="margin-right:20px;"> </th>
        		<th><h3 style="margin-right:10px;">성인 : </h3></th>
        		<th>
        			<select>
        				<option value="one">1명</option>
        				<option value="two">2명</option>
        				<option value="three">3명</option>
        				<option value="four">4명</option>
        			</select>
        		</th>
        		<th><h3 style="margin-left:10px;">어린이 : </h3></th>
        		<th>
        			<select style="margin-left:10px;">
        				<option value="one">1명</option>
        				<option value="two">2명</option>
        				<option value="three">3명</option>
        				<option value="four">4명</option>
        			</select>
        		</th>
        		
        		<th><input class="btn btn-primary" type="submit" style="margin-left:10px;" value="검색"></th>
        	</tr>
        </table>
        
        <h1 style="margin-left:30px;">숙소 리스트</h1>
        
        <hr>
        <c:if test="${!empty lodgingList}">
        <table>
        	<c:forEach var="list" items="${lodgingList}">
               <tr>
                  <td>${list.lodging_name}</td>
                  <td>${list.lodging_loc}</td>
                  <td>${list.lodging_phone}</td>
                  <td>${list.lodging_price}</td>
                  <td><div class="lodgingimage"><img src="${list.lodging_image}" style="max-width: 100%; height: auto;"></div></td>
                  <td><a class="btn btn-primary" href=""></a>
               </tr>
            </c:forEach>
        </table>
        </c:if>
        <c:if test="${empty lodgingList }">등록된 숙소가 없습니다.</c:if>
</div>
</body>
</html>