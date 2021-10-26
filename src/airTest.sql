create sequence airlineSeq;
create sequence airReserveSeq;
create sequence airReviewSeq;

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
insert into AIR_RESERVE values(airReserveSeq.nextval, '오전', '오전', 2, 1001, 3)
select * from RESERVATION

DROP TABLE AIR_RESERVE 
	CASCADE CONSTRAINTS;
	
CREATE TABLE AIR_RESERVE (
	air_reserve_no NUMBER NOT NULL, /* 항공예약번호 */
	take_off VARCHAR2(10), /* 항공가는시간 */
	landing VARCHAR2(10), /* 항공오는시간 */
	personnel NUMBER, /* 인원 */
	reserve_no NUMBER, /* 예약번호 */
	air_no NUMBER /* 비행기번호 */
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
	air_review_no NUMBER NOT NULL, /* 후기번호 */
	air_content VARCHAR2(255), /* 내용 */
	air_horoscope NUMBER, /* 별점 */
	air_reserve_no NUMBER /* 항공예약번호 */
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

