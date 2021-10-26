package dao.reserve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.Reservation;
import util.JDBCUtil;


public class ReserveDaoImpl implements ReserveDao{



	@Override
	public void delete(int no) {
		
	}

	@Override
	public List<Reservation> selectByMemNo(int memNo) {
		
		List<Reservation> reslist = new ArrayList<Reservation>();
		
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RES_SELECT_BY_MEM_NO);
			
			pStatement.setInt(1, memNo);

			resultSet = pStatement.executeQuery();

			while(resultSet.next()) {
				
				Reservation res = new Reservation();
				
				res.setMemNo(memNo);
				res.setStartDay(resultSet.getString("start_day"));
				res.setEndDay(resultSet.getString("end_day"));
				res.setState(resultSet.getString("state"));
				res.setResNo(resultSet.getInt("reserve_no"));

				
				System.out.println(res.toString());
				
				reslist.add(res);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		
		
		return reslist;
		
	}

	@Override
	public int[] selectItemNoByResNo(int resNo) {
		int[] num = new int[3];
		
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RES_SELECT_ITEM_NO_BY_RES_NO);
			
			pStatement.setInt(1, resNo);

			resultSet = pStatement.executeQuery();

			while(resultSet.next()) {
				
				//a.air_no, c.car_no, room.room_no
				
				int air_no = resultSet.getInt("air_no");
				int car_no = resultSet.getInt("car_no");
				int room_no = resultSet.getInt("room_no");
				
				num[0] = air_no;
				num[1] = car_no;
				num[2] = room_no;
				
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		
		
		return num;
	}

	@Override
	public Reservation selectByResNo(int resNo) {
		
		Reservation res = new Reservation();
		
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RES_SELECT_BY_NO);
			
			pStatement.setInt(1, resNo);

			resultSet = pStatement.executeQuery();

			if(resultSet.next()) {
				
				res.setResNo(resNo);
				res.setStartDay(resultSet.getString("start_day"));
				res.setEndDay(resultSet.getString("end_day"));
				res.setState(resultSet.getString("state"));
				res.setMemNo(resultSet.getInt("member_no"));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		
		
		return res;
	}
	

}
