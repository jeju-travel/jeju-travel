<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script src="https://kit.fontawesome.com/d42fd504d6.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		
		$('.pw i').on('click',function(){
	        $('input').toggleClass('active');
	        if($('input').hasClass('active')){
	            $(this).attr('class',"fa fa-eye-slash fa-lg")
	            .prev('input').attr('type',"text");
	        }else{
	            $(this).attr('class',"fa fa-eye fa-lg")
	            .prev('input').attr('type','password');
	        }
	    });
		
		
		$('.pw2 i').on('click',function(){
	        $('input').toggleClass('active');
	        if($('input').hasClass('active')){
	            $(this).attr('class',"fa fa-eye-slash fa-lg")
	            .prev('input').attr('type',"text");
	        }else{
	            $(this).attr('class',"fa fa-eye fa-lg")
	            .prev('input').attr('type','password');
	        }
	    });
		
		$("input[type= 'submit']").click(function() {

			var pw = $("input[name='pw']").val();
			var pw2 = $("input[name='pw2']").val();

			if (pw != pw2) {
				alert("비밀번호가 다릅니다.");
				$("input[name='pw2']").focus();
				return false;
			}

			$.get(url, {
				"id_value" : input_value
			}, function(data) {
				//alert(data)
				var result_text = $(data).find("result").text();
				alert(result_text);

				var result = eval(result_text);

				if (result) {
					$(".console").html("<h6>사용할수 있는 아이디 입니다.</h6>");
				} else {
					$(".console").html("<h6>사용할수 없는 아이디 입니다.</h6>");

				}
			});

		});

		$("#checkid").click(function() {
			//사용자가 입력값 얻어오기
			var input_value = $("input[name='id']").val();
			//alert(input_value);

			//입력여부 검사
			if (!input_value) {
				alert("아이디를 입력하세요.");
				$("input[name='id']").focus();
				return false;
			}

			var url = "idcheck";

			/* ajax 처리 */
			$.get(url, {
				"id_value" : input_value
			}, function(data) {
				//alert(data)
				var result_text = $(data).find("result").text();
				//alert(result_text);

				var result = eval(result_text);

				if (result) {
					$(".console").html('<h6 style="color:green;">사용 가능한  아이디 입니다.</h6>');
				} else {
					$(".console").html('<h6 style="color:red">중복된 아이디 입니다.</h6>');

				}
			});
		});

	});
</script>



<style type="text/css">
div{
	margin:15px;
}


label{
	display: inline-block;
	width:150px;
}


input, select{
	border-radius: .25rem;
	border-color: #ddd;
	width: 300px;
	height: 30px;
	margin: 10px;
}

input[type="text"], input[type="password"], input[type="tel"], input[type="email"], select{
	width: 190px;
	height: 30px;
}
.btn {

	width:120px;
	height : 40px;
	border: 1px solid transparent;
    padding: .375rem .75rem;
    font-size: 1rem;
    border-radius: .25rem;
    transition: color .15s;
  
    
}

.btn_p{
	color: #fff;
	background-color: #0d6efd;
	border-color: #0d6efd;
}

.btn_cancle{
	color: #fff;
	background-color:#ccc;
	border-color:#ccc;

}
</style>

</head>
<body>
	<h2>회원가입</h3>
	<h4>정보입력</h6>
	<hr>
	<form action="save">
		<div>
			<label>아이디</label><input type="text" name="id"/>
			<input type="button" value="중복체크" class="btn btn_p" id="checkid"/>
			
		</div>
		<div class="console"></div>
		<div class="pw">
			<label>비밀번호</label>
			<input type="password" name="pw">
				<i class="fa fa-eye fa-lg"></i>
		</div>
		<div class="pw2">
			<label>비밀번호 확인</label>
			<input type="password" name="pw2">
				<i class="fa fa-eye fa-lg"></i>
		</div>
		<div>
			<label>이름</label><input type="text" name="name">
		</div>
		<div>
			<label>비밀번호 힌트</label> <select name="hint">
			<option value="food">본인이 가장 좋아하는 음식은?</option>
			<option value="love">첫사랑 이름은?</option>
			<option value="color">본인이 가장 좋아하는 색깔은?</option>
			<option value="animal">본인이 가장 좋아하는 동물은?</option>
			<option value="school">본인이 졸업한 초등학교는?</option>
			<option value="city">본인이 태어난 도시는?</option>
			</select>
		</div>
		<div>
			<label>답변</label><input type="text" name="answer">
		</div>
		<div>
			<label>전화번호</label>
			<input type="tel" id="phone" name="phone" placeholder="010-0000-0000" pattern="(010)-[0-9]{4}-[0-9]{4}" required>
		</div>
		<div>
			<label>이메일</label><input type="email" name="email">
		</div>
		<input type="submit" value="회원가입" class="btn btn_p" />
		<input type="button" value="취소"  class="btn btn_cancle" onClick="location.href='index.jsp'"/> 
	</form>



</body>

</html>