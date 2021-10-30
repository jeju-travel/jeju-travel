package dao.air;

import model.air.AirReserve;

public interface AirReserveDao {

	void insert(AirReserve airRes);
	void updateReservation(int resNo, int airResNo);
	
	int recentAirReserve();
	AirReserve selectByNo(int reserveNo);
}
