<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

<script src="https://kit.fontawesome.com/d42fd504d6.js" crossorigin="anonymous"></script>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	
<script type="text/javascript">
$(document).ready(function(){
    $('.main i').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa fa-eye-slash fa-lg")
            .prev('input').attr('type',"text");
        }else{
            $(this).attr('class',"fa fa-eye fa-lg")
            .prev('input').attr('type','password');
        }
    });
    
    
    var no = "${mem.no}";
    $('#btn_delete').ready(function(){
		$(location).attr('href','delete?no=' + no );
	});
	

	
	var select = $('select');
	
	$('option').each(function(){
		if($(this).val() == select){
			$(this).attr('checked','checked');
		}
	});
});
</script>
<style type="text/css">
div {
	margin: 15px;
}

label {
	display: inline-block;
	width: 150px;
}

input, select {
	border-radius: .25rem;
	border-color: #ddd;
	width: 300px;
	height: 30px;
	margin: 10px;
}

input[type="text"], input[type="password"], select {
	width: 190px;
	height: 30px;
}

.btn {
	width: 120px;
	height: 40px;
	border: 1px solid transparent;
	padding: .375rem .75rem;
	font-size: 1rem;
	border-radius: .25rem;
	transition: color .15s;
}

.btn_p {
	color: #fff;
	background-color: #0d6efd;
	border-color: #0d6efd;
}

.btn_cancle {
	color: #fff;
	background-color: #ccc;
	border-color: #ccc;
}
</style>
</head>
<body>

<h2>ȸ������</h2>
	<h4>�󼼺���</h4>
	<hr>
	<form action="update">
		<div>
			<label>���̵�</label><input type="text" name="id" value="${mem.id}"
				disabled />

		</div>
<div class="main">
<label>��й�ȣ</label> 
  <input type="password" placeholder="��й�ȣ�� �Է��ϼ���">
  <i class="fa fa-eye fa-lg"></i>
 

</div>
<div>
			<label>�̸�</label><input type="text" name="name" value="${mem.name}">
		</div>
		<div>
			<label>��й�ȣ ��Ʈ</label> <select name="hint" value="${mem.hint}">
				<option value="school">������ ������ �ʵ��б���?</option>
				<option value="city">������ �¾ ���ô�?</option>
				<option value="food">������ ���� �����ϴ� ������?</option>
			</select>
		</div>
		<div>
			<label>�亯</label><input type="text" name="answer"
				value="${mem.answer}">
		</div>
		<div>
			<label>��ȭ��ȣ</label><input type="text" name="phone"
				value="${mem.phone}">
		</div>
		<div>
			<label>�̸���</label><input type="text" name="email"
				value="${mem.email}">
		</div>
		<input type="submit" value="����" class="btn btn_p" /> <input
			type="button" value="Ż��" class="btn btn_cancle" id="btn_delete" /> <input
			type="text" name="no" value="${mem.no}" hidden="hidden">


	</form>


	<div class="main">
		<input type="password" placeholder="��й�ȣ�� �Է��ϼ���"> <i
			class="fa fa-eye fa-lg"></i>

	</div>
</body>
</html>