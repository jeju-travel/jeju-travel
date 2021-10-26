<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항공등록</title>
</head>
<body>
<h3>항공등록</h3>
<hr>
<form method="post" action="addAirline">
항공이름<input type="text" name="airName"><br>
가격<input type="text" name="price"><br>
위치<input type="text" name="airLoc"><br>
출발시간<input type="text" name="takeOff"><br>
파일 위치<input type="text" name="airImage"><br>
<input type="submit" value="항공 등록하기">
</form>
</body>
</html>