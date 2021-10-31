select * from reservation where member_no = 1

create sequence airReviewSeq
create sequence Seq

select * from RESERVation

select * from RESERVATION
select * from LODGING
select * from LODGING_RESER
update RESERVATION set total_state = '예약확인' where reserve_no = 213
select * from CAR_RESERVE where car_reserve_no = 75
select * from car where car_no = 1
select * from car
delete RESERVATION where reserve_no = 212
select * 

select max(room_reserve_no) as num from lodging_reserve


select * from LODGING_RESERVE

select * from LODGING_RESERVE
insert into Lodging_RESERVE (room_reserve_no, check_in, check_out, lodging_no) values (seqlodging_res_no, '오전' , '오전', 21)

select * from LODGING
select * from LODGING_RESERVE
select * from LODGING_RESERVE where room_reserve_no = 15

insert into Lodging_RESERVE values(seqlodging_res_no.nextval, '오전' , '오전', 21)
insert into Lodging_RESERVE values (, '오전', '오전', 21)

delete LODGING_RESERVE
select * from LODGING_RESERVE

select * from RESERVATION 
update RESERVATION set room_reserve_no = ? where reserve_no = ?

create sequence seq_car_review_no

select * from RESERVATION
--review 
select * from CAR_REVIEW
select * from AIR_REVIEW
select * from LODGING_REVIEW

select * from LODGING_RESERVE

select * from member

select * from reserve_admin

insert into RESERVE_ADMIN values(1,'root','root','1234')

select * from RESERVATION

select * from reserve_admin

select * from AIRLINE
select * from car

select * from car_reserve ar inner join car a on a.car_no = ar.car_no

insert into RESERVE_ADMIN values(1,'관리자','admin','1234')

select * from room
select * from LODGING

select * from lodging where lodging_no = (select lodging_no from room where room_no = 4)


select * from RESERVATION

update RESERVATION

select lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_image from lodging where lodging_no=1

--시퀀스(예약, 멤버)
create sequence mem_seq
create sequence res_seq

insert into RESERVATION values (res_seq.nextval, 7, sysdate, sysdate, 0, '예약', null, null, null)

select * from AIR_RESERVE
select * from airline where air_no = 24
select * from RESERVATION  where air_reserve_no = 4
delete from RESERVATION where car_reserve_no = 1
update RESERVATION set air_rserve_no=6 where reserve_no = 9
insert into RESERVATION values (res_seq.nextval, 7, sysdate, sysdate, 100, '예약확인',4,1,1)
insert into RESERVATION values (res_seq.nextval, 7, sysdate, sysdate, 100, '예약확인',null,null,null)
insert into RESERVATION values (res_seq.nextval, 7, sysdate, sysdate, 100, '예약취소',4,1,1)
select * from RESERVATION
select * from AIR_RESERVE
select * from CAR_RESERVE
select * from LODGING_REserve

select * from RESERVATION where reserve_no = 14

delete from RESERVATION

select * from LODGING

select air_name from air_reserve ar inner join airline a on a.air_no = ar.air_no where air_reserve_no = 4
select car_name from car_reserve ar inner join car a on a.car_no = ar.car_no where car_reserve_no = 1
select lodging_name from lodging_reserve ar inner join lodging a on a.lodging_no = ar.lodging_no where room_reserve_no = 1

select * from LODGING_REVIEW
create sequence lodging_seq

insert into LODGING_REVIEW values(lodging_seq.nextval, ?, ?, ?, ?)

select reserve_no, member_no, TO_CHAR(start_day, 'YYYY.MM.DD') AS start_day, TO_CHAR(end_day, 'YY.MM.DD') AS end_day, state  from reservation where member_no = 1

select * from RESERVATION where reserve_no =1 

select * from CAR_RESERVE
insert into CAR_RESERVE values (1,'오전','오후',5)
insert into CAR_RESERVE (car_reserve_no, reserve_no) values (2,1)

select * from AIR_RESERVE
insert into AIR_RESERVE values (1,'1','0',8,null)

select * from RESERVATION

select * from Lodging_RESERVE
insert into Lodging_RESERVE values (seq_lodging_res_no,?,?,?)

select air_no from RESERVATION r inner join AIR_RESERVE a on r.reserve_no = a.reserve_no where r.reserve_no = 1

select a.air_no, c.car_no, room.room_no from reservation r 
join AIR_RESERVE a on
r.reserve_no = a.reserve_no
inner join CAR_RESERVE c on
r.reserve_no = c.reserve_no 
inner join ROOM_RESERVE room on 
r.reserve_no = room.reserve_no
where r.reserve_no = 7

select * from room
select * from AIRLINE
select * from car where car_no = 4
update car set car_image = 'img/sonata.jpg' where car_no = 5
update AIRLINE set air_image = 'img/korea.jpg' where  air_no =5

select * from ROOM_RESERVE

select air_no, car_no from AIR_RESERVE a inner join reservation r on r.reserve_no = a.reserve_no inner join CAR_RESERVE c on
r.reserve_no = c.reserve_no where r.reserve_no = 7
select room_no from reservation r inner join ROOM_RESERVE room on r.reserve_no = room.reserve_no where r.reserve_no = 7

select * from RESERVATION

select * from airline where air_no = 4
select * from MEMBER
select * from AIRLINE
select * from LODGING
select * from car

select * from AIR_RESERVE
insert into AIR_RESERVE
insert into AIR_RESERVE values(airReserveSeq.nextval, '오전', '오전', 2, 5)

select reserve_no, member_no, TO_CHAR(start_day, 'YY.MM.DD') AS start_day, TO_CHAR(end_day, 'YY.MM.DD') AS end_day, total_price, total_state,  air_reserve_no, room_reserve_no, car_reserve_no from RESERVATION where member_no = 7

select reserve_no, member_no, TO_CHAR(start_day, 'YY.MM.DD') AS start_day, 
TO_CHAR(end_day, 'YY.MM.DD') AS end_day, total_price, total_state, air_reserve_no, room_reserve_no, car_reserve_no from RESERVATION where member_no = 1";