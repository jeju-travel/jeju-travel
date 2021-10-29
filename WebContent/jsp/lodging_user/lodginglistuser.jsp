<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>���� ����Ʈ</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
  	<script src="https://kit.fontawesome.com/d42fd504d6.js"
	crossorigin="anonymous"></script>
  	<style>
  		*{ 
        	margin: auto;
        	padding: 0;
    	}
    	body{
        	padding-top: 60px;
        	margin: auto;
    	}
    	.dateselect{
    		margin-right:30%;
    	}
    	hr{
    		background-color:black;
    	}
    	.lodgingimage{
    		width:100px;
      		height: auto;
      		background-size:cover;
      		background: no-repeat;
    	}
    	
    		.box{
		display:flex;
		
		align-items: center;
	}
	
	.backImg{
		width:300px;
		height: auto;
		background-size:cover;
		background: no-repeat;
	}
	
  	</style>
</head>
<body>
<div class="lodginglist">
 
        <!-- �̺κ��� ��� ������ ������ ���� �� value�� �������� �ڵ� �Է� -->
        <table class="dateselect">
        	<tr>
        		<th><input type="date">~</th>
        		<th><input type="date" style="margin-right:20px;"> </th>
        		<th><h3 style="margin-right:10px;">���� : </h3></th>
        		<th>
        			<select>
        				<option value="one">1��</option>
        				<option value="two">2��</option>
        				<option value="three">3��</option>
        				<option value="four">4��</option>
        			</select>
        		</th>
        		<th><h3 style="margin-left:10px;">��� : </h3></th>
        		<th>
        			<select style="margin-left:10px;">
        				<option value="one">1��</option>
        				<option value="two">2��</option>
        				<option value="three">3��</option>
        				<option value="four">4��</option>
        			</select>
        		</th>
        		
        		<th><input class="btn btn-primary" type="submit" style="margin-left:10px;" value="�˻�"></th>
        	</tr>
        </table>
        
        <h1 style="margin-left:30px;">���� ����Ʈ</h1>
        
        <hr>
        <c:if test="${!empty lodgingList}">
        
        <table class="table">
        	<c:forEach var="list" items="${lodgingList}">
               <tr>
               	  <td>
               	  	<div class="box">
               	  		<div class="backImg"><img src="${list.lodging_image}" style="max-width: 100%; height: auto;"></div>	
               	  	</div>
               	  </td>
               	  <td><div><p><font size="5"><b>${list.lodging_name}</b></font></p style="color:#bbb">
               	  <p><i class="fas fa-map-marker-alt"></i>  ${list.lodging_loc}</p></td>
               
               	  <td><p><i class="fas fa-phone-alt"></i>  ${list.lodging_phone}</p><p><i class="fas fa-won-sign"></i> ${list.lodging_price}</p></td>
                 
                  <td>
                  
                  <p>���� �����ֱ�</p>	
                  <input type="button" value="�����ϱ�"  onClick="location.href='detail_room?roomNo=${list.lodging_no}'">
        
                  </td>
               </tr>
            </c:forEach>
        </table>
        </c:if>
        <c:if test="${empty lodgingList }">��ϵ� ���Ұ� �����ϴ�.</c:if>
</div>
</body>
</html>