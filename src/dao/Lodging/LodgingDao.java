package dao.Lodging;

import java.util.List;

import model.Lodging;

public interface LodgingDao {
	//추가
	void insert(Lodging lodging);
	//리스트
	List<Lodging> selectAll();
	//수정
	void update(Lodging lodging);
	//삭제
	void delete(int lodging_no);
	//아이디찾아서 리스트
	Lodging selectBylodging_no(int lodging_no);
	
}
