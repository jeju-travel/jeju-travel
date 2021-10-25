<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숙소 리스트 수정 및 삭제</title>
</head>
<body>
   <!-- 이름하고 나이만 db에 저장  -->
   <h3>숙소 수정 및 삭제<관리자모드></h3>
   <form method="post" action="lodging_update">
      	숙소번호 : <input type="text" name="lodging_no" value="${lodging.lodging_no}" disabled="disabled"/>
      			<input type="text" name="lodging_no" value="${lodging.lodging_no}" hidden="hidden"/> <!--수정을 위해서 아이디를 히든으로 무조건 보내야함.  -->
      	이름 : <input type="text" name="lodging_name" value="${lodging.lodging_name}"/>
   		위치 : <input type="text" name="lodging_loc" value="${lodging.lodging_loc}"/>
   		전화번호 : <input type="text" name="lodging_phone" value="${lodging.lodging_phone}"/>
   		이미지 : <input type="text" name="lodging_image" value="${lodging.lodging_image}"/>      
      <input type="submit" value ="수정"/>
   </form>
   <a href="lodging_delete?lodging_no=${lodging.lodging_no}">삭제</a>
</body>
</html>