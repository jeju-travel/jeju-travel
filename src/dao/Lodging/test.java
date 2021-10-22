package dao.Lodging;

import java.sql.Connection;

import dao.Lodging.JDBCUtil;
import model.Lodging;

public class test {

	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		
		LodgingDao lodgingDao = new LodgingDaoImpl();
		
		//insert
		Lodging lodging = new Lodging();
		lodging.setLodging_name("오션제주");
		lodging.setLodging_loc("제주 특별시");
		lodging.setLodging_phone("010-1111-2222");
		lodging.setLodging_image(null);
		System.out.println("잘 저장되었습니다.");
		lodgingDao.insert(lodging);
		
		
		JDBCUtil.close(null, null, connection);
	}

}
