<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="default.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>메인화면</title>
</head>
<style>
    body{
        margin: auto;
        width: 80%;
    }    
    main{        
        position: absolute;
        top: 50%;
        left: 50%;
        margin:-150px 0 0 -150px;
        text-align: center;
    }
    .main_center{
        display: flex;  
    }
    .main_memu{
        padding: 20px;        
    }
    
</style>
<body>
<c:if test="${member != null}">
	${member}님 반갑습니다
	<a href="logout">로그아웃</a>
    <a href="mypage">마이페이지</a>
</c:if>    
<c:if test="${member == null}">
    <a href="join">회원가입</a>
    <a href="login_input">로그인</a>
</c:if>
    <main>
    
        <h3>제주여행</h3><br>
        <h5>숙소예약</h5>
        <div class="main_center">   
            <form action="#" method="post">     
                    <div class="main_memu">
                        <input type="submit" class="btn btn-primary" value="숙소예약o">
                    </div>
            </form>
            <form action="#" method="post">
                    <div class="main_memu">
                        <input type="submit" class="btn btn-primary" value="숙소예약x">
                    </div>
            </form>   
        </div>
    </main>
   
</body>
</html>