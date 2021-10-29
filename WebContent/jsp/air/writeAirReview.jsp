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

<form method="post" action="reviewSave_air">
<input type="text" name="airlineNo" value="${airlineNo}" hidden="hidden">
<table>
	<tr>
		<td>내용</td>
		<td><textarea rows="5" cols="10" name="content"></textarea></td>
	</tr>
	<tr>
		<td>별점</td>
		<td>
			<select name="horoscope">
				<option value=1>1</option>
				<option value=2>2</option>
				<option value=3>3</option>
				<option value=4>4</option>
				<option value=5 selected="selected">5</option>
			</select>
		</td>
	</tr>
</table>
<input type="submit" value="저장하기">
</form>

</body>
</html>