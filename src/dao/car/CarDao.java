package dao.car;

import java.util.List;

import model.Car;
import model.CarReserve;
import model.CarReview;
public interface CarDao {
	void insert(Car car);
	
	void CarReserve(CarReserve carreserve);
	
	void CarReview(CarReview carreview);
	
	List<Car> CarselectAll();
	
	Car selectByCarno(int car_no);	
	/*
	//���̵� �ߺ�üũ�� �ʿ��� �޼ҵ�
	int selectCntById(String customer);
	
	Customer login(String id,String pwd);
	
	Customer selectBycustomerseq(long customerseq);
	void update(Customer customer);
	
	void writeinsert(Bbs bbs);
	
	List<Bbs> selectAll();
	
	List<Bbs> select_by_search(String search);
	
	void cntcount(String subject);
	
	Bbs selectbyno(int no);
	
	void bbsupdate(Bbs bbs);
	
	void bbsdelete(int no);*/
	
	
		
	
}
