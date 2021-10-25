<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항공등록</title>
</head>
<body>
<h3>항공사 리스트</h3>
<hr>
<table>
	<c:forEach var="airline" items="${airlineList}">
		<tr>
			<td><a href="updateAirline?airNo=${airline.airNo}">${airline.airName}</a></td>
		</tr>
	</c:forEach>
</table>
</form>
</body>
</html>