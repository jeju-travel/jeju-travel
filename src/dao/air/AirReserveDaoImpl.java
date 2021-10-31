package dao.air;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.air.AirReserve;
import model.air.Airline;
import sql.air.Sql;
import util.JDBCUtil;

public class AirReserveDaoImpl implements AirReserveDao {

	@Override
	public void insert(AirReserve airRes) {

		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.AIR_RESERVE_INSERT);
			
			pStatement.setString(1, airRes.getTakeOff());
			pStatement.setString(2, airRes.getLanding());
			pStatement.setInt(3, airRes.getPersonnel());
			pStatement.setInt(4, airRes.getAirNo());
			
			pStatement.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}

	}
	

	@Override
	public void updateReservation(int resNo, int airResNo) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.RESERVATION_AIR);
			pStatement.setInt(1, airResNo);
			pStatement.setInt(2, resNo);
			
			pStatement.executeQuery();
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}



	@Override
	public int recentAirReserve() {
		int number = 0;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.RECENT_AIR_RESERVE);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) { //다음값으로 이동, null이라면 false
				
				number = resultSet.getInt("num");
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return number;
	}



	@Override
	public AirReserve selectByNo(int reserveNo) {
		AirReserve airReserve = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.AIR_RESERVE_SELECT_BY_RESERVENO);
			pStatement.setInt(1, reserveNo);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) { //다음값으로 이동, null이라면 false.
				airReserve = new AirReserve();

				airReserve.setAirReserveNo(resultSet.getInt("air_reserve_no"));
				airReserve.setTakeOff(resultSet.getString("take_off"));
				airReserve.setLanding(resultSet.getString("landing"));
				airReserve.setPersonnel(resultSet.getInt("personnel"));
				airReserve.setAirNo(resultSet.getInt("air_no"));
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return airReserve;
	}
	
	

}
