<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login.jsp</title>
</head>
<body>
	<h2>�α���</h2>
	<form action="login" method="post">
		<input type="text" name="id"/>
		<input type="password" name="password"/>
		<input type="submit" value="�α���"/>
		${message}
	</form>
</body>
</html>