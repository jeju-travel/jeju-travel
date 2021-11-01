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

<script type="text/javascript">
$(document).ready(function(){
	
	
	$('.btn_cancle').on('click',function(){
		alert('예약이 취소 되었습니다.');
		$(location).attr('href','cancle');
	});
	
	$('.btn_p').on('click',function(){
		$(location).attr('href','mypage');
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
</style>

</head>

<body>
<h3>장바구니 (${reserve.startDay} ~ ${reserve.endDay})</h3>
<hr>
<form action="reserve">


	<c:if test="${empty airRes}">
		<div>
		항공
		<hr>
		<p>예약 결과가 없습니다.</p>
		</div>
	</c:if>
	<!-- 결과 존재시 -->
	<c:if test="${!empty airRes}">
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

				<td>${air.price*airRes.personnel}</td>

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
	
	
	 private int lodging_reserve_no;
	private String check_in;
	private String check_out;
	private int lodging_no;
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
			<th>총대여일</th>
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
				<td>${carRes.rental_day}</td>
				<td>${car.car_price*carRes.rental_day}</td>


		</tbody>
	</table>
	</c:if>

<div>
	<p>최종 합계 : ${(air.price*airRes.personnel)  + room.lodging_price + (car.car_price*carRes.rental_day)}
</div>
<input type="submit" value="결제하기" class="btn btn_p">
<input type="button" value="취소하기" class="btn btn_cancle">
</form>
</body>