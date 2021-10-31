<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<style>
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	padding: 40px;
}


div{
	display: flex;
	align-items: center;

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

input{
	border-radius: .25rem;
	border-color: #eee;
	width: 300px;
	height: 30px;
	margin: 10px;
}

input[type="checkbox"]{
	width:20px;
}

a {
	text-decoration: none;
	text-align: center;
	color: #bbb;
}

a:hover {
	color: black;
}

label{
	margin:10px;
}


</style>

</head>

<title>login.jsp</title>
</head>
<body>

	<h2>로그인</h2>
	<hr>
	<form action="login" method="post">
		<input type="text" name="id" placeholder="아이디" /><br> <input
			type="password" name="pw" placeholder="비밀번호" /><br> <input
			type="submit" value="로그인" class="btn btn_p" id="btn" />
			<p>${message}</p>
		
	</form>
	<hr>
	<div>
		<a href="findidpw"><label>아이디 찾기</label> | <label>
		비밀번호 찾기</label></a><label><a href="join">회원가입</a></label>
	</div>
</body>
</html>