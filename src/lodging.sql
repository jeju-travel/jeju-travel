--�������� Ȯ��--
select * from all_constraints where table_name='lodging';
--���� ������ �ִ� ���̺� Ȯ��--
SELECT TABLE_NAME FROM USER_TABLES;
--�⺻Ű ���� > alter table (���̺��) drop primary key;--

--������ ���̺� ����--
create table reserve_admin(
	admin_no number primary key,
	admin_name varchar2(50),
	admin_id varchar2(80),
	admin_pw varchar2(80)
)
--������ ���̺� ������ ����--
create sequence seqadmin_no;

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
insert into lodging values(seqlodging_no.nextval,'����Ʈ����','���ֵ�','032-2222-3333',3000,'jsp/image/RegentMarine.jpg');
insert into lodging values(seqlodging_no.nextval,'�׷����Ͼ�Ʈ����','���ֵ� ������','032-1111-2222',9000,'jsp/image/GrandHyattJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'Ž������ȣ������','���ֵ� ������','032-2222-3333',10000,'jsp/image/TamnaStayHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'��ž������ȣ��','���ֵ� ����','032-2222-3333',3000,'jsp/image/GrandHyattJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'ȣ����������','���ֵ� ����','032-2222-3333',1000,'jsp/image/HotelwithJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'���ο����Ƴ�ȣ��','���ֵ�������','032-3333-3333',90000,'jsp/image/DyneOcenanoHotel.jpg');
insert into lodging values(seqlodging_no.nextval,'����ȣ������','���ֵ� ����','032-2222-7777',7000,'jsp/image/UniHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'�ƽ�Ÿȣ��','���ֵ� ����','032-1111-3333',1000,'jsp/image/HotelwithJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'����Įȣ��','���ֵ� ����','032-2222-3333',2000,'jsp/image/KalHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'���ָ���������Ʈ','���ֵ� �ֿ�','032-2222-3333',1000,'jsp/image/JejuMarevoResort.jpg');
insert into lodging values(seqlodging_no.nextval,'�쵵���ä�ι�','�쵵','032-2222-3333',1000,'jsp/image/UdoLovehousePension.jpg');
insert into lodging values(seqlodging_no.nextval,'��ī�̸�����ȣ��','���ֵ� ���� ','032-2222-3333',1000,'jsp/image/SkyLeadersHotel.jpg');
insert into lodging values(seqlodging_no.nextval,?,?,?,?,?);
--�������̺� ��ȸ--
select * from LODGING order by lodging_no asc;

--���ҿ��� ���̺� ����--
create table lodging_reserve(
	lodging_reserve_no number primary key,
	check_in varchar(10),
	check_out varchar(10),
	lodging number references lodging(lodging_no)
)
--���ҿ��� ���̺� ������ ����--
create sequence seqlodging_reserve_no;
--���ҿ��� ���̺� insert--
insert into lodging_reserve values(seqlodging_reserve_no.nextval,'����','����',2);
insert into lodging_reserve values(seqlodging_reserve_no.nextval,'����','����',1);
--���ҿ��� ���̺� ��ȸ--
select * from lodging_reserve;

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
