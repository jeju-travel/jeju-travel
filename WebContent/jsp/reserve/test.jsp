<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
  $(document).ready(function() {
    $('#testTable tbody').on('click', 'tr td:not(:first-child)', function () {
    	console.log('1');
    });
  });
</script>

</head>
<body>
<table id="testTable">
  <thead>
    <tr>
      <th></th>
      <th>아이디</th>
      <th>비밀번호</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td></td>
      <td>test</td>
      <td>1234</td>
    </tr>
  </tbody>
</table>
</body>
</html>