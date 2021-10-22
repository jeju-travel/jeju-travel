<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login.jsp</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="login" method="post">
		<input type="text" name="id"/>
		<input type="password" name="password"/>
		<input type="submit" value="로그인"/>
		${message}
	</form>
</body>
</html>