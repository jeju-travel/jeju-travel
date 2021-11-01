<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>숙소 상세보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
   rel="stylesheet">
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/d42fd504d6.js"
   crossorigin="anonymous"></script>
<style>
h1{
	margin-top:20px;
	margin-left:10px;
}

div{
	margin-left:20px;
}

.backImg {
   width: 630px;
   height: auto;
   background-size: cover;
   background: no-repeat;
   
}

#detailloc{
	margin-top:20px;
	margin-left:39px;
}
#detailphone{
	margin-top:20px;
	margin-left:39px;
}
.checkclass{
	margin-top:20px;
	margin-left:39px;
	font-size:20px;
}
.detailprice{
	margin-top:20px;
	margin-left:39px;
	font-size:20px;
	font-weight:bold;
}
.buttonclass{
	margin-top:20px;
	margin-left:39px;
}
h2{
	margin-top:20px;
	margin-left:20px;
}

</style>
</head>
<body>
<form action="main_car">
   	<h1>${room.lodging_name}</h1>
   	<hr>
   	
   	<div class="detailall">
         	<div class="backImg">
            	<img src="${room.lodging_image}"
               		    style="max-width: 100%; height: auto;">
            </div>
   	</div>
   	<div id="detailloc" class="fas fa-map-marker-alt"> ${room.lodging_loc}</div><br/>
   	<div id="detailphone" class="fas fa-phone-alt">${room.lodging_phone}</div>
    	<div class="checkclass">
        	체크인 : <select name="checkIn">
            	<option value="오전">오전</option>
            	<option value="오후">오후</option>
         			</select>
         	체크아웃 : <select name="checkOut"> 
            	<option value="오전">오전</option>
            	<option value="오후">오후</option>
         			</select>
      	</div>
    <div class="detailprice">1박당 가격 : ${room.lodging_price}</div>
	
	<div class="buttonclass">
		<input type="text" name="roomNo" value="${room.lodging_no}" hidden="hidden"/>
   		<input type="text" name="check" value="1" hidden="hidden">
   		<input type="submit" value="장바구니 담기" onClick="location.href='main_car" class="btn btn-primary" style="margin-bottom:30px;"/>
   		<input type="button" value="이전 화면" onClick="location.href='lodging_list_user'" class="btn btn-primary" style="margin-bottom:30px;"/>
   </div>
</form>
   <div>
      <!-- <h2>리뷰</h2> -->
      <!-- <hr>  -->
      <!--  
      <div>
      		<table>
      			<tr>
      				<th>사용자 : </th>
      				<th>호텔 이름 : </th>
      				<th>작성한 날짜 : </th>
      			</tr>
      			<tr>
      				<td>${user_name}</td>
      				<td>${lodging_name}</td>
      				<td>${date}</td>
      			</tr>
      			
      		</table>
      </div>
      -->
   </div>
</body>
</html>