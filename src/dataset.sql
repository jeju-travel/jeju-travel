--������
insert into RESERVE_ADMIN values(1,'root','root','1234')

--������
create sequence mem_seq;
create sequence res_seq;
create sequence airlineSeq;
create sequence seq_car_no;
create sequence seqlodging_no;

--�װ� ������
insert into airline values(airlineSeq.nextval, '�����װ�', 50000, '����', '����', 'img/air/korea.jpg');
insert into airline values(airlineSeq.nextval, '�ƽþƳ��װ�', 48000, '��õ', '����', 'img/air/asiana.png');
insert into airline values(airlineSeq.nextval, '�λ��װ�', 45000, '�λ�', '����', 'img/air/busan.png');
insert into airline values(airlineSeq.nextval, '�����װ�', 50000, '����', '����', 'img/air/jeju.jpg');
insert into airline values(airlineSeq.nextval, '����λ�', 50000, '����', '����', 'img/air/busan.png');
insert into airline values(airlineSeq.nextval, '��������', 50000, '����', '����', 'img/air/airpohang.png');
insert into airline values(airlineSeq.nextval, '������', 50000, '��õ', '����', 'img/air/jinair.jpg');
insert into airline values(airlineSeq.nextval, 'Ƽ�����װ�', 50000, '����', '����', 'img/air/tway.png');
insert into airline values(airlineSeq.nextval, '�̽�Ÿ', 50000, 'û��', '����', 'img/air/estar.png');

--���� ������
insert into lodging values(seqlodging_no.nextval,'����Ʈ����','���ֵ�','032-2222-3333',3000,'jsp/image/RegentMarine.jpg');
insert into lodging values(seqlodging_no.nextval,'�׷����Ͼ�Ʈ����','���ֵ� ������','032-1111-2222',9000,'jsp/image/GrandHyattJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'Ž������ȣ������','���ֵ� ������','032-2222-3333',10000,'jsp/image/TamnaStayHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'��ž������ȣ��','���ֵ� ����','032-2222-3333',3000,'jsp/image/GrandHyattJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'ȣ����������','���ֵ� ����','032-2222-3333',1000,'jsp/image/HotelwithJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'���ο����Ƴ�ȣ��','���ֵ�������','032-3333-3333',90000,'jsp/image/DyneOcenanoHotel.jpg');
insert into lodging values(seqlodging_no.nextval,'����ȣ������','���ֵ� ����','032-2222-7777',7000,'jsp/image/UniHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'�ƽ�Ÿȣ��','���ֵ� ����','032-1111-3333',1000,'jsp/image/HotelwithJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'����Įȣ��','���ֵ� ����','032-2222-3333',2000,'jsp/image/KalHotelJeju.jpg');
insert into lodging values(seqlodging_no.nextval,'���ָ���������Ʈ','���ֵ� �ֿ�','032-2222-3333',1000,'jsp/image/JejuMarevoResort.jpg');
insert into lodging values(seqlodging_no.nextval,'�쵵���ä�ι�','�쵵','032-2222-3333',1000,'jsp/image/UdoLovehousePension.jpg');
insert into lodging values(seqlodging_no.nextval,'��ī�̸�����ȣ��','���ֵ� ���� ','032-2222-3333',1000,'jsp/image/SkyLeadersHotel.jpg');

--��Ʈī ������
insert into car values(seq_car_no.nextval,'��Ƽ��','����',20000,4,'�ֹ���','����1�� 62,3��','img/car/matiz.png');
insert into car values(seq_car_no.nextval,'����','����',21000,4,'����','����1�� 62,3��','img/car/ray.png');
insert into car values(seq_car_no.nextval,'k3','������',23000,5,'�ֹ���','����1�� 62,3��','img/car/k3.png');
insert into car values(seq_car_no.nextval,'k5','������',25000,5,'���ָ�','����1�� 62,3��','img/car/k5.png');
insert into car values(seq_car_no.nextval,'k7','������',27000,5,'����','����1�� 62,3��','img/car/k7.png');
insert into car values(seq_car_no.nextval,'�׷���','������',30000,5,'�ֹ���','����1�� 62,3��','img/car/grandeur.png');
insert into car values(seq_car_no.nextval,'�ƹݶ�','������',25000,5,'����','����1�� 62,3��','img/car/avante.png');
insert into car values(seq_car_no.nextval,'�ƿ��','������',33000,5,'�ֹ���','����1�� 62,3��','img/car/audi.png');
insert into car values(seq_car_no.nextval,'suv','������',31000,5,'�ֹ���','����1�� 62,3��','img/car/suv.png');
insert into car values(seq_car_no.nextval,'�ҳ�Ÿ','������',24000,5,'�ֹ���','����1�� 62,3��','img/car/sonata.jpg');
insert into car values(seq_car_no.nextval,'ī�Ϲ�','������',36000,9,'����','����1�� 62,3��','img/car/carnival.png');
insert into car values(seq_car_no.nextval,'��Ÿ����','������',35000,9,'�ֹ���','����1�� 62,3��','img/car/starex.png');