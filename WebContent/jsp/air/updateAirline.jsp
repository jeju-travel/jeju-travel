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
	
	$("input[type='submit']").click(function(){
		
		var air_Name = $("input[name='airName']").val();
		var air_Price = $("input[name='price']").val();
		var air_Loc = $("input[name='airLoc']").val();
		var air_TakeOff = $("input[name='takeOff']").val();
		
		if(!air_Name){
			alert("항공사명을 입력하세요.");
			$("input[name='airName']").focus();
			return false;
		}else if(!air_Price){
			alert("가격을 입력하세요.");
			$("input[name='price']").focus();
			return false;
		}else if(!air_Loc){
			alert("항공사 위치를 입력하세요.");
			$("input[name='airLoc']").focus();
			return false;
		}else if(!air_TakeOff){
			alert("출발시간을 입력하세요.");
			$("input[name='takeOff']").focus();
			return false;
		}
		
	});
});
</script>
<style type="text/css">
body {
	margin: 15px;
}
td {
	padding: 10px;
}
</style>
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
<input class="btn btn-primary" type="submit" value="수정하기">
<input class="btn btn-primary" type="button" id="delete" value="삭제하기">
</form>
</body>
</html>