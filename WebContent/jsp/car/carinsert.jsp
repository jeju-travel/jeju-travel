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
        <form  action="car_save" method="post">
            <h2>렌트카추가</h2>
            <hr>           
            <div calss="size"> 
                <table class="table_main">	
                    <tr>
                        <td>차량이름</td>
                        <td><input type="text" name="car_name" value="${carForm.car_name}"/></td>                       
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
                        <td><input type="text" name="car_price" value="${carForm.car_price}" /></td>
                    </tr>
                    <tr>
                        <td>최대탑승인원</td>
                        <td><input type="text" name="capacity" value="${carForm.capacity}" /></td>
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
                        <td><input type="text" name="car_loc" value="${carForm.car_loc}" /></td>
                    </tr>
                    <tr>
                        <td>이미지</td>
                        <td><input type="text" name="car_image" value="${carForm.car_image}"/></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="다시입력" class="btn btn-primary"></td>
                        <td><input type="submit" value="차량추가" class="btn btn-primary"></td>
                    </tr>
                </table>         
            </div>                              
        </form>       
        	 
		${message}<br/>
	
		<c:if test="${errors!=null }">
			<p>잘 저장 되었습니다</p>
			<ul>
				<c:forEach var="error" items="${errors}">
					<li>${error}</li>
				</c:forEach>
			</ul>
		</c:if> 
		<hr>
		<center>
		<a href="car_search?reqPage=1">리스트로이동</a>/<a href="login">관리자모드</a><br/>
		
		${carError.car_nameErr} ${carError.car_priceErr} <br/>
        ${carError.capacityErr} ${carError.car_locErr}<br/> 
		${carError.car_imgErr}
		</center>
    </main>	
</body>
</html>