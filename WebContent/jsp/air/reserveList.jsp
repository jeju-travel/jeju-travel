<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
 
<title>제주 여행</title>
</head>
<body>
<h3>항공 댓글쓰기</h3>
<hr>
<div class="container mt-3">
<table class="table">
	<c:forEach var="airline" items="${airlineList}">
		<tr>
			<td>
				<a href="saveAirReview?airNo=${airline.airNo}">${airline.airName}</a><br>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>