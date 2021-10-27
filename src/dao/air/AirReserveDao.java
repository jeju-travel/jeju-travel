package dao.air;

public interface AirReserveDao {

	void insert(String takeOff, String landing, int personnel, int airNo);
}
