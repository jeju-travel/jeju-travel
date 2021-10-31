<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>숙소 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/d42fd504d6.js"
	crossorigin="anonymous"></script>
<style>
* {
	margin: auto;
	padding: 0;
}

body {
	padding-top: 60px;
	margin: auto;
}

.dateselect {
	margin-right: 30%;
}

hr {
	background-color: black;
}

.lodgingimage {
	width: 100px;
	height: auto;
	background-size: cover;
	background: no-repeat;
}

.box {
	display: flex;
	align-items: center;
}

.backImg {
	width: 300px;
	height: auto;
	background-size: cover;
	background: no-repeat;
}
</style>
</head>
<body>
	<div class="lodginglist">

		<!-- 이부분은 어떻게 가져올 것인지 생각 후 value에 가져오는 코드 입력 -->
		<table class="dateselect">
			<form method="post" action="lodging_search">
				<table class="dateselect">
					<tr>
						<th><input type="date" name="start_day" value="${startDay}"
							readonly>~</th>
						<th><input type="date" name="end_day" value="${endDay}"
							readonly></th>
					</tr>
					<tr>
						<td>숙소 검색 :</td>
						<td><input type="text" name="lodging_name"></td>
						<td><input class="btn btn-primary" type="submit"
							style="margin-left: 10px;" value="검색"></td>
					</tr>
				</table>
			</form>
		</table>

		<h1 style="margin-left: 30px;">숙소 리스트</h1>

		<hr>
		<c:if test="${!empty lodgingList}">

			<table class="table">
				<c:forEach var="list" items="${lodgingList}">
					<tr>
						<td>
							<div class="box">
								<div class="backImg">
									<img src="${list.lodging_image}"
										style="max-width: 100%; height: auto;">
								</div>
							</div>
						</td>
						<td><div>
								<p>
									<font size="5"><b>${list.lodging_name}</b></font>
								</p style="color:#bbb">
								<p>
									<i class="fas fa-map-marker-alt"></i> ${list.lodging_loc}
								</p></td>

						<td><p>
								<i class="fas fa-phone-alt"></i> ${list.lodging_phone}
							</p>
							<p>
								<i class="fas fa-won-sign"></i> ${list.lodging_price}
							</p></td>

						<td>

							<p>별점 보여주기</p> <input type="button" value="예약하기"
							onClick="location.href='detail_room?roomNo=${list.lodging_no}'">

						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty lodgingList }">등록된 숙소가 없습니다.</c:if>
	</div>
</body>
</html>