<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제주 여행</title>
</head>
<body>
<h3>항공 댓글쓰기</h3>
<hr>
<c:forEach var="airline" items="${airlineList}">
	<a href="saveAirReview?airNo=${airline.airNo}">${airline.airName}</a><br>
</c:forEach>

</body>
</html>