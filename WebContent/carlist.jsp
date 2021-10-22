<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    .login_memu{
        font-size: 10px;
        display: flex;        
    }
    .login_memu li{
        padding: 8px 12px;
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
</style>
<body>
    <header class="header_nav">
        <div class="header_top">
            <h3>렌트카 검색 리스트</h3>         
        </div>
        <ul class="login_memu">
            <li><a href="#">회원가입</a></li>
            <li><a href="#">로그인</a></li>
            <li><a href="#">마이페이지</a></li>
        </ul>
       
    </header>
    <hr>

    <form action="#" method="post">
        <div class="date_main">
            <div class="date_side1">
                대여일<br/>
                <input type="date">
                <select name="" id="">
                    <option value="">오전</option>
                    <option value="">오후</option>                    
                </select>
                <br/>
                
                차종 <br/>               
                <select name="" id="">
                    <option value="">전체</option>
                    <option value="">소형차</option>
                    <option value="">중형차</option>
                    <option value="">대형차</option>
                    <option value="">전기차</option>
                </select>
            </div>
            
            <div class="date_side2">
                반납일<br/>
                <input type="date">
                <select name="" id="">
                    <option value="">오전</option>
                    <option value="">오후</option>                    
                </select>
                <br/>
                연료<br/>
                <select name="" id="">
                    <option value="">전체</option>
                    <option value="">가솔린</option>
                    <option value="">LPG</option>
                    <option value="">디젤</option>
                    <option value="">전기차</option>
                </select>
            </div>
            
        </div>
        <center><input type="submit" class = "btn btn-primary" value="조회"></center>
    </form>
   
    <hr>
    <h4>차량 검색결과</h4>
    <hr>
</body>
</html>