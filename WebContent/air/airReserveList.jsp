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
<h3>항공 예약</h3>
<table>
	<tr>
		<th>항공사</th>
		<th>가는날</th>
		<th>오는날</th>
		<th>탑승시간대</th>
		<th>요금</th>
		<th>탑승인원</th>
		<th></th>
	</tr>
	<c:forEach var="airline" items="${airlineList}">
	<tr>
		<td>${airline.airName}</td>
		<td>${sDay}</td>
		<td>${eDay}</td>
		<td>${airline.takeOff}</td>
		<td>${airline.price}원</td>
		<td><input type="text" name="personnel">명</td>
		<td><button onclick="location.href='reserveAirline?airNo=${airline.airNo}'">예약하기</button></td>
	</c:forEach>
	
</table>

</body>
</html>