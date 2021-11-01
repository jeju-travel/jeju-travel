<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>렌트카 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>   
	
    body{        
        display: flex;
  		justify-content: center;
  		align-items: center;
  		text-align:center;
  		min-height: 100vh;    
    }     
	ul{
		display:flex;
		align-items: center;
		justify-content: center;
	}
	.lo{
		text-align: right;	
	}

</style>
<body>
	<main>	
	<div class="container mt-3">
		<h3>CarList</h3>
		<div class="lo"></div><a href="login">관리자모드</a></div>
		<c:if test="${!empty carList}">			
			<table class="table table-hover">				
				<tr>
					<th>차량번호</th>
					<th>차량이름</th>
					<th>차종</th>
					<th>가격</th>
					<th>최대탑승인원</th>
					<th>연료</th>
					<th>위치</th>
					<th>상세보기</th>
				</tr>
				<c:forEach var="car" items="${carList}">
					<tr>
						<td>${car.car_no}</td>
						<td>${car.car_name}</td>
						<td>${car.car_type}</td>
						<td>${car.car_price}</td>
						<td>${car.capacity}</td>
						<td>${car.car_fuel}</td>
						<td>${car.car_loc}</td>
						<td><a href="car_detail?car_no=${car.car_no}">상세보기</a>
					</tr>
				</c:forEach>
			</table>			
		</c:if>
		<c:if test="${empty carList }">CarList를 검색하지 못했습니다.</c:if>
		<!-- 링크표시하기 [이전] [다음] -->
	<c:if test="${!empty carList}">		
	<div class="paging">
	<ul class="pagination">
		<!-- 계속 true로 나오다가 페이지매니저에 false가 걸려서 조건이 달라지면   -->
		<c:if test="${pageGroupResult.beforePage}">
			<li class="page-item"><a class="page-link" href="car_search?reqPage=${pageGroupResult.groupStartNumber-1}">[이전]</a></li>
		</c:if>
		
		<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
			<!-- index를 for돌다가 index값과 내가 선택한 페이지가 같으면 active라는 class를 실행해서 파랗게 나오게함  -->
			<c:choose>
				<c:when test="${pageGroupResult.selectPageNumber==index}">
					<li class="page-item active">
						<a class="page-link" href="car_search?reqPage=${index}">${index}</a>
					</li>
				</c:when>
				
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="car_search?reqPage=${index}">${index}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${pageGroupResult.afterPage}">
			<li class="page-item"><a class="page-link" href="car_search?reqPage=${pageGroupResult.groupEndNumber+1}">[다음]</a></li>
		</c:if>
	</ul>
	</div>
	</c:if>
	</div>
	</main>
</body>
</html>