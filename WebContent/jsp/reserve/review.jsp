<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	
	$('.btn_cancle').on('click',function(){
		$(location).attr('href','mypage');
	});
	
	
})

</script>

<style>

.star-rating {
  display: flex;
  flex-direction: row-reverse;
  font-size: 2.25rem;
  line-height: 2.5rem;
  justify-content: space-around;
  padding: 0 0.2em;
  text-align: center;
  width: 5em;
}
 
.star-rating input {
  display: none;
}
 
.star-rating label {
  -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
  -webkit-text-stroke-width: 2.3px;
  -webkit-text-stroke-color: #2b2a29;
  cursor: pointer;
}
 
.star-rating :checked ~ label {
  -webkit-text-fill-color: gold;
}
 
.star-rating label:hover,
.star-rating label:hover ~ label {
  -webkit-text-fill-color: #fff58c;
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
	
	
	
body{
	padding:100px;
}	
	
	textarea{
	border-radius: .25rem;
	border-color: #bbb;
	width: 300px;
	height: 150px;
	margin: 10px;
}

	.box{
		display:flex;
		
		align-items: center;
	}
	
	.backImg{
		width:300px;
		height: auto;
		background-size:cover;
		background: no-repeat;
	}
	
</style>
</head>

<body>
<h1>리뷰페이지</h1>
<form action="review_insert">


<div class="box">
<c:if test="${air != null}">
	<div class="backImg" >
	<h3>${air.airName}</h3>

	<img src="${air.airImage}" style="max-width: 100%; height: auto;"> 
	</div>
	<div>
	<div class="star-rating space-x-4 mx-auto">
	<input type="radio" id="air5-stars" name="air_star" value="5" checked="true" v-model="ratings"/>
	<label for="air5-stars" class="star pr-4">★</label>
	<input type="radio" id="air4-stars" name="air_star" value="4" v-model="ratings"/>
	<label for="air4-stars" class="star">★</label>
	<input type="radio" id="air3-stars" name="air_star" value="3" v-model="ratings"/>
	<label for="air3-stars" class="star">★</label>
	<input type="radio" id="air2-stars" name="air_star" value="2" v-model="ratings"/>
	<label for="air2-stars" class="star">★</label>
	<input type="radio" id="air1-star" name="air_star" value="1" v-model="ratings" />
	<label for="air1-star" class="star">★</label>
	</div>
	<input type="text" name="airNo" value=${air.airNo} hidden="hidden">

	<textarea name="airContent" placeholder="리뷰를 작성하세요"></textarea>
	</div>
</c:if>
</div>

<div class="box">
<c:if test="${lodging != null}">


	<div class="backImg">
	<h3>${lodging.lodging_name}</h3>
	<img src="${lodging.lodging_image}" style="max-width: 100%; height: auto;"> 
	</div>
	
	<div>
		<div class="star-rating space-x-4 mx-auto">
	<input type="radio" id="room5-stars" name="room_star" value="5" checked = "true" v-model="ratings"/>
	<label for="room5-stars" class="star pr-4">★</label>
	<input type="radio" id="room4-stars" name="room_star" value="4" v-model="ratings"/>
	<label for="room4-stars" class="star">★</label>
	<input type="radio" id="room3-stars" name="room_star" value="3" v-model="ratings"/>
	<label for="room3-stars" class="star">★</label>
	<input type="radio" id="room2-stars" name="room_star" value="2" v-model="ratings"/>
	<label for="room2-stars" class="star">★</label>
	<input type="radio" id="room1-star" name="room_star" value="1" v-model="ratings" />
	<label for="room1-star" class="star">★</label>
	</div>
	
		<input type="text" name="roomNo" value="${lodging.lodging_no}" hidden="hidden">
	<textarea name="roomContent" placeholder="리뷰를 작성하세요"></textarea>
	</div>
</c:if>
</div>

<div class="box">
<c:if test="${car != null}">
	<div class="backImg" >
	<h3>${car.car_name}</h3>
	<img src="${car.car_image}" style="max-width: 100%; height: auto;"> 
	</div>
	<div>
	
	<div class="star-rating space-x-4 mx-auto">
	<input type="radio" id="car5-stars" name="car_star" value="5" checked = "true" v-model="ratings"/>
	<label for="car5-stars" class="star pr-4">★</label>
	<input type="radio" id="car4-stars" name="car_star" value="4" v-model="ratings"/>
	<label for="car4-stars" class="star">★</label>
	<input type="radio" id="car3-stars" name="car_star" value="3" v-model="ratings"/>
	<label for="car3-stars" class="star">★</label>
	<input type="radio" id="car2-stars" name="car_star" value="2" v-model="ratings"/>
	<label for="car2-stars" class="star">★</label>
	<input type="radio" id="car1-star" name="car_star" value="1" v-model="ratings" />
	<label for="car1-star" class="star">★</label>
	</div>
		<input type="text" name="carNo" value=${car.car_no} hidden="hidden">
	<textarea name="carContent" placeholder="리뷰를 작성하세요"></textarea>
	</div>
</c:if>
</div>


<input type="submit" value="등록" class="btn btn_p">
<input type="button" value="취소" class="btn btn_cancle">
</form>
</body>
</html>
