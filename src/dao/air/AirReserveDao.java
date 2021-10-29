package dao.air;

import model.air.AirReserve;

public interface AirReserveDao {

	void insert(String takeOff, String landing, int personnel, int airNo);
	void updateReservation(int resNo, int airResNo);
	
	int recentAirReserve();
	AirReserve selectByNo(int reserveNo);
}
