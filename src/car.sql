------------------------------�ڵ��� db------------------------------------
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
--car ������
create sequence seq_car_no
drop sequence seq_car_no
--car select
select car_name,car_price,capacity,car_type,car_fuel from car where car_type ='������' and car_fuel='����';
select * from car order by car_no
select * from car where car_type ='������' and car_fuel='����';
select * from car where car_type = ? and car_fuel= ? ; 
--car insert
insert into car values(seq_car_no.nextval,?,?,?,?,?,?);
insert into car values(seq_car_no.nextval,'�ҳ�Ÿ','������',25000,5,'�ֹ���','����1�� 62,3��',null);
--car update
update car set car_name = ?,car_type =?,car_price=? ,capactiy = ?,car_fuel=?,car_loc=? where car_no=?;
update car set car_name ='�ƹݶ�',car_type ='������',car_price=30000 ,capacity = 4,car_fuel='����',car_loc='����2�� 52,3��' where car_no=22;
--car delete
delete from car where car_no = ?; 
delete from car where car_no = 43;  
--�� ����� ī��Ʈ
select COUNT(*) AS cnt from car
--------------------------------------------------------------------------
-------------------------------------��Ʈī ����--------------------------------------
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
insert into CAR_RESERVE values(seq_car_reserve_no.nextval,'����','����',2);
select max(car_reserve_no) as num from CAR_RESERVE
------------------------------------------------------------------------------
------------------------------------��Ʈ �ı� ����-------------------------------
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

insert into car_review values(seq_car_review_no.nextval,'s','����',2,1); 

select car.car_no,avg(car_horoscope) as car_horoscope
from car car, car_review car_review
where car.car_no = car_review.car_no
group by car.car_no

select to_date('2021-10-25','yyyy-mm-dd')-to_date('2021-10-26','yyyy-mm-dd') as cha from dual;
-------------------------------------------------------------------------

-----------------------------------���� db(�׽�Ʈ��)-----------------------------
create table RESERVATION(
	reserve_no number primary key,
	member_no number references MEMBER(member_no),
	start_day date not null,
	end_day date not null,
	state VARCHAR2(10) not null
);
drop table RESERVATION
insert into RESERVATION values(1,1,sysdate,sysdate,'����');

create sequence seq_reserve_no
drop sequence seq_reserve_no
insert into RESERVATION values(seq_reserve_no.nextval,1,sysdate,sysdate,'����');
select * from RESERVATION

update RESERVATION set car_reserve_no = ? where reserve_no = ?;

--------------------------------------------------------------
-------------------���� db���(�׽�Ʈ��) ------------------
create table MEMBER(
	member_no number primary key
);
drop table MEMBER;
select * from member;
insert into member values(1);
-------------------------------------------------
