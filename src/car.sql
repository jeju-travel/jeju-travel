------------------------------자동차 db------------------------------------
create table car(
	car_no number primary key,
	car_name VARCHAR2(50) not null,
	car_type VARCHAR2(20) not null,
	car_price number not null,
	capacity number not null,
	car_fuel VARCHAR2(50) not null,
	car_loc VARCHAR2(50) not null,
	car_img VARCHAR2(255)
);
 
drop table car
--car 시퀀스
create sequence seq_car_no
drop sequence seq_car_no
--car select
select car_name,car_price,capacity,car_type,car_fuel from car where car_type ='중형차' and car_fuel='경유';
select * from car order by car_no
select * from car where car_type ='중형차' and car_fuel='경유';
select * from car where car_type = ? and car_fuel= ? ; 
--car insert
insert into car values(seq_car_no.nextval,?,?,?,?,?,?);
insert into car values(seq_car_no.nextval,'소나타','중형차',25000,5,'휘발유','제성1길 62,3층',null);
--car update
update car set car_name = ?,car_type =?,car_price=? ,capactiy = ?,car_fuel=?,car_loc=? where car_no=?;
update car set car_name ='아반떼',car_type ='중형차',car_price=30000 ,capacity = 4,car_fuel='전기',car_loc='제성2길 52,3층' where car_no=22;
--car delete
delete from car where car_no = ?; 
delete from car where car_no = 43;  
--총 몇개인지 카운트
select COUNT(*) AS cnt from car
--------------------------------------------------------------------------
-------------------------------------렌트카 예약--------------------------------------
create table CAR_RESERVE(
	car_reserve_no number primary key,
	borrow_car VARCHAR2(10) not null,
	return_car VARCHAR2(10) not null,	
	car_no number references car(car_no)
);
drop table CAR_RESERVE

select * from CAR_RESERVE;
create sequence seq_car_reserve_no
drop sequence seq_car_reserve_no
insert into CAR_RESERVE values(seq_car_reserve_no.nextval,'오전','오후',2);
select max(car_reserve_no) as num from CAR_RESERVE
------------------------------------------------------------------------------
------------------------------------렌트 후기 리뷰-------------------------------
create table car_review(
	car_review_no number primary key,
	writer VARCHAR2(80) not null,
	car_content VARCHAR2(255) not null,
	car_horoscope number not null,
	car_no references car(car_no)  
);
drop table CAR_REVIEW
create sequence seq_car_review_no
drop sequence seq_car_review_no

select * from CAR_REVIEW
update car set content=?,scope=? where car_review_no=?;
delete from car_review where car_review_no = ?; 
insert into car_review values(seq_car_review_no.nextval,?,?,?);

insert into car_review values(seq_car_review_no.nextval,'s','내용',2,1); 

select car.car_no,avg(car_horoscope) as car_horoscope
from car car, car_review car_review
where car.car_no = car_review.car_no
group by car.car_no

select to_date('2021-10-25','yyyy-mm-dd')-to_date('2021-10-26','yyyy-mm-dd') as cha from dual;
-------------------------------------------------------------------------

-----------------------------------예약 db(테스트용)-----------------------------
create table RESERVATION(
	reserve_no number primary key,
	member_no number references MEMBER(member_no),
	start_day date not null,
	end_day date not null,
	state VARCHAR2(10) not null
);
drop table RESERVATION
insert into RESERVATION values(1,1,sysdate,sysdate,'예약');

create sequence seq_reserve_no
drop sequence seq_reserve_no
insert into RESERVATION values(seq_reserve_no.nextval,1,sysdate,sysdate,'예약');
select * from RESERVATION
delete from  where reserve_no =143; 
update RESERVATION set end_day='2021-10-30' where reserve_no =161; 
update RESERVATION set car_reserve_no = ? where reserve_no = ?;
select * from lodging
insert into lodging_review values(seqlodging_review_no.nextval,'s','내용',2,21);
--------------------------------------------------------------
-------------------예약 db멤버(테스트용) ------------------
create table MEMBER(
	member_no number primary key
);
drop table MEMBER;
select * from member;
insert into member values(1);
-------------------------------------------------
