<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	var car_type = "${car.car_type}";
	$('select option').each(function(){
		if(car_type==$(this).val()){
			$(this).attr('selected', 'selected');
		}
	});
	
	var car_fuel = "${car.car_fuel}";
	$('select option').each(function(){
		if(car_fuel==$(this).val()){
			$(this).attr('selected', 'selected');
		}
	});
	
	
});

</script>
<style>
    html{
		height: 100%;
	}
    body{
        position: relative;
        width: 100%;
        height: 100%;
    }
    main{ 
        position: absolute;
        top: 40%;
        left: 50%;
        margin:-150px 0 0 -150px;      
    }    
    .table_main tr td{
       	font-size: 20px;
    }
</style>
</head>
<body>
    <main>
        <form  action="car_update" method="post">
            <h2>차량 수정 및 삭제</h2>
            <hr> 
            	<input type="text" name="car_no" value="${car.car_no}" hidden="hidden"/>  
                <table class="table_main">
                    <tr>						                 
                        <td>차량이름</td>
                        <td><input type="text" name="car_name" value="${car.car_name}"/></td>
                        
                    </tr>
                    <tr>
                        <td>차종</td>
                        <td>
                            <select name="car_type">
                                <option value="경차">경차</option>
                                <option value="중형차">중형차</option>
                                <option value="대형차">대형차</option>
                              </select>                           
                        </td>
                    </tr>
                    <tr>
                        <td>가격</td>
                        <td><input type="text" name="car_price" value="${car.car_price}"/></td>
                    </tr>
                    <tr>
                        <td>최대탑승인원</td>
                        <td><input type="text" name="capacity" value="${car.capacity}"/></td>
                    </tr>
                    <tr>
                        <td>연료</td>
                        <td>
                           <select name="car_fuel">
                                <option value="휘발유">휘발유</option>
                                <option value="경유">경유</option>
                                <option value="가솔린">가솔린</option>
                                <option value="전기">전기</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>위치</td>
                        <td><input type="text" name="car_loc" value="${car.car_loc}" /></td>
                    </tr>
                    <tr>
                        <td>이미지</td>
                        <td><input type="text" name="car_image" value="${car.car_image}" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="수정하기" class="btn btn-primary"></td>
                        <td><button type="button" onclick="location.href='car_delete?car_no=${car.car_no}'" class="btn btn-primary">삭제하기</button ></td>
                    	
                    </tr>
                   </table>
                              
        </form>
    	${message}<br/>
	
		<c:if test="${errors!=null}">
			<p>잘 저장 되었습니다</p>
			<ul>
				<c:forEach var="error" items="${errors}">
					<li>${error}</li>
				</c:forEach>
			</ul>
		</c:if> 
		<hr>
		<center>
		<a href="car_search?reqPage=1">리스트로이동</a>/<a href="login">관리자모드</a><br/><br/>
		${carError.car_nameErr} ${carError.car_priceErr} <br/>
        ${carError.capacityErr} ${carError.car_locErr}<br/> 
		 ${carError.car_imgErr}
		</center>
      </main>	     
   
</body>
</html>