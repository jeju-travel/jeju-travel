select * from reservation where member_no = 1

select * from member

select * from RESERVATION

select * from reserve_admin


insert into RESERVE_ADMIN values(1,'관리자','admin','1234')


--시퀀스(예약, 멤버)
create sequence mem_seq
create sequence res_seq


update RESERVATION set state='예약확인' where reserve_no = 7
insert into RESERVATION values (res_seq.nextval, 6, sysdate, sysdate, '예약확인')
insert into RESERVATION values (res_seq.nextval, 6, sysdate, sysdate, '예약취소')







select reserve_no, member_no, TO_CHAR(start_day, 'YYYY.MM.DD') AS start_day, TO_CHAR(end_day, 'YY.MM.DD') AS end_day, state  from reservation where member_no = 1

select * from RESERVATION where reserve_no =1 

select * from CAR_RESERVE
insert into CAR_RESERVE values (1,'1','1',8,null)
insert into CAR_RESERVE (car_reserve_no, reserve_no) values (2,1)

select * from AIR_RESERVE
insert into AIR_RESERVE values (1,'1','0',8,null)

select * from ROOM_RESERVE
insert into ROOM_RESERVE values (1,'1','1',8,null)

select air_no from RESERVATION r inner join AIR_RESERVE a on r.reserve_no = a.reserve_no where r.reserve_no = 1

select a.air_no, c.car_no, room.room_no from reservation r 
join AIR_RESERVE a on
r.reserve_no = a.reserve_no
inner join CAR_RESERVE c on
r.reserve_no = c.reserve_no 
inner join ROOM_RESERVE room on 
r.reserve_no = room.reserve_no
where r.reserve_no = 7

select * from car where car_no = 4
update car set car_image = 'img/sonata.jpg' where car_no = 4

select * from ROOM_RESERVE

select air_no, car_no from AIR_RESERVE a inner join reservation r on r.reserve_no = a.reserve_no inner join CAR_RESERVE c on
r.reserve_no = c.reserve_no where r.reserve_no = 7
select room_no from reservation r inner join ROOM_RESERVE room on r.reserve_no = room.reserve_no where r.reserve_no = 7

select * from RESERVATION