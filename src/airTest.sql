create sequence airlineSeq;
create sequence airReserveSeq;
create sequence airReviewSeq;

insert into airline values(airlineSeq.nextval, '�����װ�', 50000, '����', '����', null)
insert into airline values(airlineSeq.nextval, '�̽�Ÿ', 50000, 'û��', '����', null)

select * from airline;
select * from air_review;
select * from air_reserve;

insert into member values (999, 'abc', '1234', 'hong', '��', '���Ƹ�', '01011112222', 'abc@naver.com')
select * from member;

insert into RESERVATION values (1001, 999, SYSDATE-90, SYSDATE-87, '�ٳ��')
insert into RESERVATION values (1002, 999, SYSDATE-90, SYSDATE-88, '���')
insert into RESERVATION values (1003, 999, SYSDATE-40, SYSDATE-37, '�ٳ��')
insert into RESERVATION values (1004, 999, SYSDATE+20, SYSDATE+23, '����')
<<<<<<< HEAD
insert into AIR_RESERVE values(airReserveSeq.nextval, '����', '����', 2, 1001, 3)
select * from RESERVATION

DROP TABLE AIR_RESERVE 
	CASCADE CONSTRAINTS;
	
CREATE TABLE AIR_RESERVE (
	air_reserve_no NUMBER NOT NULL, /* �װ������ȣ */
	take_off VARCHAR2(10), /* �װ����½ð� */
	landing VARCHAR2(10), /* �װ����½ð� */
	personnel NUMBER, /* �ο� */
	reserve_no NUMBER, /* �����ȣ */
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

DROP TABLE AIR_REVIEW 
	CASCADE CONSTRAINTS;
	
CREATE TABLE AIR_REVIEW (
	air_review_no NUMBER NOT NULL, /* �ı��ȣ */
	air_content VARCHAR2(255), /* ���� */
	air_horoscope NUMBER, /* ���� */
	air_reserve_no NUMBER /* �װ������ȣ */
);

CREATE UNIQUE INDEX PK_AIR_REVIEW
	ON AIR_REVIEW (
		air_review_no ASC
	);

ALTER TABLE AIR_REVIEW
	ADD
		CONSTRAINT PK_AIR_REVIEW
		PRIMARY KEY (
			air_review_no
		);
d


select * from AIR_RESERVE ar, AIRLINE a, AIR_REVIEW review
where ar.air_no = a.air_no AND ar.air_reserve_no = review.air_reserve_no;

select m.member_no as member_no, air_no, state 
from member m, reservation r, air_reserve ar 
where m.member_no = r.member_no AND r.reserve_no = ar.reserve_no
and m.member_no = 999

=======
select * from RESERVATION

DROP TABLE AIR_RESERVE 
	CASCADE CONSTRAINTS;
	
CREATE TABLE AIR_RESERVE (
	ari_reserve_no NUMBER NOT NULL, /* �װ������ȣ */
	take_off VARCHAR2(10), /* �װ����½ð� */
	landing VARCHAR2(10), /* �װ����½ð� */
	personnel NUMBER, /* �ο� */
	reserve_no NUMBER, /* �����ȣ */
	air_no NUMBER /* ������ȣ */
);

CREATE UNIQUE INDEX PK_AIR_RESERVE
	ON AIR_RESERVE (
		ari_reserve_no ASC
	);

ALTER TABLE AIR_RESERVE
	ADD
		CONSTRAINT PK_AIR_RESERVE
		PRIMARY KEY (
			ari_reserve_no
		);
>>>>>>> branch 'namho' of https://github.com/jeju-travel/jeju-travel.git
