package dao.Lodginguser;

import java.util.List;

import model.Lodging.Lodgingadmin;

public interface lodgingDaouser {
	//검색하기
	List<Lodgingadmin> selectAll();
	//찾아서 출력
	Lodgingadmin selectBylodging_no(int lodging_no);
}
