package dao.air;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.air.Airline;
import sql.air.Sql;
import util.JDBCUtil;

public class AirReviewDaoImpl implements AirReviewDao {

	@Override
	public void insert(String writer, String airContent, int airHoroscope, int airNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Integer> check_member(int memberNo) {
		
		List<Integer> airList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.CHECK_RESERVE_MEMBER);
			pStatement.setInt(1, memberNo);
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) { //다음값으로 이동, null이라면 false
				
				airList.add(resultSet.getInt("air_no"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		
		return airList;
	}

}
