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