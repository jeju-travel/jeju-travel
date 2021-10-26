<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>예약 상세 보기</title>

<script type="text/javascript">


</script>

<style>
	body{
	display:flex;
	flex-direction:column;
	padding:50px;
}

.btn {
	width: 120px;
	height: 40px;
	border: 1px solid transparent;
	padding: .375rem .75rem;
	font-size: 1rem;
	border-radius: .25rem;
	transition: color .15s;
	margin : 10px;
	padding : 10px;
}

.btn_p {
	color: #fff;
	background-color: #0d6efd;
	border-color: #0d6efd;
}

.btn_cancle {
	color: #fff;
	background-color: #ccc;
	border-color: #ccc;
}

form{
	display:inline;
	width:150px;
}
</style>
</head>
<body>
	<h3>예약 현황 (${res.startDay} ~ ${res.endDay})</h3>
	<hr>
	
	
	<p>항공</p>
	<hr>
	<c:if test="empty">
		<h4>예약 결과가 없습니다.</h4>
	</c:if>
	<!-- 결과 존재시 -->
	<table  class="table table-hover">
		<thead>
			<th>항공편</th>
			<th>출발 장소</th>
			<th>도착 장소</th>
			<th>출발 시간</th>
			<th>도착 시간</th>
			<th>소요 시간</th>
			<th>금액</th>
			
		</thead>
		<tbody>
			
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			
		</tbody>
	</table>
	
	<p>숙박</p>
	<hr>
	<c:if test="empty">
		<h4>예약 결과가 없습니다.</h4>
	</c:if>
	<!-- 결과 존재시 -->
	<table  class="table table-hover">
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


	<p>렌트카</p>
	<hr>
	<c:if test="empty">
		<h4>예약 결과가 없습니다.</h4>
	</c:if>
	<!-- 결과 존재시 -->
	<table  class="table table-hover">
		<thead>
			<th>차종</th>
			<th>출발 시간</th>
			<th>반납 시간</th>
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
	
	<input type="button" value="마이페이지" class="btn btn_p">
	<input type="button" value="예약취소" class="btn btn_cancle">
	</div>
</body>
</html>