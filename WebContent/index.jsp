<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
	Calendar calStart = Calendar.getInstance();
	Calendar calEnd = Calendar.getInstance();
	Calendar calNot = Calendar.getInstance();
	calEnd.add(calEnd.DATE, + 1);
	calNot.add(calEnd.DATE, - 1);
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/default.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>메인화면</title>
</head>

<c:if test="${!empty message}">
<script type="text/javascript">
	var message = "${message}";	
		alert(message);
</script>
</c:if>

<style>
    body{
        margin: auto;
        width: 80%;
    }
    .header_nav{
        display: flex;
        justify-content: right;
        align-items: center;       
        padding: 8px 12px;
    }    
    .login_memu{
        font-size: 14px;
        display: flex;        
    }
    .login_memu li{
        padding: 8px 12px;
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
    
    li{
    	list-style: none;
    }
    
    a{
    	text-decoration: none;
    }
    
</style>
<body>
    <header class="header_nav">     
    	<c:if test="${member != null }">   
        <ul class="login_memu">
        	<li>${member}님 환영합니다</li>
            <li><a href="logout">로그아웃</a></li>
            <li><a href="mypage">마이페이지</a></li>
        </ul>
        </c:if>
        
        <c:if test="${admin != null }">   
        <ul class="login_memu">
        	<li>${admin}님 환영합니다</li>
            <li><a href="logout">로그아웃</a></li>
           
        </ul>
        </c:if>
        
       
        
        <c:if test="${admin == null && member == null}">
        <ul class="login_memu">
            <li><a href="join">회원가입</a></li>
            <li><a href="login_input">로그인</a></li>
 
        </ul>

        </c:if>
    </header>
    
   	<main>
        <h3>제주여행</h3>
        <form action="main_air" method="post">           
            <div class="main_center">
                <div class="main_memu">
                    출발일<br/><br/>
                    <input type="date" name="start_day" min=<%= sf.format(calStart.getTime())  %> value=<%= sf.format(calStart.getTime()) %>>
                </div>
                <div class="main_memu">
                    도착일<br/><br/>
                    <input type="date" name="end_day" min=<%= sf.format(calEnd.getTime())  %> value=<%= sf.format(calEnd.getTime()) %>>
                </div>                    
            </div>            
            <input type="submit" class ="btn btn-primary" value="검색">           
        </form>
    </main>
   
</body>
</html>