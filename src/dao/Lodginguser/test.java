package dao.Lodginguser;

import java.sql.Connection;
import java.util.List;

import dao.Lodgingadmin.JDBCUtil;
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
		System.out.println("��µǾ����ϴ�.");
		
		lodgingadmin = lodgingDao.selectBylodging_no(2);
		System.out.println(lodgingadmin.toString());
		
		JDBCUtil.close(null, null, connection);
	}
	
}
