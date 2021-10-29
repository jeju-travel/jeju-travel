package dao.Lodginguser;

import java.sql.Connection;
import java.util.List;

import util.JDBCUtil;
import dao.Lodgingadmin.LodgingDao;
import dao.Lodgingadmin.LodgingDaoImpl;
import model.Lodging.Lodgingadmin;

public class test {
	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		
		LodgingDao lodgingDao = new LodgingDaoImpl();
		Lodgingadmin lodgingadmin = new Lodgingadmin();
		
		//list
		List<Lodgingadmin> lodgingList = lodgingDao.selectAll();
		for (Lodgingadmin lodgingadmin2 : lodgingList) {
		     System.out.println(lodgingadmin2.toString());
		}
		System.out.println("출력되었습니다.");
		
		/*lodgingadmin = lodgingDao.lodging_name();
		System.out.println(lodgingadmin.toString());*/
		
		JDBCUtil.close(null, null, connection);
	}
	
}
