package dao.Lodgingadmin;

import java.util.List;

import model.Lodging.Lodgingadmin;

public interface LodgingDao {
	//추가
	void insert(Lodgingadmin lodging);
	//리스트
	List<Lodgingadmin> selectAll();
	//수정
	void update(Lodgingadmin lodging);
	//삭제
	void delete(int lodging_no);
	//아이디찾아서 리스트
	Lodgingadmin selectBylodging_no(int lodging_no);
	
}
