<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
	Calendar calStart = Calendar.getInstance();
	Calendar calEnd = Calendar.getInstance();
	calEnd.add(calEnd.DATE, + 1);
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제주 여행</title>
</head>
<body>
<form method="post" action="reserveAirlineCheck">
	<h3>제주 여행s</h3>
	출발 날짜 <input type="date" name="startDay" value=<%= sf.format(calStart.getTime()) %>><BR>
	도착 날짜 <input type="date" name="endDay" value=<%= sf.format(calEnd.getTime()) %>><br>
	<input type="submit" value="검색">
</form>
	<input type="button" value="항공등록하기" onclick="location.href='goAddAirline'">
	<input type="button" value="항공수정하기" onclick="location.href='showAirline'"><br>
	<input type="button" value="댓글쓰기" onclick="location.href='writeAirReview'">
</body>
</html>