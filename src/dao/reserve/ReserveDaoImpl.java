package dao.reserve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Lodging.Lodgingadmin;
import model.air.AirReserve;
import model.air.Airline;
import model.car.Car;
import model.car.CarReserve;
import model.manager.Reservation;
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
				res.setState(resultSet.getString("total_state"));
				res.setPrice(resultSet.getInt("total_price"));
				res.setResNo(resultSet.getInt("reserve_no"));
				res.setairResNo(resultSet.getInt("air_reserve_no"));
				res.setcarResNo(resultSet.getInt("room_reserve_no"));
				res.setroomResNo(resultSet.getInt("car_reserve_no"));

				
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
				res.setState(resultSet.getString("total_state"));
				res.setMemNo(resultSet.getInt("member_no"));
				res.setairResNo(resultSet.getInt("air_reserve_no"));
				res.setcarResNo(resultSet.getInt("car_reserve_no"));
				res.setroomResNo(resultSet.getInt("room_reserve_no"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		
		
		return res;
	}

	@Override
	public String selectNameAirResNo(int airResNo) {
		String name=null;
		
	
		
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RES_SELECT_AIRNAME_BY_RESNO);
			
			pStatement.setInt(1, airResNo);

			resultSet = pStatement.executeQuery();

			if(resultSet.next()) {
				
				name = resultSet.getString("air_name");
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		
		
		return name;
	}

	@Override
	public String selectNameCarResNo(int carResNo) {
	String name=null;
		
	
		
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RES_SELECT_CARNAME_BY_RESNO);
			
			pStatement.setInt(1, carResNo);

			resultSet = pStatement.executeQuery();

			if(resultSet.next()) {
				
				name = resultSet.getString("car_name");
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		
		
		return name;
	}

	@Override
	public String selectNameRoomResNo(int roomResNo) {
	String name=null;
		
	
		
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RES_SELECT_ROOMNAME_BY_RESNO);
			
			pStatement.setInt(1, roomResNo);

			resultSet = pStatement.executeQuery();

			if(resultSet.next()) {
				
				name = resultSet.getString("lodging_name");
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		
		
		return name;
	}

	@Override
	public AirReserve selectAirResByResNo(int resNo) {

		
	AirReserve air = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.SELECT_AIR_RES_BY_RESNO);
			pStatement.setInt(1, resNo);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) { //다음값으로 이동, null이라면 false
				air = new AirReserve();
				
				air.setAirNo(resultSet.getInt("air_reserve_no"));
				air.setLanding(resultSet.getString("landing"));
				air.setTakeOff(resultSet.getString("take_off"));
				air.setAirNo(resultSet.getInt("air_no"));
				air.setPersonnel(resultSet.getInt("personnel"));
				
		
				System.out.println("gg" + air.toString());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return air;
	}

	@Override
	public CarReserve selectCarResByResNo(int resNo) {
	CarReserve car =null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.SELECT_CAR_RES_BY_RESNO);
			pStatement.setInt(1, resNo);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) { //다음값으로 이동, null이라면 false
				car = new CarReserve();
				car.setBorrow_car(resultSet.getString("borrow_car"));
				car.setReturn_car(resultSet.getString("return_car"));
				car.setCar_no(resultSet.getInt("car_no"));
				car.setCar_reserve_no(resultSet.getInt("car_reserve_no"));
				
				
	
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return car;
	}

	@Override
	public Airline selectAirByResNo(int resNo) {
		Airline air =null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.SELECT_AIR_BY_RESNO);
			pStatement.setInt(1, resNo);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) { //다음값으로 이동, null이라면 false
				air = new Airline();
				
				air.setAirNo(resultSet.getInt("air_no"));
				air.setAirName(resultSet.getString("air_name"));
				air.setAirLoc(resultSet.getString("air_loc"));
				air.setPrice(resultSet.getInt("price"));
				air.setTakeOff(resultSet.getString("take_off"));
				air.setAirImage(resultSet.getString("air_image"));
	
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return air;
	}

	@Override
	public Car selectCarByResNo(int resNo) {
		Car car =null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.SELECT_CAR_BY_RESNO);
			pStatement.setInt(1, resNo);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) { //다음값으로 이동, null이라면 false
				car = new Car();
				
				
				car.setCapacity(resultSet.getInt("capacity"));
				car.setCar_fuel(resultSet.getString("car_fuel"));
				car.setCar_image(resultSet.getString("car_image"));
				car.setCar_loc(resultSet.getString("car_loc"));
				car.setCar_name(resultSet.getString("car_name"));
				car.setCar_no(resultSet.getInt("car_no"));
				car.setCar_price(resultSet.getInt("car_price"));
				car.setCar_type(resultSet.getString("car_type"));
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return car;
	}

	@Override
	public Lodgingadmin selectRoomByResNo(int resNo) {
		
		Lodgingadmin room =null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			pStatement = connection.prepareStatement(Sql.SELECT_ROOM_BY_RESNO);
			pStatement.setInt(1, resNo);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) { //다음값으로 이동, null이라면 false
				room = new Lodgingadmin();
				
				room.setLodging_image(resultSet.getString("lodging_image"));
				room.setLodging_loc(resultSet.getString("lodging_loc"));
				room.setLodging_name(resultSet.getString("lodging_name"));
				room.setLodging_no(resultSet.getInt("lodging_no"));
				room.setLodging_phone(resultSet.getString("lodging_phone"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return room;
	}

	@Override
	public void insert(int memberNo, String startDay, String endDay, int totalPrice) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.INSERT_RESERVATION);
			
			pStatement.setInt(1, memberNo);
			pStatement.setString(2, startDay);
			pStatement.setString(3, endDay);
			pStatement.setInt(4, totalPrice);
			
			pStatement.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public int recentReservation() {
		int resNo = 0;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RECENT_RESERVATION);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) { //다음값으로 이동, null이라면 false
				
				resNo = resultSet.getInt("num");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return resNo;
	}
	
	

	
}
