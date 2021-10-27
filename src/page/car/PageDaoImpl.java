package page.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtil;

public class PageDaoImpl implements PageDao{

	@Override
	public int getCount(String sql) {		
		int cnt = 0;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(sql);			
			
			resultset = pStatement.executeQuery(); 		
			
			while(resultset.next()) {            
	               cnt = resultset.getInt("cnt");
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		return cnt;
	}	
	
}
