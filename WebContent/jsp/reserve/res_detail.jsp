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

$(document).ready(function(){
	
	

	$('#btn_cancle').on('click',function(){
		$(location).attr('href', 'reserve_delete?resNo=' + ${resNo});
		//$(location).attr('href', 'reserve_delete?resNo=' + resNo);

	});
	
	

	$('.btn_p').on('click',function(){
		$(location).attr('href', 'mypage');
	});
	
})

</script>

<style>


	body{
	display:flex;
	flex-direction:column;
	padding:50px;
}
.b{
	margin-top:30px;
	margin-bottom:30px;
}

table{
	margin-top:20px;
	margin-bottom:20px;
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
	
	
	
	
	<c:if test="${empty airRes}">
		<div>
		항공
		<hr>
		<p>예약 결과가 없습니다.</p>
		</div>
	</c:if>
	<!-- 결과 존재시 -->
	<c:if test="${!empty  airRes}">
	<table  class="table table-hover">
		
		<thead>
			<th>항공편</th>
			<th>출발 장소</th>
			<th>도착 장소</th>
			<th>출발 시간</th>
			<th>도착 시간</th>
		
			<th>금액</th>
			
		</thead>
		<tbody>
		
		<!--	private int airReserveNo;
	private String takeOff;
	private String landing;
	private int personnel;
	private int reserveNo;
	private int airNo;
	 -->
			
				<td>${air.airName}</td>
				<td>${air.airLoc}</td>
				<td>제주</td>
				<td>${airRes.takeOff}</td>
				<td>${airRes.landing}</td>
			
				<td>${air.price}</td>
			
		</tbody>
	</table>
	</c:if>
	
	<c:if test="${empty roomRes}">
		<div class="b">
		숙박
		<hr>
		<p>예약 결과가 없습니다.</p>
		</div>
	</c:if>
	<!-- 결과 존재시 -->
	<c:if test="${!empty roomRes}">
	<table  class="table table-hover">
	
		<thead>
			<th>모텔명</th>
			<th>체크인</th>
			<th>체크아웃</th>
			<th>금액</th>
			
		</thead>
		<!-- 	private int lodging_no;
	private String lodging_name;
	private String lodging_loc;
	private String lodging_phone;
	private String lodging_image;
	 -->
	 
	
		<tbody>
			
				<td>${room.lodging_name}</td>
				<td>${roomRes.check_in}</td>
				<td>${roomRes.check_out}</td>
				<td>${room.lodging_price}</td>
			
		</tbody>
	</table>
	</c:if>


	<c:if test="${empty carRes}">
	<div>
		렌트카
		<hr>
		<p>예약 결과가 없습니다.</p>
	</div>
	</c:if>
	<!-- 결과 존재시 -->
	
	<c:if test="${!empty carRes}">
	<table  class="table table-hover">
	
		<thead>
			<th>차종</th>
			<th>출발 시간</th>
			<th>반납 시간</th>
			<th>금액</th>
			
		</thead>
		
		 <!-- 
	 	private int car_reserve_no;
	private String borrow_car;
	private String return_car;
	private int reserve_no;
	private int car_no;
	 -->
		<tbody>
		
			
				<td>${car.car_name}</td>
				<td>${carRes.borrow_car}</td>
				<td>${carRes.return_car}</td>
				<td>${car.car_price}</td>
		
		
		</tbody>
	</table>
	</c:if>
	<div>
	<input type="button"  value="마이페이지" class="btn btn_p">


	<input type="button" id="btn_cancle" value="예약취소" class="btn btn_cancle">

	</div>
</body>
</html>