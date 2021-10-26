<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최종 예약 확인</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h3>최종 예약 확인</h3>
<hr>
<form action="">
<p>항공</p>
<hr>
<table>
	<thead>
		<th>항공편</th>
		<th>출발 장소</th>
		<th>출발 시간</th>
		<th>도착 장소</th>
		<th>도착 시간</th>
		<th>소요 시간</th>
		<th>금액</th>
	</thead>
	<tbody>
		<td>${air.name}</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tbody>
</table>
<hr>
<p>숙박</p>
<hr>
<table>
	<thead>
		<th>모텔명</th>
		<th>체크인</th>
		<th>체크아웃</th>
		<th>금액</th>
	</thead>
	<tbody>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tbody>
</table>
<hr>
<p>렌트카</p>
<hr>
<table>
	<thead>
		<th>차종</th>
		<th>대여일</th>
		<th>반납일</th>
		<th>금액</th>
	</thead>
	<tbody>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tbody>
</table>

<div>
	<p>합계 : price 다 더하기
</div>
<input type="submit" value="결제하기">
<input type="button" value="취소하기">
</form>
</body>
</html>