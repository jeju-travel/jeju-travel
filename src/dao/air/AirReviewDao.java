package dao.air;

import java.util.List;

public interface AirReviewDao {
	
	void insert(String writer, String airContent, double airHoroscope, int airNo);
	void update(String content, double horoscope, int air_review_no);
	void delete(int airReviewNo);
	
	List<Integer> check_member(int memberNo);
	double avg_horoscope(int airNo);

}
