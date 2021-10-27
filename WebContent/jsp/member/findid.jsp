<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>

<style>
body{
	display:flex;
	flex-direction:column;
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

		<h1>아이디 찾기 결과</h1>
		<hr>
	<c:if test="${id == null}">
		
		<h3>아이디 찾기 실패</h3>
		<label>정보와 일치하는 아이디가 없습니다.</label>
		<div>
		<form action="join">
			<input type="submit" value="회원가입" class="btn btn_p">
		</form>
		<form action="findidpw">
		<input type="submit" value="다시 찾기" class="btn btn_p">
		</form>
		</div>
	</c:if>
	<c:if test="${id != null}">
		<h3>아이디 찾기 성공</h3>
	
		<h5>고객님의 정보와 일치하는 아이디 : ${id}</h3>
		
		<div>
		<form action="login_input">
		<input type="submit" value="로그인" class="btn btn_p">
		</form>
		
		<form action="findpw">
		<input type="button" value="비밀번호 찾기" class="btn btn_p" onClick="location.href='findidpw'">
		</form>
		</div>
	</c:if>

</body>
</html>