<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>숙소 수정 및 삭제<관리자></title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
  	<style>
  		*{
  			margin:auto;
  			padding:0;
  		}
  		body{
  			margin-top:30px;
  		}
  		.titleupdatedelete{
  			text-align:center;
  		}
  		.detailupdatedelete{
  			margin-top:30px;
  		}
  		input{
  			margin-top:10px;
  			margin-left:10px;
  		}
  	</style>
</head>
<body>
<div class="detailupdatedelete">
   <h3 class="titleupdatedelete">숙소 수정 및 삭제<관리자모드></h3>
   <form method="post" action="lodging_update">
   		<table class="detailupdatedelete">
   			<tr>
      			<td>숙소번호 :</td>
      			<td><input type="text" name="lodging_no" value="${lodging.lodging_no}" disabled="disabled"/>
      				<input type="text" name="lodging_no" value="${lodging.lodging_no}" hidden="hidden"/></td>
      		</tr><!--수정을 위해서 아이디를 히든으로 무조건 보내야함.  -->
      		<tr>
      			<td>이름 :</td>
      			<td><input type="text" name="lodging_name" value="${lodging.lodging_name}"/></td>
      		</tr>
      		<tr>
      			<td>위치 :</td>
      			<td><input type="text" name="lodging_loc" value="${lodging.lodging_loc}"/></td>
      		</tr>
      		<tr>
      			<td>전화번호 :</td>
      			<td><input type="text" name="lodging_phone" value="${lodging.lodging_phone}"/></td>
      		</tr>
      		<tr>
      			<td>가격 :</td>
      			<td><input type="text" name="lodging_price" value="${lodging.lodging_price}"/></td>
      		</tr>
      		<tr>
      			<td>이미지 경로:</td>
      			<td><input type="text" name="lodging_image" value="${lodging.lodging_image}"/></td>
      		</tr>
      	</table>
      	<div class="btnclass">
      		<input class="btn btn-primary" type="submit" value ="수정" 
      				style="width:300px; margin-top:10px; margin-left:30%;"/></td>
        	<button type="button" onclick="location.href='lodging_delete?lodging_no=${lodging.lodging_no}'" 
        			class="btn btn-primary" style="width:300px; margin-top:10px;">삭제</button><br>
        	<a class="btn btn-primary" href="lodging_list"
        		style="margin-left:40%; margin-top:20px; width:300px;">이전</a>
      	</div>
   </form>
   
</div>
</body>
</html>