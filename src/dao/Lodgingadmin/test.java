package dao.Lodgingadmin;

import java.sql.Connection;
import java.util.List;

import dao.Lodgingadmin.JDBCUtil;
import lodging.model.Lodgingadmin;

public class test {

	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		
		LodgingDao lodgingDao = new LodgingDaoImpl();
		Lodgingadmin lodging = new Lodgingadmin();
		
		//insert
		/*lodging.setLodging_name("오션뷰제주");
		lodging.setLodging_loc("제주 특별시");
		lodging.setLodging_phone("010-2222-3333");
		lodging.setLodging_image(null);
		System.out.println("잘 저장되었습니다.");
		lodgingDao.insert(lodging);*/
		
		//list
		/*List<Lodging> lodgingList = lodgingDao.selectAll();
		for (Lodging lodging2 : lodgingList) {
	         System.out.println(lodging2.toString());
	    }
		System.out.println("출력되었습니다.");*/
		
		
		
		//update
		/*lodging.setLodging_name("숙소테스트수정");
		lodging.setLodging_loc("제주수정");
		lodging.setLodging_phone("010-1111-1111");
		lodging.setLodging_image(null);
		lodging.setLodging_no(81);
		System.out.println("잘 수정되었습니다.");
		lodgingDao.update(lodging);*/
		
		//delete
		/*lodgingDao.delete(64);
		System.out.println("삭제되었습니다.");*/
		
		//selectbylodging_no
		lodging = lodgingDao.selectBylodging_no(50);
		System.out.println("출력되었습니다.");
		
		JDBCUtil.close(null, null, connection);
		
	}

}
