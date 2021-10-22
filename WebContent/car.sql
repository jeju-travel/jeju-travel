------------------------------�ڵ��� db------------------------------------
create table car(
	car_no number primary key,
	car_name VARCHAR2(50) not null,
	car_type VARCHAR2(20) not null,
	car_price number not null,
	capactiy number not null,
	car_fuel VARCHAR2(50) not null,
	car_loc VARCHAR2(50) not null,
	car_img VARCHAR2(255)
);
 
drop table car
--car ������
create sequence seq_car_no
drop sequence seq_car_no
--car select
select car_name,car_price,capactiy,car_type,car_fuel from car where car_type ='������' and car_fuel='����';
select * from car
select * from car where car_type ='������' and car_fuel='����';
--car insert
insert into car values(seq_car_no.nextval,?,?,?,?,?,?);
insert into car values(seq_car_no.nextval,'�ҳ�Ÿ','������',25000,5,'�ֹ���','����1�� 62,3��');
--car update
update car set car_name = ?,car_type =?,car_price=? ,capactiy = ?,car_fuel=?,car_loc=? where car_no=?;
update car set car_name ='�ƹݶ�',car_type ='������',car_price=30000 ,capactiy = 4,car_fuel='����',car_loc='����2�� 52,3��' where car_no=2;
--car delete
delete from car where car_no = ?; 
delete from car where car_no = 21;  
--------------------------------------------------------------------------
-------------------------------------��Ʈī ����--------------------------------------
create table CAR_RESERVE(
	car_reserve_no number primary key,
	borrow_car VARCHAR2(10) not null,
	return_car VARCHAR2(10) not null,	
	reserve_no number references RESERVATION(reserve_no),
	car_no number references car(car_no)
);
drop table CAR_RESERVE

select * from CAR_RESERVE;
create sequence seq_car_reserve_no
drop sequence seq_car_reserve_no
insert into CAR_RESERVE values(seq_car_reserve_no.nextval,'����','����',1,1);
------------------------------------------------------------------------------
------------------------------------��Ʈ �ı� ����-------------------------------
create table car_review(
	car_review_no number primary key,
	car_content VARCHAR2(255) not null,
	car_horoscope number not null,
	car_reserve_no references CAR_RESERVE(car_reserve_no)  
);
drop table CAR_REVIEW
create sequence seq_car_review_no
drop sequence seq_car_review_no

select * from CAR_REVIEW
update car set content=?,scope=? where car_review_no=?;
delete from car where car_review_no = ?; 
insert into car_review values(seq_car_review_no.nextval,?,?,?);
-------------------------------------------------------------------------

-----------------------------------���� db-----------------------------
create table RESERVATION(
	reserve_no number primary key,
	member_no number references MEMBER(member_no),
	start_day date not null,
	end_day date not null,
	state VARCHAR2(10) not null
);
drop table RESERVATION
insert into RESERVATION values(1,1,sysdate,sysdate,'����');
--------------------------------------------------------------

-------------------���� db��� ------------------
create table MEMBER(
	member_no number primary key
);
drop table MEMBER;
insert into member values(1);
-------------------------------------------------