<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<input type="text" name="airNum" value="${airline.airNo}" hidden="hidden">
항공이름<input type="text" name="airName" value="${airline.airName}"><br>
가격<input type="text" name="price" value="${airline.price}"><br>
위치<input type="text" name="airLoc" value="${airline.airLoc}"><br>
출발시간<input type="text" name="takeOff" value="${airline.takeOff}"><br>
파일 위치<input type="text" name="airImage" value="${airline.airImage}"><br>

<input type="submit" value="수정하기">
<input type="button" id="delete" value="삭제하기">
</form>
</body>
</html>