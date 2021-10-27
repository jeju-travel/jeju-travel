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
	lodging_image VARCHAR2(255)
)
--숙소테이블 시퀀스 생성--
create sequence seqlodging_no;
--숙소테이블insert--
insert into lodging values(seqlodging_no.nextval,'제주','제주도','032-2222-3333','이미지');
insert into lodging values(seqlodging_no.nextval,?,?,?,?);
--숙소테이블 조회--
select * from LODGING;

select * from lodging where lodging_no = (select lodging_no from room where lodging_no = 4)


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
insert into room values(seqroom_no.nextval,'1번방',20000,3,'싱글베드','무료생수',21,'이미지');
insert into room values(seqroom_no.nextval,'1번방',20000,3,'싱글베드','무료생수',null,'이미지');
--객실 테이블 조회--
select * from room;
drop table room;

--객실예약 테이블 생성--
create table room_reserve(
	room_reserve_no number primary key,
	check_in varchar(10),
	check_out varchar(10),
	room_no number references room(room_no),
	reserve_no number references reservation(reserve_no)
)
--객실예약 테이블 시퀀스 생성--
create sequence seqroom_reserve_no;
--객실예약 테이블 insert--
insert into room_reserve values(seqroom_reserve_no.nextval,'오전','오후',21,1);
insert into room_reserve values(seqroom_reserve_no.nextval,'오전','오후',21,null);
--객실예약 테이블 조회--
select * from room_reserve;

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
