package dao.air;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.air.Airline;
import sql.air.Sql;
import util.JDBCUtil;

public class AirlineDaoImpl implements AirlineDao {

	@Override
	public void insert(Airline airline) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.AIRLINE_INSERT);
			
			pStatement.setString(1, airline.getAirName());
			pStatement.setInt(2, airline.getPrice());
			pStatement.setString(3, airline.getAirLoc());
			pStatement.setString(4, airline.getTakeOff());
			pStatement.setString(5, airline.getAirImage());
			
			pStatement.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
	
	}

	@Override
	public void update(String airName, int price, String airLoc, String takeOff, String airImage, int airNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.AIRLINE_UPDATE);
			
			pStatement.setString(1, airName);
			pStatement.setInt(2, price);
			pStatement.setString(3, airLoc);
			pStatement.setString(4, takeOff);
			pStatement.setString(5, airImage);
			pStatement.setInt(6, airNo);
			
			pStatement.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}

	}

	@Override
	public void delete(int airNo) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.AIRLINE_DELETE);
			
			pStatement.setInt(1, airNo);
			
			pStatement.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}

	}
	
	public Airline selectByNo(int airNo) {
		Airline airline = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.AIRLINE_SELECT_BY_NO);
			pStatement.setInt(1, airNo);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) { //다음값으로 이동, null이라면 false
				airline = new Airline();

				airline.setAirNo(resultSet.getInt("air_no"));
				airline.setAirName(resultSet.getString("air_name"));
				airline.setPrice(resultSet.getInt("price"));
				airline.setAirLoc(resultSet.getString("air_loc"));
				airline.setTakeOff(resultSet.getString("take_off"));
				airline.setAirImage(resultSet.getString("air_image"));
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return airline;
	}
	
	
	public List<Airline> selectAll() {
		List<Airline> airList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.AIRLINE_SELECT_ALL);
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) { //다음값으로 이동, null이라면 false
				Airline airline = new Airline();

				airline.setAirNo(resultSet.getInt("air_no"));
				airline.setAirName(resultSet.getString("air_name"));
				airline.setPrice(resultSet.getInt("price"));
				airline.setAirLoc(resultSet.getString("air_loc"));
				airline.setTakeOff(resultSet.getString("take_off"));
				
				airList.add(airline);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return airList;
	}

}
