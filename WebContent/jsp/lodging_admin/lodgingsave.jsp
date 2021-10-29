<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>숙소 추가</title>
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
    .inserttable input{
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
        margin-top:30px;
    }
    .lodgingbutton a{
    	width:300px;
    }
    .lodgingbutton input{
    	width:300px;
    	margin-right:10%;
    }
    .listmove{
    	text-align: center;
    	margin-top:20px;
    }
</style>
</head>
<body>
	<form method="post" action="lodging_save">
		<h1>숙소 추가(관리자)</h1>
        <table class="inserttable">
            <tr>
                <td class="lodgingtext"> 숙소 이름 : </td>
                <td><input type="text" size="60px" name="lodgingname" placeholder=" 숙소 이름을 입력해 주세요!"></td>
            </tr>
            <tr>
                <td class="lodgingtext"> 숙소 위치 : </td>
                <td><input type="text" size="60px" name="lodgingloc" placeholder=" 숙소 위치를 입력해 주세요!"></td>
            </tr>
            <tr>
                <td class="lodgingtext"> 숙소 전화번호 : </td>
                <td><input type="text" size="60px" name="lodgingphone" placeholder=" 숙소 전화번호를 입력해 주세요!"></td>
            </tr>
            <tr>
            	<td class="lodgingtext"> 숙소 이미지 : </td>
            	<td><input type="text" size="60px" name="lodgingimage" placeholder=" 숙소 이미지경로를 넣어주세요!"></td>
           	</tr>
        </table>
    <div class="lodgingbutton">
    <!-- 이전버튼 링크 -->
        <a class="btn btn-primary" href="adminmain.jsp">이전</a>
        <input type="submit" class="btn btn-primary" value="숙소 추가">
        <input type="reset" class="btn btn-primary" value="다시 입력">
    </div>
    <div class="listmove">
    	<h2>${message}</h2>
    	<a class="btn btn-primary" href="lodging_list">숙소 리스트로 이동</a>
    </div>
	</form>
</body>
</html>