--제약조건 확인--
select * from all_constraints where table_name='lodging';
--현재 가지고 있는 테이블 확인--
SELECT TABLE_NAME FROM USER_TABLES;
--기본키 삭제 > alter table (테이블명) drop primary key;--

--혹시 변경될 경우 테이블 삭제--
drop table lodging;
drop table reserve_admin;
drop table member;
--시퀀스 삭제--
drop sequence seqlodging_no;
drop sequence seqadmin_no;

--관리자 테이블 생성--
create table reserve_admin(
	admin_no number primary key,
	admin_name varchar2(50),
	admin_id varchar2(80),
	admin_pw varchar2(80)
)

--관리자 테이블 시퀀스 생성--
create sequence seqadmin_no;

--관리자 테이블 조회--
select * from RESERVE_ADMIN;

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
insert into lodging values(seqlodging_no.nextval,'리젠트마린','제주도','032-2222-3333',3000,'img/lodging/RegentMarine.jpg');
insert into lodging values(seqlodging_no.nextval,'그랜드하얏트제주','제주도 서귀포','032-1111-2222',9000,'img/lodging/GrandHyattJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'탐라스테이호텔제주','제주도 서귀포','032-2222-3333',10000,'img/lodging/TamnaStayHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'유탑유블레스호텔','제주도 제주','032-2222-3333',3000,'img/lodging/GrandHyattJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'호텔위드제주','제주도 제주','032-2222-3333',1000,'img/lodging/HotelwithJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'다인오세아노호텔','제주도서귀포','032-3333-3333',90000,'img/lodging/DyneOcenanoHotel.jpg');
insert into lodging values(seqlodging_no.nextval,'유니호텔제주','제주도 제주','032-2222-7777',7000,'img/lodging/UniHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'아스타호델','제주도 제주','032-1111-3333',1000,'img/lodging/HotelwithJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'제주칼호텔','제주도 제주','032-2222-3333',2000,'img/lodging/KalHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'제주마레보리조트','제주도 애월','032-2222-3333',1000,'img/lodging/JejuMarevoResort.jpg');
insert into lodging values(seqlodging_no.nextval,'우도사랑채민박','우도','032-2222-3333',1000,'img/lodging/UdoLovehousePension.jpg');
insert into lodging values(seqlodging_no.nextval,'스카이리더스호텔','제주도 제주 ','032-2222-3333',1000,'img/lodging/SkyLeadersHotel.jpg');
insert into lodging values(seqlodging_no.nextval,?,?,?,?,?);
--숙소테이블 (번호 순대로)조회--
select * from lodging order by lodging_no asc;
--숙소테이블update--
update lodging set lodging_name=?,lodging_loc=?,lodging_phone=?,lodging_price=?,lodging_image=? where lodging_no=?;
update lodging set lodging_name='숙소테스트4',lodging_loc='제주특별시',lodging_phone='010-3333-6666',lodging_price=3000,lodging_image=null where lodging_no=81;
--숙소 테이블delete--
delete from lodging;
delete from lodging where lodging_no=41;
--숙소번호로 찾기--
select lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_price,lodging_image from lodging where lodging_no=?;
select lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_price,lodging_image from lodging where lodging_no=21; 


--숙소예약 테이블 생성--
create table room_reserve(
	room_reserve_no number primary key,
	check_in varchar(10),
	check_out varchar(10),
	room_no number references room(room_no),
	reserve_no number references reservation(reserve_no)
)
--숙소예약 테이블 시퀀스 생성--
create sequence seqroom_reserve_no;
--숙소예약 테이블 insert--
insert into room_reserve values(seqroom_reserve_no.nextval,'오전','오후',21,1);
insert into room_reserve values(seqroom_reserve_no.nextval,'오전','오후',21,null);
--숙소예약 테이블 조회--
select * from room_reserve;

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
select * from lodging;

--별점--
insert into lodging_review values(seqlodging_review_no.nextval,'s','내용',2,81);
insert into lodging_review values(seqlodging_review_no.nextval,'z','내용',3,82);
insert into lodging_review values(seqlodging_review_no.nextval,'q','내용',2,83);

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

--객실 테이블 생성--
create table room(
	room_no number primary key,
	room_name varchar2(50) not null,
	room_price number not null,
	room_personnel number not null,
	room_configuration varchar2(255),
	room_service varchar2(255),
	lodging_no number references lodging(lodging_no),
	room_image varchar2(255)
)
--객실테이블 시퀀스 생성--
create sequence seqroom_no;
--객실 테이블 insert--
insert into room values(seqroom_no.nextval,?,?,?,?,?,?,?);
insert into room values(seqroom_no.nextval,'1번방',20000,3,'싱글베드','무료생수',null,'이미지');
--객실 테이블 조회--
select * from room;
--객실 테이블 update--
update room set room_name=?,room_price=?,room_personnel=?,room_configuration=?,
room_service=?,lodging_no=?,room_image=? where room_no=?;
update room set room_name='몇번방',room_price=393939,room_personnel=3,room_configuration='',
room_service='',lodging_no=82,room_image=null where room_no=22;
--객실 테이블 delete--
delete from room where room_no=?;
--객실 번호로 찾기--
select room_no,room_name,room_price,room_personnel,room_configuration,room_service,lodging_no,room_image from room
where room_no=?;
