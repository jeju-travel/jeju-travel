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
	public void insert(String writer, String airContent, double airHoroscope, int airNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.AIR_REVIEW_INSERT);
			
			pStatement.setString(1, writer);
			pStatement.setString(2, airContent);
			pStatement.setDouble(3, airHoroscope);
			pStatement.setInt(4, airNo);
			
			pStatement.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
	

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
				
				airList.add(resultSet.getInt("air_reserve_no"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		
		return airList;
	}

	@Override
	public double avg_horoscope(int airNo) {
		double horoscope = 0;

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.AVERAGE_HOROSCOPE);
			pStatement.setInt(1, airNo);
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) { //다음값으로 이동, null이라면 false
				
				horoscope = Math.round(resultSet.getDouble("horoscope")*10) / 10.0;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		
		return horoscope;
	}

	@Override
	public void update(String content, double horoscope, int air_review_no) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.AIR_REVIEW_UPDATE);
			
			pStatement.setString(1, content);
			pStatement.setDouble(2, horoscope);
			pStatement.setInt(3, air_review_no);
			
			pStatement.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void delete(int airReviewNo) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.AIR_REVIEW_DELETE);
			
			pStatement.setInt(1, airReviewNo);
			
			pStatement.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}
}
