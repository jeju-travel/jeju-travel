package dao.Lodging;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.Lodging.JDBCUtil;
import dao.Lodging.Sql;
import model.Lodging;

public class LodgingDaoImpl implements LodgingDao{

	@Override
	public void insert(Lodging lodging) {
		Connection connection = null;
		//insert하기 위해 필요한 것
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.Lodging_INSERT_SQL);
			//"insert into lodging(lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_image) values(seqlodging_no.nextval,?,?,?,?)";
			pStatement.setString(1, lodging.getLodging_name());
			pStatement.setString(2, lodging.getLodging_loc());
			pStatement.setString(3, lodging.getLodging_phone());
			pStatement.setString(4, lodging.getLodging_image());
			
			pStatement.executeUpdate();
			
			JDBCUtil.close(null, pStatement, connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		//finally는 try에서 문제가 생겨도 finally에서 실행이 되게끔 한다.
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}

}
