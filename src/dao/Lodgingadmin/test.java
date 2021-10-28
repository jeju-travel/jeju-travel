package dao.Lodgingadmin;

import java.sql.Connection;
import java.util.List;


import model.Lodging.Lodgingadmin;
import util.JDBCUtil;

public class test {

	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		
		LodgingDao lodgingDao = new LodgingDaoImpl();
		Lodgingadmin lodgingadmin = new Lodgingadmin();
		
		//insert
		/*lodging.setLodging_name("오션뷰제주");
		lodgingadmin.setLodging_loc("제주 특별시");
		lodgingadmin.setLodging_phone("010-2222-3333");
		lodgingadmin.setLodging_image(null);
		System.out.println("잘 저장되었습니다.");
		lodgingDao.insert(lodgingadmin);*/
		
		//list
		List<Lodgingadmin> lodgingList = lodgingDao.selectAll();
		for (Lodgingadmin lodgingadmin2 : lodgingList) {
	         System.out.println(lodgingadmin2.toString());
	    }
		System.out.println("출력되었습니다.");
		
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
		/*lodgingadmin = lodgingDao.selectBylodging_no(2);
		System.out.println(lodgingadmin.toString());*/
		
		JDBCUtil.close(null, null, connection);
		
	}

}
