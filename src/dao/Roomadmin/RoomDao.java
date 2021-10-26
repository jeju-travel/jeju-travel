package dao.Roomadmin;

import java.util.List;

import lodging.model.Roomadmin;

public interface RoomDao {
	//추가
	void insert(Roomadmin roomadmin);
	//리스트
	List<Roomadmin> selectAll();
	//수정
	/*void update(Roomadmin roomadmin);*/
	//삭제
	/*void delete(Roomadmin roomadmin);
	Roomadmin selectByroom_no(int room_no);*/
}
