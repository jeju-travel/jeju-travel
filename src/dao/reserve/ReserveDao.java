package dao.reserve;

import java.util.List;

import model.Lodging.Lodgingadmin;
import model.Lodging.Room_reserve;
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
	//public Room_reserve selectRoomResByResNo(int resNo);
	
	public Airline selectAirByResNo(int resNo);
	
	public Car selectCarByResNo(int resNo);
	
	public Lodgingadmin selectRoomByResNo(int resNo);
	
}
