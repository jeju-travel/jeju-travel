package dao.Lodgingadmin;

import java.sql.Connection;
import java.util.List;


import model.Lodging.Lodgingadmin;
import util.JDBCUtil;

public class test {

	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		
		LodgingDao lodgingDao = new LodgingDaoImpl();
		Lodgingadmin lodging = new Lodgingadmin();
		
		//insert
		/*lodging.setLodging_name("���Ǻ�����");
		lodging.setLodging_loc("���� Ư����");
		lodging.setLodging_phone("010-2222-3333");
		lodging.setLodging_image(null);
		System.out.println("�� ����Ǿ����ϴ�.");
		lodgingDao.insert(lodging);*/
		
		//list
		/*List<Lodging> lodgingList = lodgingDao.selectAll();
		for (Lodging lodging2 : lodgingList) {
	         System.out.println(lodging2.toString());
	    }
		System.out.println("��µǾ����ϴ�.");*/
		
		
		
		//update
		/*lodging.setLodging_name("�����׽�Ʈ����");
		lodging.setLodging_loc("���ּ���");
		lodging.setLodging_phone("010-1111-1111");
		lodging.setLodging_image(null);
		lodging.setLodging_no(81);
		System.out.println("�� �����Ǿ����ϴ�.");
		lodgingDao.update(lodging);*/
		
		//delete
		/*lodgingDao.delete(64);
		System.out.println("�����Ǿ����ϴ�.");*/
		
		//selectbylodging_no
		lodging = lodgingDao.selectBylodging_no(50);
		System.out.println("��µǾ����ϴ�.");
		
		JDBCUtil.close(null, null, connection);
		
	}

}
