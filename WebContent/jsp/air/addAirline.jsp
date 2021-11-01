<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>

<script type="text/javascript">
	$(document).ready(function(){
		
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

<title>항공등록</title>
</head>
<body>
<h3>항공등록</h3>
<span>*표시는 필수작성 항목입니다.</span>
<hr>
<form method="post" action="addAirline">
<table>
<tr>
	<td>*항공이름</td>
	<td><input type="text" name="airName"></td>
</tr>
<tr>
	<td>*가격</td>
	<td><input type="number" name="price"></td>
</tr>
<tr>
	<td>*위치</td>
	<td><input type="text" name="airLoc"></td>
</tr>
<tr>
	<td>*출발시간</td>
	<td><input type="text" name="takeOff"></td>
</tr>
<tr>
	<td>항공사 이미지</td>
	<td><input type="text" name="airImage"></td>
</tr>
</table>
<input class="btn btn-primary" type="submit" value="항공 등록하기">
</form>
</body>
</html>