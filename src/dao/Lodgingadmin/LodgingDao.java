package dao.Lodgingadmin;

import java.util.List;

import model.Lodging.Lodging_reserve;
import model.Lodging.Lodgingadmin;
import model.Lodging.Lodginghoroscope;

public interface LodgingDao {
	//추가
	void insert(Lodgingadmin lodgingadmin);
	void Reserveroominsert(Lodging_reserve lodging_reserve);
	//리스트
	List<Lodgingadmin> selectAll();
	//수정
	void update(Lodgingadmin lodgingadmin);
	//삭제
	void delete(int lodging_no);
	
	Lodgingadmin selectBylodging_no(int lodging_no);
	
	List<Lodginghoroscope> Lodginghoroscope();
	
	//이름검색
	List<Lodgingadmin> lodging_name(String lodging_name);
	
	int recentlodgingReserve();
}
