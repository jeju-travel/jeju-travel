<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="default.css">
    <title>렌트카 검색 리스트</title>
</head>
<style>
    body{
        margin: auto;
        width: 80%;
    }
    .header_nav{
        display: flex;
        justify-content: space-between;
        align-items: center;       
        padding: 8px 12px;
    }
    .header_top{
        display: flex;
    }    
    
    #header_btn{        
        padding: 10px;
        width: 45%;
    }
    .date_main{
        display: flex;
        padding: 20px;
        justify-content:center;
    }
    .date_side1{
        width: 30%;
    }
    .date_side2{
        width: 30%;
    }
    h4{
        padding: 8px 12px;
    }
    /* .car_select{
    	text-align:center;
    } */
</style>
<body>
    <header class="header_nav">
        <div class="header_top">
            <h3>렌트카 검색 리스트</h3>         
        </div>  
    </header>
    <hr>

    <form action="car_select" method="post">
        <div class="date_main">
            <div class="date_side1">            
         	 
                대여일<br/>
                <input type="date" name="start_day" value="${param.start_day}" readonly>
                <select name="borrow_car">
                    <option value="오전">오전</option>
                    <option value="오후">오후</option>                    
                </select>
                <br/>
                
                차종 <br/>               
                <select name="car_type">
                    <option value="전체">전체</option>
                    <option value="경차">경차</option>
                    <option value="중형차">중형차</option>
                    <option value="대형차">대형차</option>
                </select>
            </div>
            
            <div class="date_side2">
                반납일<br/>
               <input type="date" name="end_day" value="${param.end_day}" readonly>
                <select name="return_car">
                    <option value="오전">오전</option>
                    <option value="오후">오후</option>                    
                </select>
                <br/>
                연료<br/>
               <select name="car_fuel">	
               		<option value="전체">전체</option>				
					<option value="휘발유">휘발유</option>
					<option value="경유">경유</option>
					<option value="가솔린">가솔린</option>
					<option value="전기">전기</option>
               </select>
            </div>
            
        </div>
        <center><input type="submit" class = "btn btn-primary" value="조회"></center>
    </form>
   
    <hr>
    <h4>차량 검색결과</h4>
    <hr>
    
    <div class="container mt-3" id="car_select">
		<c:if test="${!empty carList}">
			<table class="table table-hover">
				<tr>
					<th>차량이름</th>
					<th>가격</th>
					<th>최대탑승</th>
					<th>차종</th>
					<th>연료</th>
					<th>대여</th>
					<th>반납</th>
					<th>예약</th>
					<th>별점</th>					
				</tr>		
										
				<c:forEach var="car" items="${carList}">
					<form action="car_reserve" method="post">
					<input type="text" name="car_no" value="${car.car_no}" hidden="hidden"/> 
					<input type="text" name="borrow_car" value="${borrow_car}" hidden="hidden"/> 
					<input type="text" name="return_car" value="${borrow_car}" hidden="hidden"/> 
						<tr>
							<td>${car.car_name}</td>
							<td>${car.car_price*cha}</td>
							<td>${car.capacity}</td>
							<td>${car.car_type}</td>
							<td>${car.car_fuel}</td>
							<td>${borrow_car}</td>
							<td>${return_car}</td>
							<td><input type="submit" class="btn btn-primary btn-sm" value="예약하기"></td>
							<c:forEach var="carhoroscope" items="${carhoroscopeList}">								
								<c:if test="${carhoroscope.car_no eq car.car_no}">	
									<td>${carhoroscope.car_horoscope}/5.0</td>	
								</c:if>							
							</c:forEach>							
						</tr>
					</form>	
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty carList }">렌트카를 검색하지 못했습니다.</c:if>
		
	</div>
</body>
</html>