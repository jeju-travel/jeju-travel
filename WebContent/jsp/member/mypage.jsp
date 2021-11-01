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
<title>마이 페이지</title>
<script type="text/javascript">
	
	$(document).ready(function(){
		

		
		$('tbody tr').each(function(){
			
			var td = $(this).children();
			

			
			$(this).on('click', function(){
		
				$(location).attr('href','res_detail?resNo=' + td.eq(4).text());
			
			});
		});
		
		$('#btn').on('click', function(){
			
			$(location).attr('href','index.jsp');
		
		});
	});

</script>
<style>
body{
	padding:100px;
}
.btn {
	width: 120px;
	height: 40px;
	border: 1px solid transparent;
	padding: .375rem .75rem;
	font-size: 1rem;
	border-radius: .25rem;
	transition: color .15s;
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
</style>
</head>
<body>


	<h1>My Page</h1>
	<hr>
	<form action="detail">
		<input type="submit" value="회원정보수정" class="btn btn_p">
			<input type="button" id="btn" value="메인 화면" class="btn btn_p">
	</form>
	<hr>
	<h3>예약현황</h3>

	<c:if test="${!empty reslist}">
		<table class="table table-hover">
		<thead>
			<tr>
				<th>예약날짜</th>
				<th>예약항목</th>
				<th>예약상태</th>
				<th>리뷰</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="res" items="${reslist}">
			<tr>
				<td>${res.startDay} ~ ${res.endDay}</td>
				<td>${res.items}</td>
				<td>${res.state}</td>
				<td onclick="event.cancelBubble=true;">
					<c:if test="${res.state == '예약확인'}">
						<a href="review?air=${res.airResNo}&lodging=${res.roomResNo}&car=${res.carResNo}">리뷰쓰기 </a>
					</c:if>
				</td>
				<td hidden>${res.resNo}</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</c:if>
	<c:if test="${empty reslist}">
			예약결과가 없습니다.
	</c:if>



	<table>

	</table>
</body>
</html>
