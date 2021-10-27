<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>결과 화면</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
  	<style>
  		*{
  			margin:auto;
  			padding:0;
  		}
  		body{
  			text-align:center;
  			margin-top:20%;
  		}
  		.Result{
  			text-align:center;
  		}
  	</style>
  	
</head>
<body>
<div class="Result">
	<table>
   		<tr>   
      		<td>${message}</td>
      	</tr>
      	<tr>
      		<th><a class="btn btn-primary" href="lodging_list">숙소 리스트로 이동하기</a></th>
   		</tr>
	</table>
</div>
</body>
</html>