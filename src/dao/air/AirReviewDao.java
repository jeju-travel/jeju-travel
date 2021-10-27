package dao.air;

import java.util.List;

public interface AirReviewDao {
	
	void insert(String writer, String airContent, int airHoroscope, int airNo);
	
	List<Integer> check_member(int memberNo);

}
