<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>객실 추가</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
    *{ 
        margin: auto;
        padding: 0;
    }
    body{
        padding-top: 60px;
        margin: auto;
    }
    .lodgingtext{
        margin-top: 20px;
    }
    input{
        margin-top: 10px;
        margin-left: 10px;
        width: 600px;
        height: 30px;
    }
    h1{
        text-align: center;
    }

    .lodgingbutton{
        display: flex;
        justify-content: center;
        padding: 10px;
    }
    .lodgingbutton button{
        width: 300px;
        margin: 50px;
    }
</style>
</head>
<body>
	<form method="post" action="room_save">
		<h1>객실 추가(관리자)</h1>
        <table>
            <tr>
                <td class="lodgingtext"> 숙소 이름 : </td>
                <td><input type="text" name="lodging_name" value="${lodging.lodging_name}" disabled="disabled"/>
      				<input type="text" name="lodging_name" value="${lodging.lodging_name}" hidden="hidden"/></td> <!--수정을 위해서 아이디를 히든으로 무조건 보내야함.-->
            </tr>
            <tr>
                <td class="lodgingtext"> 숙소 위치 : </td>
                <td><input type="text" name="lodging_loc" value="${lodging.lodging_loc}"/></td>
            </tr>
            <tr>
                <td class="lodgingtext"> 숙소 전화번호 : </td>
                <td><input type="text" name="lodging_phone" value="${lodging.lodging_phone}"/></td>
            </tr>
            <tr>
            	<td class="lodgingtext"> 객실 이름 : </td>
            	<td><input type="text" name="room_name" placeholder=" 객실 이름을 입력해 주세요."></td>
            </tr>
            <tr>
            	<td class="lodgingtext"> 1박당 가격 : </td>
            	<td><input type="number" name="room_price" placeholder=" 가격을 입력해 주세요."></td>
            </tr>
            <tr>
            	<td class="lodgingtext"> 인원 : </td>
            </tr>
        </table>
        		<select name="room_personnel" id="room_personnelnumber">
            		<option value="one" selected>1</option>
            		<option value="two">2</option>
            		<option value="three">3</option>
            		<option value="four">4</option>
            	</select>
        <!-- a링크 이용하여 이전,삭제 변경 -->
    <!-- <center> -->
    <div class="lodgingbutton">
        <!--  <button type="submit" class="btn btn-primary">이전</button> -->
        <input type="submit" class="btn btn-primary" value="객실 추가">
        <input type="reset" class="btn btn-primary" value="다시 입력">
    </div>
    <a href="room_list">객실 리스트로 이동</a>
    ${message}
    <!-- </center> -->
	</form>
</body>
</html>