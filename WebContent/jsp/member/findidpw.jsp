<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
body{
	display: flex;
	justify-content: center;
	
}

.btn {
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

input, select{
	border-radius: .25rem;
	border-color: #eee;
	width: 300px;
	height: 30px;
	margin: 10px;
}

.updown { border: 0.1px solid black; 
			color : black;
			width: 0.1px; 
			height: 300px; 
			margin :0px 30px;}
</style>

</head>
<body>
	<div>
	<form action="findid">
		<h2>아이디 찾기</h2>
	<hr>
	<input type="text" name="name" placeholder="이름"><br>
	<input type="text" name="phone" placeholder="연락처"><br>
	<input type="submit" value="아이디 찾기" class="btn btn_p"/>
		</form>
	</div>



	<div class="updown"></div>





	<div>
	<form action="findpw">
	<h2>비밀번호 찾기</h2>
	<hr>
	<input type="text" name="id" placeholder="아이디">
	<br>
	<input type="text" name="name" placeholder="이름">
	<br>
	<select name="hint">
		<option value="food">본인이 가장 좋아하는 음식은?</option>
		<option value="love">첫사랑 이름은?</option>
		<option value="color">본인이 가장 좋아하는 색깔은?</option>
		<option value="animal">본인이 가장 좋아하는 동물은?</option>
		<option value="school">본인이 졸업한 초등학교는?</option>
		<option value="city">본인이 태어난 도시는?</option>
	</select>
	<br>
	<input type="text" name="answer" placeholder="답변"><br>
	<input type="submit" value="비밀번호 찾기" class="btn btn_p" /><br>
	
	</form>
	</div>	
	
</body>
</html>