<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	
var today = new Date();

var year = today.getFullYear();
var month = ('0' + (today.getMonth() + 1)).slice(-2);
var day = ('0' + today.getDate()).slice(-2);

var dateString = year + '-' + month  + '-' + day;

console.log(dateString)
	
</script>
<title>메인 페이지</title>
<body>

	<a href="join">회원가입</a>
	<a href="">로그인</a>
	<a href="">마이페이지</a>



	<h1>제주 여행</h1>

	<form action="#">
		<div>

			<label>출발 날짜</label> <input type="date" name="date1"  min="${dateString}">

		</div>
		<div>
			<label>도착 날짜</label> <input type="date" name="date2"  min="${dateString}">
		</div>
		<input type="submit" value="검색">
	</form>
</body>
</html>