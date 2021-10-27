package dao.car;

import java.util.List;

import model.car.Car;
import model.car.CarReserve;
import model.car.CarReview;
import model.car.Carhoroscope;

public interface CarDao {
	void insert(Car car);
	
	void CarReserve(CarReserve carreserve);
	
	void CarReview(CarReview carreview);
	
	List<Car> CarselectAll();
	List<Car> selectAll(int requestPage);
	List<Car> CarselectAllprice();
	List<Car> Cartypefuel(String car_type,String car_fuel);
	List<Car> Cartype(String car_type);
	List<Car> Carfuel(String car_fuel);
	
	List<Carhoroscope> Carhoroscope();
	int cha(String end_day,String start_day);
	
	Car selectByCarno(int car_no);	
	
	void Carupdate(Car car);
	void Cardelete(int car_no);
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
