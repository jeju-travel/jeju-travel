package knh.dao;

import java.util.List;

import knh.model.Airline;

public class Test {

	public static void main(String[] args) {

		AirlineDao dao = new AirlineDaoImpl();
		Airline airline = new Airline("�λ��װ�", 45000, "�λ�", "����");
		
		//dao.insert(airline);
		//dao.update("�ƽþƳ��װ�", 48000, "��õ", "����", 2);
		System.out.println(dao.selectByNo(2).toString());
		
		List<Airline> airList = dao.selectAll();
		for (Airline airline2 : airList) {
			System.out.println(airline2.toString());
		}
		
	}

}
