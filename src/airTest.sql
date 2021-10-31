create sequence airlineSeq;
create sequence airReserveSeq;
create sequence airReviewSeq;
create sequence mem_seq;

insert into airline values(airlineSeq.nextval, '대한항공', 50000, '서울', '오전', 'img/air/korea.jpg');
insert into airline values(airlineSeq.nextval, '아시아나항공', 48000, '인천', '오전', 'img/air/asiana.png');
insert into airline values(airlineSeq.nextval, '부산항공', 45000, '부산', '오전', 'img/air/busan.png');
insert into airline values(airlineSeq.nextval, '제주항공', 50000, '김포', '오전', 'img/air/jeju.jpg');
insert into airline values(airlineSeq.nextval, '에어부산', 50000, '김해', '오전', 'img/air/busan.png');
insert into airline values(airlineSeq.nextval, '에어포항', 50000, '포항', '오전', 'img/air/airpohang.png');
insert into airline values(airlineSeq.nextval, '진에어', 50000, '인천', '오전', 'img/air/jinair.jpg');
insert into airline values(airlineSeq.nextval, '티웨이항공', 50000, '김포', '오전', 'img/air/tway.png');
insert into airline values(airlineSeq.nextval, '이스타', 50000, '청주', '오전', 'img/air/estar.png');
select * from car_reserve
select * from airline;
select * from air_review;
select * from air_reserve;

select air_no, avg(air_horoscope) as horoscope from air_review
where air_no = 2 group by air_no;

insert into member values (999, 'abc', '1234', 'hong', '닭', '병아리', '01011112222', 'abc@naver.com')
select * from member;

insert into RESERVATION values (1001, 999, SYSDATE-90, SYSDATE-87, 0, '다녀옴', null, null, null)
insert into RESERVATION values (1002, 999, SYSDATE-90, SYSDATE-88, 0, '취소', null, null, null)
insert into RESERVATION values (1003, 999, SYSDATE-40, SYSDATE-37, 0, '다녀옴', null, null, null)
insert into RESERVATION values (1004, 999, SYSDATE+20, SYSDATE+23, 0, '예약', null, null, null)
insert into AIR_RESERVE values(airReserveSeq.nextval, '오전', '오전', 3, 3)
insert into AIR_RESERVE values(airReserveSeq.nextval, '오전', '오전', 3, 7)
select * from RESERVATION
delete from reservation


update RESERVATION set air_reserve_no = 4 where reserve_no = 1003;
update RESERVATION set air_reserve_no = 6 where reserve_no = 1004;
update RESERVATION set air_reserve_no = 7 where reserve_no = 1001;

select max(air_reserve_no) as num from air_reserve;
select max(reserve_no) as num from RESERVATION;

select distinct air_reserve_no from RESERVATION 
where member_no = 999 and air_reserve_no is not null;

select air_no from RESERVATION r, AIR_RESERVE ar
where r.reserve_no = ar.reserve_no AND member_no = 999;

DROP TABLE RESERVATION 
	CASCADE CONSTRAINTS;
/* 항공예약 */
DROP TABLE AIR_RESERVE 
	CASCADE CONSTRAINTS;

/* 숙소예약 */
DROP TABLE LODGING_RESERVE 
	CASCADE CONSTRAINTS;

/* 렌트카예약 */
DROP TABLE CAR_RESERVE 
	CASCADE CONSTRAINTS;
/* 예약정보 */
CREATE TABLE RESERVATION (
	reserve_no NUMBER NOT NULL, /* 예약번호 */
	member_no NUMBER, /* 회원번호 */
	start_day DATE, /* 출발일 */
	end_day DATE, /* 도착일 */
	total_price NUMBER, /* 새 컬럼 */
	total_state VARCHAR2(30), /* 예약상태 */
	air_reserve_no NUMBER, /* 항공예약번호 */
	room_reserve_no NUMBER, /* 숙소예약번호 */
	car_reserve_no NUMBER /* 렌트카예약번호 */
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
/* 항공예약 */
CREATE TABLE AIR_RESERVE (
	air_reserve_no NUMBER NOT NULL, /* 항공예약번호 */
	take_off VARCHAR2(10), /* 항공가는시간 */
	landing VARCHAR2(10), /* 항공오는시간 */
	personnel NUMBER, /* 인원 */
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

/* 숙소예약 */
CREATE TABLE LODGING_RESERVE (
	room_reserve_no NUMBER NOT NULL, /* 숙소예약번호 */
	check_in VARCHAR2(10), /* 체크인 */
	check_out VARCHAR2(10), /* 체크아웃 */
	lodging_no NUMBER /* 숙소번호 */
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

/* 렌트카예약 */
CREATE TABLE CAR_RESERVE (
	car_reserve_no NUMBER NOT NULL, /* 렌트카예약번호 */
	borrow_car VARCHAR2(10), /* 렌트카대여시간 */
	return_car VARCHAR2(10), /* 렌트카반납시간 */
	car_no NUMBER /* 차량번호 */
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

alter table lodging add lodging_price number;

