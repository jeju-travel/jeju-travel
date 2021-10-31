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

<title>항공사 수정, 삭제</title>
</head>
<body>
<h3>항공사 리스트</h3>
<hr>
<div class="container mt-3">
<table class="table table-hover">
	<c:forEach var="airline" items="${airlineList}">
		<tr onclick="location='updateAirline?airNo=${airline.airNo}'">
			<td><a href="updateAirline?airNo=${airline.airNo}">${airline.airName}</a></td>
		</tr>
	</c:forEach>
</table>
</div>

</body>
</html>