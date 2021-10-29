package dao.air;

import java.util.List;

import model.air.Airline;

public interface AirlineDao {
	
	void insert(Airline airline);
	void update(String airName, int price, String airLoc, String takeOff, String airImage, int airNo);
	void delete(int airNo);
	
	List<Airline> selectAll();
	Airline selectByNo(int airNo);

}
