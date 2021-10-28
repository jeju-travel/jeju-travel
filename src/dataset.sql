--관리자
insert into RESERVE_ADMIN values(1,'root','root','1234')

--시퀀스
create sequence mem_seq;
create sequence res_seq;
create sequence airlineSeq;
create sequence airReserveSeq;
create sequence airReviewSeq;
create sequence seq_car_no;
create sequence seq_car_reserve_no
create sequence seq_car_review_no
create sequence seqlodging_no;

--항공 데이터
insert into airline values(airlineSeq.nextval, '대한항공', 50000, '서울', '오전', 'img/air/korea.jpg');
insert into airline values(airlineSeq.nextval, '아시아나항공', 48000, '인천', '오전', 'img/air/asiana.png');
insert into airline values(airlineSeq.nextval, '부산항공', 45000, '부산', '오전', 'img/air/busan.png');
insert into airline values(airlineSeq.nextval, '제주항공', 50000, '김포', '오전', 'img/air/jeju.jpg');
insert into airline values(airlineSeq.nextval, '에어부산', 50000, '김해', '오전', 'img/air/busan.png');
insert into airline values(airlineSeq.nextval, '에어포항', 50000, '포항', '오전', 'img/air/airpohang.png');
insert into airline values(airlineSeq.nextval, '진에어', 50000, '인천', '오전', 'img/air/jinair.jpg');
insert into airline values(airlineSeq.nextval, '티웨이항공', 50000, '김포', '오전', 'img/air/tway.png');
insert into airline values(airlineSeq.nextval, '이스타', 50000, '청주', '오전', 'img/air/estar.png');

--숙박 데이터
insert into lodging values(seqlodging_no.nextval,'리젠트마린','제주도','032-2222-3333',3000,'jsp/image/RegentMarine.jpg');
insert into lodging values(seqlodging_no.nextval,'그랜드하얏트제주','제주도 서귀포','032-1111-2222',9000,'jsp/image/GrandHyattJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'탐라스테이호텔제주','제주도 서귀포','032-2222-3333',10000,'jsp/image/TamnaStayHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'유탑유블레스호텔','제주도 제주','032-2222-3333',3000,'jsp/image/GrandHyattJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'호텔위드제주','제주도 제주','032-2222-3333',1000,'jsp/image/HotelwithJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'다인오세아노호텔','제주도서귀포','032-3333-3333',90000,'jsp/image/DyneOcenanoHotel.jpg');
insert into lodging values(seqlodging_no.nextval,'유니호텔제주','제주도 제주','032-2222-7777',7000,'jsp/image/UniHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'아스타호델','제주도 제주','032-1111-3333',1000,'jsp/image/HotelwithJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'제주칼호텔','제주도 제주','032-2222-3333',2000,'jsp/image/KalHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'제주마레보리조트','제주도 애월','032-2222-3333',1000,'jsp/image/JejuMarevoResort.jpg');
insert into lodging values(seqlodging_no.nextval,'우도사랑채민박','우도','032-2222-3333',1000,'jsp/image/UdoLovehousePension.jpg');
insert into lodging values(seqlodging_no.nextval,'스카이리더스호텔','제주도 제주 ','032-2222-3333',1000,'jsp/image/SkyLeadersHotel.jpg');

--렌트카 데이터
insert into car values(seq_car_no.nextval,'마티즈','경차',20000,4,'휘발유','제성1길 62,3층','img/car/matiz.png');
insert into car values(seq_car_no.nextval,'레이','경차',21000,4,'경유','제성1길 62,3층','img/car/ray.png');
insert into car values(seq_car_no.nextval,'k3','중형차',23000,5,'휘발유','제성1길 62,3층','img/car/k3.png');
insert into car values(seq_car_no.nextval,'k5','중형차',25000,5,'가솔린','제성1길 62,3층','img/car/k5.png');
insert into car values(seq_car_no.nextval,'k7','중형차',27000,5,'전기','제성1길 62,3층','img/car/k7.png');
insert into car values(seq_car_no.nextval,'그렌져','중형차',30000,5,'휘발유','제성1길 62,3층','img/car/grandeur.png');
insert into car values(seq_car_no.nextval,'아반떼','중형차',25000,5,'전기','제성1길 62,3층','img/car/avante.png');
insert into car values(seq_car_no.nextval,'아우디','중형차',33000,5,'휘발유','제성1길 62,3층','img/car/audi.png');
insert into car values(seq_car_no.nextval,'suv','중형차',31000,5,'휘발유','제성1길 62,3층','img/car/suv.png');
insert into car values(seq_car_no.nextval,'소나타','중형차',24000,5,'휘발유','제성1길 62,3층','img/car/sonata.jpg');
insert into car values(seq_car_no.nextval,'카니발','대형차',36000,9,'경유','제성1길 62,3층','img/car/carnival.png');
insert into car values(seq_car_no.nextval,'스타렉스','대형차',35000,9,'휘발유','제성1길 62,3층','img/car/starex.png');