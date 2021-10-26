<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제주 여행</title>
</head>
<body>
<h3>항공</h3>
<hr>

<table>
	<tr>
		<th>항공사</th>
		<th>출발 장소</th>
		<th>출발날짜</th>
		<th>탑승시간대</th>
		<th>요금</th>
		<th></th>
	</tr>
	<c:if test="${!empty reserveAirline}">
	<tr>
		<td>${airline.airName}</td>
		<td>${sDay}</td>
		<td>${eDay}</td>
		<td>${airline.takeOff}</td>
		<td>${airline.price}원</td>
		<td><button onclick="location.href='reserveAirline?airNo=${airline.airNo}'">예약하기</button></td>
	</c:if>
	
</table>

</body>
</html>