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
<h3>항공</h3>
<hr>
<div class="container mt-3">
<table class="table">
	<tr>
		<th>항공사</th>
		<th>출발 장소</th>
		<th>출발날짜</th>
		<th>탑승시간대</th>
		<th>인원</th>
		<th>요금</th>
		<th></th>
	</tr>
	<c:if test="${!empty reserveAirline}">
	<tr>
		<td>${reserveAirline.airName}
		</td>
		<td>${startDay}</td>
		<td>${endDay}</td>
		<td>${reserveAirline.takeOff}</td>
		<td>${airPersonnel}</td>
		<td>${reserveAirline.price * airPersonnel}원</td>
		<td><button class="btn btn-primary btn-sm" onclick="location.href='reserveAll?airNo=${reserveAirline.airNo}'">예약하기</button></td>
	</c:if>
	
</table>
<input class="btn btn-primary" type="button" onclick="location='reserveAirline'" value="뒤로가기" style="text-align: right;"/>
</div>

</body>
</html>