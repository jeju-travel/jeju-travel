<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
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
        <form  action="#" method="post">
            <h2>렌트카 수정 및 삭제</h2>
            <hr>           
            <div calss="size"> 
                <table class="table_main">	
                	
                    <tr>
						<td><input type="text" name="car_no" value="${car.car_no}" hidden="hidden"/></td>                    
                        <td>차량이름</td>
                        <td><input type="text" name="car_name" value="${car.car_name }"/></td>
                        
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
                        <td><input type="text" name="car_price"/></td>
                    </tr>
                    <tr>
                        <td>최대탑승인원</td>
                        <td><input type="text" name="capacity"/></td>
                    </tr>
                    <tr>
                        <td>연료</td>
                        <td>
                            <select name="car_fuel">
                                <option value="휘발유">휘발유</option>
                                <option value="경유">경유</option>
                                <option value="가솔린">가솔린</option>
                                <option value="전기차">전기차</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>위치</td>
                        <td><input type="text" name="car_loc"/></td>
                    </tr>
                    <tr>
                        <td>이미지(2차)</td>
                        <td><input type="text" name="car_img"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="수정하기" class="btn btn-primary"></td>
                        <td><button type="button" onclick="location.href='index.html'" class="btn btn-primary">삭제하기</button ></td>
                    </tr>
                   </table>         
            </div> 
                              
        </form>
    
      </main>	
       <%--      <h3>Car</h3>
	<form method="post" action="car_update">
		아이디<input type="text" name="car_no" value="${car.car_no}" disabled="disabled"/>
		<input type="text" name="car_no" value="{car.car_no}" hidden="hidden"/> <!--수정을 위해서 아이디를 히든으로 무조건 보내야함.  -->
		이름:<input type="text" name="name" value="${memo.name}"/>
		나이:<input type="text" name="age" value="${memo.age}"/>		
		<input type="submit" value ="수정"/>
	</form>
	<a href="memo_delete?memoid=${memo.memoid}">삭제</a> --%>
   
</body>
</html>