package dao.Lodgingadmin;

import java.sql.Connection;
import java.util.List;

import dao.Lodgingadmin.JDBCUtil;
import model.Lodging.Lodgingadmin;

public class test {

	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		
		LodgingDao lodgingDao = new LodgingDaoImpl();
		Lodgingadmin lodgingadmin = new Lodgingadmin();
		
		//insert
		/*lodging.setLodging_name("���Ǻ�����");
		lodgingadmin.setLodging_loc("���� Ư����");
		lodgingadmin.setLodging_phone("010-2222-3333");
		lodgingadmin.setLodging_image(null);
		System.out.println("�� ����Ǿ����ϴ�.");
		lodgingDao.insert(lodgingadmin);*/
		
		//list
		List<Lodgingadmin> lodgingList = lodgingDao.selectAll();
		for (Lodgingadmin lodgingadmin2 : lodgingList) {
	         System.out.println(lodgingadmin2.toString());
	    }
		System.out.println("��µǾ����ϴ�.");
		
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
		/*lodgingadmin = lodgingDao.selectBylodging_no(2);
		System.out.println(lodgingadmin.toString());*/
		
		JDBCUtil.close(null, null, connection);
		
	}

}
