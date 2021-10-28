--제약조건 확인--
select * from all_constraints where table_name='lodging';
--현재 가지고 있는 테이블 확인--
SELECT TABLE_NAME FROM USER_TABLES;
--기본키 삭제 > alter table (테이블명) drop primary key;--

--관리자 테이블 생성--
create table reserve_admin(
	admin_no number primary key,
	admin_name varchar2(50),
	admin_id varchar2(80),
	admin_pw varchar2(80)
)
--관리자 테이블 시퀀스 생성--
create sequence seqadmin_no;

-- 숙소 테이블 생성--
CREATE TABLE LODGING (
	lodging_no NUMBER primary key,
	lodging_name VARCHAR2(50) not null,
	lodging_loc VARCHAR2(80) not null,
	lodging_phone VARCHAR2(30) not null,
	lodging_price NUMBER not null,
	lodging_image VARCHAR2(255)
)
--숙소테이블 시퀀스 생성--
create sequence seqlodging_no;
--숙소테이블insert--
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
insert into lodging values(seqlodging_no.nextval,?,?,?,?,?);
--숙소테이블 조회--
select * from LODGING order by lodging_no asc;

--숙소예약 테이블 생성--
create table lodging_reserve(
	lodging_reserve_no number primary key,
	check_in varchar(10),
	check_out varchar(10),
	lodging number references lodging(lodging_no)
)
--숙소예약 테이블 시퀀스 생성--
create sequence seqlodging_reserve_no;
--숙소예약 테이블 insert--
insert into lodging_reserve values(seqlodging_reserve_no.nextval,'오전','오후',2);
insert into lodging_reserve values(seqlodging_reserve_no.nextval,'오전','오후',1);
--숙소예약 테이블 조회--
select * from lodging_reserve;

--숙소후기 테이블 생성--
create table lodging_review(
	lodging_review_no number primary key,
	lodging_content varchar2(255),
	lodging_horoscope number,
	room_reserve_no number references room_reserve(room_reserve_no)
)
--숙소후기 테이블 시퀀스 생성--
create sequence seqlodging_review_no;
--숙소후기 테이블 insert--
insert into lodging_review values(seqlodging_review_no.nextval,'숙소후기',5,1);
--숙소후기 테이블 조회--
select * from lodging_review;

--예약정보 테이블--
create table reservation(
	reserve_no number primary key,
	member_no number references member(member_no)
)
--멤버테이블--
create table member(
	member_no number primary key,
	id varchar2(80),
	pw varchar2(255)
)
