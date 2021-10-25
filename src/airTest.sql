create sequence airlineSeq;

insert into airline values(airlineSeq.nextval, '대한항공', 50000, '서울', '오전', null)

insert into airline values(airlineSeq.nextval, '이스타', 50000, '청주', '오전', null)

select * from airline;
select * from air_review;
select * from air_reserve;

insert into member values (999, 'abc', '1234', 'hong', '닭', '병아리', '01011112222', 'abc@naver.com')
select * from member;

insert into RESERVATION values (1001, 999, SYSDATE-90, SYSDATE-87, '다녀옴')
insert into RESERVATION values (1002, 999, SYSDATE-90, SYSDATE-88, '취소')
insert into RESERVATION values (1003, 999, SYSDATE-40, SYSDATE-37, '다녀옴')
insert into RESERVATION values (1004, 999, SYSDATE+20, SYSDATE+23, '예약')
select * from RESERVATION

DROP TABLE AIR_RESERVE 
	CASCADE CONSTRAINTS;
	
CREATE TABLE AIR_RESERVE (
	ari_reserve_no NUMBER NOT NULL, /* 항공예약번호 */
	take_off VARCHAR2(10), /* 항공가는시간 */
	landing VARCHAR2(10), /* 항공오는시간 */
	personnel NUMBER, /* 인원 */
	reserve_no NUMBER, /* 예약번호 */
	air_no NUMBER /* 비행기번호 */
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
