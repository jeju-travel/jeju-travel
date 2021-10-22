package knh.dao;

import java.util.List;

import knh.model.Airline;

public interface AirlineDao {
	
	void insert(Airline airline);
	void update(String airName, int price, String airLoc, String takeOff, int airNo);
	void delete();
	
	List<Airline> selectAll();
	Airline selectByNo(int airNo);

}
