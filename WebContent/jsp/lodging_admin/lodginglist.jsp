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
    	tr{
			text-align:center;
    	}
    	.updatedelete{
    		text-decoration:none;
    	}
    	.titlename{
    		font-size:20px;
    	}
    	td{
    		font-size:12px;
    		font-weight:bold;
    	}
    	
  	</style>
</head>
<body>
<div class="container mt-3">
        <div class="title">
        	<h1>���� ����Ʈ<�����ڸ��></h1>
        	<a class="btn btn-primary" href="lodging_input">���� �߰�</a>
        </div>
        <hr>
        <c:if test="${!empty lodgingList}">
        <table class="table table-dark table-hover">
        	<tr>
        		<th class="titlename">���� �̸�</th>
        		<th class="titlename">���� ��ġ</th>
        		<th class="titlename">���� ��ȭ��ȣ</th>
        		<th class="titlename">���� �̹���</th>
        		<th class="titlename">���� ���� �� ����</th>
        	</tr>
        	<c:forEach var="list" items="${lodgingList}">
               <tr>
                  <td>${list.lodging_name}</td>
                  <td>${list.lodging_loc}</td>
                  <td>${list.lodging_phone}</td>
                  <td>${list.lodging_image}</td>
                  <td><a class="updatedelete" href="lodging_detail?lodging_no=${list.lodging_no}">�󼼺���</a>
               </tr>
            </c:forEach>
        </table>
        </c:if>
        <c:if test="${empty lodgingList }">��ϵ� ���Ұ� �����ϴ�.</c:if>
</div>
</body>
</html>