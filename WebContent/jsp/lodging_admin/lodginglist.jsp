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
  	<style>
  		*{ 
        	margin: auto;
        	padding: 0;
    	}
    	body{
        	padding-top: 60px;
        	margin: auto;
    	}
  	</style>
</head>
<body>
<div class="lodgingdate">
        <h5></h5>
        	<input type="date">
        	<input type="date">
        	<h3>���� : </h3>
        	<select>
        	</select>
        <h1>���� ����Ʈ</h1>
        <hr>
        <c:if test="${!empty lodgingList}">
        <table>
        	<c:forEach var="list" items="${lodgingList}">
               <tr>
                  <td>${list.lodging_name}</td>
                  <td>${list.lodging_loc}</td>
                  <td>${list.lodging_phone}</td>
                  <td>${list.lodging_image}</td>
                  <td><a href="lodging_detail?lodging_no=${list.lodging_no}">�󼼺���</a>
               </tr>
            </c:forEach>
        </table>
        </c:if>
        <c:if test="${empty lodgingList }">��ϵ� ���Ұ� �����ϴ�.</c:if>
</div>
</body>
</html>