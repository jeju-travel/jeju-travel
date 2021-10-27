package dao.air;

import java.sql.Connection;
import java.sql.PreparedStatement;

import sql.air.Sql;
import util.JDBCUtil;

public class AirReserveDaoImpl implements AirReserveDao {

	@Override
	public void insert(String takeOff, String landing, int personnel, int reserveNo, int airNo) {

		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.AIR_RESERVE_INSERT);
			
			pStatement.setString(1, takeOff);
			pStatement.setString(2, landing);
			pStatement.setInt(3, personnel);
			pStatement.setInt(4, reserveNo);
			pStatement.setInt(5, airNo);
			
			pStatement.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}

	}

}
