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
	lodging_image VARCHAR2(255)
)
--�������̺� ������ ����--
create sequence seqlodging_no;
--�������̺�insert--
insert into lodging values(seqlodging_no.nextval,'����','���ֵ�','032-2222-3333','�̹���');
insert into lodging values(seqlodging_no.nextval,?,?,?,?);
--�������̺� ��ȸ--
select * from LODGING;

select * from lodging where lodging_no = (select lodging_no from room where lodging_no = 4)


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
insert into room values(seqroom_no.nextval,'1����',20000,3,'�̱ۺ���','�������',21,'�̹���');
insert into room values(seqroom_no.nextval,'1����',20000,3,'�̱ۺ���','�������',null,'�̹���');
--���� ���̺� ��ȸ--
select * from room;
drop table room;

--���ǿ��� ���̺� ����--
create table room_reserve(
	room_reserve_no number primary key,
	check_in varchar(10),
	check_out varchar(10),
	room_no number references room(room_no),
	reserve_no number references reservation(reserve_no)
)
--���ǿ��� ���̺� ������ ����--
create sequence seqroom_reserve_no;
--���ǿ��� ���̺� insert--
insert into room_reserve values(seqroom_reserve_no.nextval,'����','����',21,1);
insert into room_reserve values(seqroom_reserve_no.nextval,'����','����',21,null);
--���ǿ��� ���̺� ��ȸ--
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
