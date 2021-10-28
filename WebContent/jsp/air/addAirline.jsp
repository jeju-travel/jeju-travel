<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
 
<title>항공등록</title>
</head>
<body>
<h3>항공등록</h3>
<hr>
<form method="post" action="addAirline">
<table>
<tr>
	<td>항공이름</td>
	<td><input type="text" name="airName"></td>
</tr>
<tr>
	<td>가격</td>
	<td><input type="text" name="price"></td>
</tr>
<tr>
	<td>위치</td>
	<td><input type="text" name="airLoc"></td>
</tr>
<tr>
	<td>출발시간</td>
	<td><input type="text" name="takeOff"></td>
</tr>
<tr>
	<td>파일 위치</td>
	<td><input type="text" name="airImage"></td>
</tr>
</table>
<input class="btn btn-primary" type="submit" value="항공 등록하기">
</form>
</body>
</html>