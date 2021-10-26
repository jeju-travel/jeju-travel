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
<body>
	<div class="container mt-3">
		<h3>CarList</h3>
		<c:if test="${!empty carList}">
			<!-- memoList媛� 鍮꾩뼱�엳吏��븡�쑝硫� 諛묒뿉 肄붾뱶 �떎�뻾  -->

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
						<td>${car_car_type}</td>
						<td>${car.car_price}</td>
						<td>${car.capacity}</td>
						<td>${car.car_fuel}</td>
						<td>${car.car_loc}</td>
						<td>${car.car_img}</td>
						<td><a href="car_detail?car_no=${car.car_no}">상세보기</a>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty carList }">CarList를 검색하지 못했습니다.</c:if>
	</div>
</body>
</html>