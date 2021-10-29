--�������� Ȯ��--
select * from all_constraints where table_name='lodging';
--���� ������ �ִ� ���̺� Ȯ��--
SELECT TABLE_NAME FROM USER_TABLES;
--�⺻Ű ���� > alter table (���̺��) drop primary key;--

--Ȥ�� ����� ��� ���̺� ����--
drop table lodging;
drop table reserve_admin;
drop table member;
--������ ����--
drop sequence seqlodging_no;
drop sequence seqadmin_no;

--������ ���̺� ����--
create table reserve_admin(
	admin_no number primary key,
	admin_name varchar2(50),
	admin_id varchar2(80),
	admin_pw varchar2(80)
)

--������ ���̺� ������ ����--
create sequence seqadmin_no;

--������ ���̺� ��ȸ--
select * from RESERVE_ADMIN;

-- ���� ���̺� ����--
CREATE TABLE LODGING (
	lodging_no NUMBER primary key,
	lodging_name VARCHAR2(50) not null,
	lodging_loc VARCHAR2(80) not null,
	lodging_phone VARCHAR2(30) not null,
	lodging_price NUMBER not null,
	lodging_image VARCHAR2(255)
)
--�������̺� ������ ����--
create sequence seqlodging_no;
--�������̺�insert--
insert into lodging values(seqlodging_no.nextval,'����Ʈ����','���ֵ�','032-2222-3333',3000,'img/lodging/RegentMarine.jpg');
insert into lodging values(seqlodging_no.nextval,'�׷����Ͼ�Ʈ����','���ֵ� ������','032-1111-2222',9000,'img/lodging/GrandHyattJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'Ž������ȣ������','���ֵ� ������','032-2222-3333',10000,'img/lodging/TamnaStayHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'��ž������ȣ��','���ֵ� ����','032-2222-3333',3000,'img/lodging/GrandHyattJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'ȣ����������','���ֵ� ����','032-2222-3333',1000,'img/lodging/HotelwithJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'���ο����Ƴ�ȣ��','���ֵ�������','032-3333-3333',90000,'img/lodging/DyneOcenanoHotel.jpg');
insert into lodging values(seqlodging_no.nextval,'����ȣ������','���ֵ� ����','032-2222-7777',7000,'img/lodging/UniHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'�ƽ�Ÿȣ��','���ֵ� ����','032-1111-3333',1000,'img/lodging/HotelwithJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'����Įȣ��','���ֵ� ����','032-2222-3333',2000,'img/lodging/KalHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'���ָ���������Ʈ','���ֵ� �ֿ�','032-2222-3333',1000,'img/lodging/JejuMarevoResort.jpg');
insert into lodging values(seqlodging_no.nextval,'�쵵���ä�ι�','�쵵','032-2222-3333',1000,'img/lodging/UdoLovehousePension.jpg');
insert into lodging values(seqlodging_no.nextval,'��ī�̸�����ȣ��','���ֵ� ���� ','032-2222-3333',1000,'img/lodging/SkyLeadersHotel.jpg');
insert into lodging values(seqlodging_no.nextval,?,?,?,?,?);
--�������̺� (��ȣ �����)��ȸ--
select * from lodging order by lodging_no asc;
--�������̺�update--
update lodging set lodging_name=?,lodging_loc=?,lodging_phone=?,lodging_price=?,lodging_image=? where lodging_no=?;
update lodging set lodging_name='�����׽�Ʈ4',lodging_loc='����Ư����',lodging_phone='010-3333-6666',lodging_price=3000,lodging_image=null where lodging_no=81;
--���� ���̺�delete--
delete from lodging;
delete from lodging where lodging_no=41;
--���ҹ�ȣ�� ã��--
select lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_price,lodging_image from lodging where lodging_no=?;
select lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_price,lodging_image from lodging where lodging_no=21; 


--���ҿ��� ���̺� ����--
create table room_reserve(
	room_reserve_no number primary key,
	check_in varchar(10),
	check_out varchar(10),
	room_no number references room(room_no),
	reserve_no number references reservation(reserve_no)
)
--���ҿ��� ���̺� ������ ����--
create sequence seqroom_reserve_no;
--���ҿ��� ���̺� insert--
insert into room_reserve values(seqroom_reserve_no.nextval,'����','����',21,1);
insert into room_reserve values(seqroom_reserve_no.nextval,'����','����',21,null);
--���ҿ��� ���̺� ��ȸ--
select * from room_reserve;

--�����ı� ���̺� ����--
create table lodging_review(
	lodging_review_no number primary key,
	lodging_content varchar2(255),
	lodging_horoscope number,
	room_reserve_no number references room_reserve(room_reserve_no)
)
--�����ı� ���̺� ������ ����--
create sequence seqlodging_review_no;
--�����ı� ���̺� insert--
insert into lodging_review values(seqlodging_review_no.nextval,'�����ı�',5,1);
--�����ı� ���̺� ��ȸ--
select * from lodging_review;

--�������� ���̺�--
create table reservation(
	reserve_no number primary key,
	member_no number references member(member_no)
)
--������̺�--
create table member(
	member_no number primary key,
	id varchar2(80),
	pw varchar2(255)
)

--���� ���̺� ����--
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
--�������̺� ������ ����--
create sequence seqroom_no;
--���� ���̺� insert--
insert into room values(seqroom_no.nextval,?,?,?,?,?,?,?);
insert into room values(seqroom_no.nextval,'1����',20000,3,'�̱ۺ���','�������',null,'�̹���');
--���� ���̺� ��ȸ--
select * from room;
--���� ���̺� update--
update room set room_name=?,room_price=?,room_personnel=?,room_configuration=?,
room_service=?,lodging_no=?,room_image=? where room_no=?;
update room set room_name='�����',room_price=393939,room_personnel=3,room_configuration='',
room_service='',lodging_no=82,room_image=null where room_no=22;
--���� ���̺� delete--
delete from room where room_no=?;
--���� ��ȣ�� ã��--
select room_no,room_name,room_price,room_personnel,room_configuration,room_service,lodging_no,room_image from room
where room_no=?;
