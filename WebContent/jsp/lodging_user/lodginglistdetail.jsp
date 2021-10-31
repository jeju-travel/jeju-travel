<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숙소 상세보기</title>

<style>
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
<form action="main_car">
	<h1>${room.lodging_name}</h1>
	<hr>

	<div>
		<div>${room.lodging_loc}</div>
		<div>
			<div class="backImg">
				<img src="${room.lodging_image}"
					style="max-width: 100%; height: auto;">
			</div>
		</div>
		<div>전화, 별점</div>
		<div>
			 체크인:<select name="checkIn">
				<option value="오전">오전</option>
				<option value="오후">오후</option>
			</select>
			체크아웃:<select name="checkOut"> 
				<option value="오전">오전</option>
				<option value="오후">오후</option>
			</select> 1박당 가격
		</div>
	</div>

	<h1>${room.lodging_no}</h1>
	<input type="text" name="roomNo" value="${room.lodging_no}" hidden/>
	<input type="submit" value="장바구니 담기" onClick="location.href='main_car" />
	<input type="button" value="이전 화면"
		onClick="location.href='lodging_list_user'" />
		</form>
	<div>
		<h2>리뷰</h2>
		<hr>
		<!-- 리뷰 리스트로 뽑아우기 -->
	</div>
</body>
</html>