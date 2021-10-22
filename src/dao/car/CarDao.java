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
	//아이디 중복체크시 필요한 메소드
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
