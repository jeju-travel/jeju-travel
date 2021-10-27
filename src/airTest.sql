create sequence airlineSeq;
create sequence airReserveSeq;
create sequence airReviewSeq;

insert into airline values(airlineSeq.nextval, '�����װ�', 50000, '����', '����', null)
insert into airline values(airlineSeq.nextval, '�̽�Ÿ', 50000, 'û��', '����', null)

select * from airline;
select * from air_review;
select * from air_reserve;

select air_no, avg(air_horoscope) as horoscope from air_review
where air_no = 2 group by air_no;

insert into member values (999, 'abc', '1234', 'hong', '��', '���Ƹ�', '01011112222', 'abc@naver.com')
select * from member;

insert into RESERVATION values (1001, 999, SYSDATE-90, SYSDATE-87, 0, '�ٳ��', null, null, null)
insert into RESERVATION values (1002, 999, SYSDATE-90, SYSDATE-88, 0, '���', null, null, null)
insert into RESERVATION values (1003, 999, SYSDATE-40, SYSDATE-37, 0, '�ٳ��', null, null, null)
insert into RESERVATION values (1004, 999, SYSDATE+20, SYSDATE+23, 0, '����', null, null, null)
insert into AIR_RESERVE values(airReserveSeq.nextval, '����', '����', 2, 3)
select * from RESERVATION

update RESERVATION set air_reserve_no = 4 where reserve_no = 1003;
update RESERVATION set air_reserve_no = 9 where reserve_no = 1004;

select distinct air_reserve_no from RESERVATION 
where member_no = 999 and air_reserve_no is not null;

select air_no from RESERVATION r, AIR_RESERVE ar
where r.reserve_no = ar.reserve_no AND member_no = 999;

DROP TABLE RESERVATION 
	CASCADE CONSTRAINTS;
/* �װ����� */
DROP TABLE AIR_RESERVE 
	CASCADE CONSTRAINTS;

/* ���ҿ��� */
DROP TABLE LODGING_RESERVE 
	CASCADE CONSTRAINTS;

/* ��Ʈī���� */
DROP TABLE CAR_RESERVE 
	CASCADE CONSTRAINTS;
/* �������� */
CREATE TABLE RESERVATION (
	reserve_no NUMBER NOT NULL, /* �����ȣ */
	member_no NUMBER, /* ȸ����ȣ */
	start_day DATE, /* ����� */
	end_day DATE, /* ������ */
	total_price NUMBER, /* �� �÷� */
	total_state VARCHAR2(30), /* ������� */
	air_reserve_no NUMBER, /* �װ������ȣ */
	room_reserve_no NUMBER, /* ���ҿ����ȣ */
	car_reserve_no NUMBER /* ��Ʈī�����ȣ */
);

CREATE UNIQUE INDEX PK_RESERVATION
	ON RESERVATION (
		reserve_no ASC
	);

ALTER TABLE RESERVATION
	ADD
		CONSTRAINT PK_RESERVATION
		PRIMARY KEY (
			reserve_no
		);
/* �װ����� */
CREATE TABLE AIR_RESERVE (
	air_reserve_no NUMBER NOT NULL, /* �װ������ȣ */
	take_off VARCHAR2(10), /* �װ����½ð� */
	landing VARCHAR2(10), /* �װ����½ð� */
	personnel NUMBER, /* �ο� */
	air_no NUMBER /* ������ȣ */
);

CREATE UNIQUE INDEX PK_AIR_RESERVE
	ON AIR_RESERVE (
		air_reserve_no ASC
	);

ALTER TABLE AIR_RESERVE
	ADD
		CONSTRAINT PK_AIR_RESERVE
		PRIMARY KEY (
			air_reserve_no
		);

/* ���ҿ��� */
CREATE TABLE LODGING_RESERVE (
	room_reserve_no NUMBER NOT NULL, /* ���ҿ����ȣ */
	check_in VARCHAR2(10), /* üũ�� */
	check_out VARCHAR2(10), /* üũ�ƿ� */
	lodging_no NUMBER /* ���ҹ�ȣ */
);

CREATE UNIQUE INDEX PK_LODGING_RESERVE
	ON LODGING_RESERVE (
		room_reserve_no ASC
	);

ALTER TABLE LODGING_RESERVE
	ADD
		CONSTRAINT PK_LODGING_RESERVE
		PRIMARY KEY (
			room_reserve_no
		);

/* ��Ʈī���� */
CREATE TABLE CAR_RESERVE (
	car_reserve_no NUMBER NOT NULL, /* ��Ʈī�����ȣ */
	borrow_car VARCHAR2(10), /* ��Ʈī�뿩�ð� */
	return_car VARCHAR2(10), /* ��Ʈī�ݳ��ð� */
	car_no NUMBER /* ������ȣ */
);

CREATE UNIQUE INDEX PK_CAR_RESERVE
	ON CAR_RESERVE (
		car_reserve_no ASC
	);

ALTER TABLE CAR_RESERVE
	ADD
		CONSTRAINT PK_CAR_RESERVE
		PRIMARY KEY (
			car_reserve_no
		);


