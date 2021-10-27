<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
        display: flex;
  		justify-content: center;
  		align-items: center;
  		text-align:center;
  		min-height: 100vh;    
    } 
   
    .main_center{
        display: flex;  
    }
    .main_memu{
        padding: 20px;        
    }
    
</style>
<body>    
    <main>
        <h3>제주여행</h3><br>
        <h5>항공예약</h5>      
         
        <div class="main_center">   
            <form action="reserveAirline" method="post">
                    <div class="main_memu">
                        <input type="submit" class="btn btn-primary" value="항공예약o">
                    </div>
            </form>
            <form action="main_lodging" method="post">
                    <div class="main_memu">
                        <input type="submit" class="btn btn-primary" value="항공예약x">
                    </div>
            </form>   
        </div>
    </main>
   
</body>
</html>