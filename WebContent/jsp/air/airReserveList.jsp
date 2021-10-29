<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
  
<title>제주 여행</title>
</head>
<body>
<h3>항공 예약</h3>
<div class="container mt-3">
<table class="table">
	<thead>
	<tr>
		<th>별점</th>
		<th>항공사</th>
		<th>가는날</th>
		<th>오는날</th>
		<th>탑승시간대</th>
		<th>요금</th>
		<th>탑승인원</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="airline" items="${airlineList}">
	<form method="post" action="basketAirline">
	<tr>
		<td>${airline.horoscope}/5.0</td>
		<td>${airline.airName}
			<input type="text" name="airNo" value="${airline.airNo}" hidden="hidden">
		</td>
		<td>${startDay}</td>
		<td>${endDay}</td>
		<td>${airline.takeOff}</td>
		<td>${airline.price}원</td>
		<td><input type="text" name="personnel">명</td>
		<td><input class="btn btn-primary btn-sm" type="submit" value="예약하기"></td>
	</tr>
	</form>
	</c:forEach>
	</tbody>	
</table>
<input class="btn btn-primary" type="button" onclick="location='main_lodging'" value="항공예약 건너뛰기" style="text-align: right;"/>
</div>
</body>
</html>