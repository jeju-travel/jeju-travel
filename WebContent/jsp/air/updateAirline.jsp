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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#delete").click(
		function(){
			var no = $("input[name=airNum]").val();
			$(location).attr('href','deleteFromAirline?airNum='+no);
		}
	);
});
</script>
</head>
<body>
<h3>항공등록</h3>
<hr>
<form action="updateSetAirline">
<table>
<tr>
	<td>
		<input type="text" name="airNum" value="${airline.airNo}" hidden="hidden">항공이름
	</td>
	<td>
		<input type="text" name="airName" value="${airline.airName}">
	</td>
</tr>
<tr>
	<td>
		가격
	</td>
	<td>
		<input type="text" name="price" value="${airline.price}">
	</td>
</tr>
<tr>
	<td>
		위치
	</td>
	<td>
		<input type="text" name="airLoc" value="${airline.airLoc}">
	</td>
</tr>
<tr>
	<td>
		출발시간
	</td>
	<td>
		<input type="text" name="takeOff" value="${airline.takeOff}">
	</td>
</tr>
<tr>
	<td>
		파일 위치
	</td>
	<td>
		<input type="text" name="airImage" value="${airline.airImage}">
	</td>
</tr>
</table>
<input type="submit" value="수정하기">
<input type="button" id="delete" value="삭제하기">
</form>
</body>
</html>