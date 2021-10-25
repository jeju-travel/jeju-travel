create sequence airlineSeq;

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
