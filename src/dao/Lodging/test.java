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
		lodging.setLodging_name("��������");
		lodging.setLodging_loc("���� Ư����");
		lodging.setLodging_phone("010-1111-2222");
		lodging.setLodging_image(null);
		System.out.println("�� ����Ǿ����ϴ�.");
		lodgingDao.insert(lodging);
		
		
		JDBCUtil.close(null, null, connection);
	}

}
