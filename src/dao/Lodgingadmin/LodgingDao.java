package dao.Lodgingadmin;

import java.util.List;

import model.Lodging.Lodgingadmin;

public interface LodgingDao {
	//추가
	void insert(Lodgingadmin lodgingadmin);
	//리스트
	List<Lodgingadmin> selectAll();
	//수정
	void update(Lodgingadmin lodgingadmin);
	//삭제
	void delete(int lodging_no);
	//이름검색
	List<Lodgingadmin> lodging_name(String lodging_name);
	
}
