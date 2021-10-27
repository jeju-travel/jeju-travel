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
  		.detailupdatedelete{
  			display:block;
  		}
  		.titleupdatedelete{
  			text-align:center;
  		}
  		.detailupdatedelete input{
  			display:block;
  			/* margin-top:10px; */
  		}
  		.detailupdatedelete{
  			width:600px;
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
      			<td>이미지 :</td>
      			<td><input type="text" name="lodging_image" value="${lodging.lodging_image}"/></td>
      		</tr>
      		<tr>
      			<td><input class="btn btn-primary" type="submit" value ="수정"/></td>
                <td><button type="button" onclick="location.href='lodging_delete?lodging_no=${lodging.lodging_no}'" class="btn btn-primary">삭제</button></td>
      			<!-- <a class="btn btn-primary" href="lodging_delete?lodging_no=${lodging.lodging_no}">삭제</a> -->
      		</tr>
      	</table>
   </form>
   
</div>
</body>
</html>