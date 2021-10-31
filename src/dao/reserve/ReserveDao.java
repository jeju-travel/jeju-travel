package dao.reserve;

import java.util.List;
import model.Lodging.Lodging_reserve;
import model.Lodging.Lodgingadmin;

import model.air.AirReserve;
import model.air.Airline;
import model.car.Car;
import model.car.CarReserve;
import model.manager.Reservation;

public interface ReserveDao {

	public List<Reservation> selectByMemNo(int memNo);
	
	public Reservation selectByResNo(int resNo);

	public int[] selectItemNoByResNo(int resNo);
	
	public void delete(int no);
	
	public String selectNameAirResNo(int airResNo);
	
	public String selectNameCarResNo(int carResNo);
	
	public String selectNameRoomResNo(int roomResNo);	
	
	
	public AirReserve selectAirResByResNo(int resNo);
	public CarReserve selectCarResByResNo(int resNo);
	public Lodging_reserve selectRoomResByResNo(int resNo);
	
	
	//public Room_reserve selectRoomResByResNo(int resNo);
	
	public Airline selectAirByResNo(int resNo);
	
	public Car selectCarByResNo(int resNo);
	
	public Lodgingadmin selectRoomByResNo(int resNo);
	
	public Airline selectAirByNo(int resNo);
	
	public Car selectCarByNo(int resNo);
	
	public Lodgingadmin selectRoomByNo(int resNo);
	
	public void updateResState(int resNo);


	//delete
	public void deleteAirRes(int airResNo);
	public void deleteLodgingRes(int lodgingResNo);
	public void deleteCarRes(int carResNo);
	public void deleteRes(int resNo);
	
	public void insert(int memberNo, String startDay, String endDay, int totalPrice ,int airNo, int roomNo, int carNo);
	
	public int recentReservation();
	
	//update
	public void updateAirResNo(int airResNo, int resNo);
	public void updateRoomResNo(int roomResNo, int resNo);
	public void updateCarResNo(int carResNo, int resNo);
	
	public void insertRoomRes(Lodging_reserve room);
	
	//최신상태
	int selectByNo();
	
	int selectByCarNo();
}
