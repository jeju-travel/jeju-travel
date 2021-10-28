package dao.air;

import model.air.AirReserve;

public interface AirReserveDao {

	void insert(String takeOff, String landing, int personnel, int airNo);
	
	int recentAirReserve();
	AirReserve selectByNo(int reserveNo);
}
