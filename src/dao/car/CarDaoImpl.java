package dao.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.car.Car;
import model.car.CarReserve;
import model.car.CarReview;
import model.car.Carhoroscope;

import page.car.PageManager;
import page.car.PageRowResult;
import util.JDBCUtil;



public class CarDaoImpl implements CarDao {
	private static final String BOOK_SELECT_PAGE_SQL=
			"select *"
			+ " from (select rownum rn, cars.* from (select * from car order by car_no) cars)"
			+ " where rn between ? and ?";
	
	@Override
	public void insert(Car car) {
		Connection connection =null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_INSERT_SQL);
					
			
			pStatement.setString(1, car.getCar_name());
			pStatement.setString(2, car.getCar_type());
			pStatement.setInt(3, car.getCar_price());
			pStatement.setInt(4, car.getCapacity());
			pStatement.setString(5, car.getCar_fuel());
			pStatement.setString(6,car.getCar_loc());
			pStatement.setString(7,car.getCar_img());
			pStatement.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	@Override
	public void CarReserve(CarReserve carreserve) {
		Connection connection =null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_RESERVE_INSERT_SQL);
			
			pStatement.setString(1, carreserve.getBorrow_car());
			pStatement.setString(2, carreserve.getReturn_car());
			pStatement.setInt(3, carreserve.getCar_no());			
			
			pStatement.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	@Override
	public void CarReview(CarReview carreview) {
		Connection connection =null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_REVIEW_INSERT_SQL);					
			
			pStatement.setString(1, carreview.getWriter());
			pStatement.setString(2, carreview.getCar_content());			
			pStatement.setInt(3, carreview.getCar_horoscope());			
			pStatement.setInt(4, carreview.getCar_no());
			
			pStatement.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	@Override
	public List<Car> CarselectAll() {
		List<Car> carList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_SELECT_ALL_SQL);
			resultset = pStatement.executeQuery();				
			
			while(resultset.next()) {				
				
				Car car = new Car();
				car.setCar_no(resultset.getInt("car_no"));
				car.setCar_name(resultset.getString("car_name"));
				car.setCar_type(resultset.getString("car_type"));	
				car.setCar_price(resultset.getInt("car_price"));
				car.setCapacity(resultset.getInt("capacity"));
				car.setCar_fuel(resultset.getString("car_fuel"));
				car.setCar_loc(resultset.getString("car_loc"));
				car.setCar_img(resultset.getString("car_img"));
				
				carList.add(car);
			}			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		
		return carList;
	}
	@Override
	public List<Car> selectAll(int requestPage) {
		List<Car> carList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(BOOK_SELECT_PAGE_SQL);
			
			//? �����ؾߵȴ�.  �Ŵ������� ������ �Ŵ��� �˾Ƴ����ְ� ������.
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
							
			pStatement.setInt(1, prr.getRowStartNumber());
			pStatement.setInt(2, prr.getRowEndNumber());
			
			resultset = pStatement.executeQuery();		
			
			
			while(resultset.next()) {				
				Car car = new Car();
				car.setCar_no(resultset.getInt("car_no"));
				car.setCar_name(resultset.getString("car_name"));
				car.setCar_type(resultset.getString("car_type"));	
				car.setCar_price(resultset.getInt("car_price"));
				car.setCapacity(resultset.getInt("capacity"));
				car.setCar_fuel(resultset.getString("car_fuel"));
				car.setCar_loc(resultset.getString("car_loc"));
				car.setCar_img(resultset.getString("car_img"));
				
				carList.add(car);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		
		return carList;
	}
	@Override
	public List<Car> CarselectAllprice() {
		List<Car> carList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_SELECT_ALL_PRICE_SQL);
			resultset = pStatement.executeQuery();				
			
			while(resultset.next()) {				
				
				Car car = new Car();
				car.setCar_no(resultset.getInt("car_no"));
				car.setCar_name(resultset.getString("car_name"));
				car.setCar_type(resultset.getString("car_type"));	
				car.setCar_price(resultset.getInt("car_price"));
				car.setCapacity(resultset.getInt("capacity"));
				car.setCar_fuel(resultset.getString("car_fuel"));
				car.setCar_loc(resultset.getString("car_loc"));
				car.setCar_img(resultset.getString("car_img"));
				
				carList.add(car);
			}			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		
		return carList;
	}
	@Override
	public Car selectByCarno(int car_no) {		
		Car car = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_SELECT_BY_NO_SQL);
			
			pStatement.setInt(1, car_no);
			
			resultset = pStatement.executeQuery(); 		
			
			if(resultset.next()) {	
				car= new Car();
				
				car.setCar_no(resultset.getInt("car_no"));
				car.setCar_name(resultset.getString("car_name"));
				car.setCar_type(resultset.getString("car_type"));
				car.setCar_price(resultset.getInt("car_price"));
				car.setCapacity(resultset.getInt("capacity"));
				car.setCar_fuel(resultset.getString("car_fuel"));
				car.setCar_loc(resultset.getString("car_loc"));
				car.setCar_img(resultset.getString("car_image"));
			}			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		return car;
	}
	@Override
	public void Carupdate(Car car) {
		Connection connection =null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_UPDATE_SQL);				
			
			pStatement.setString(1, car.getCar_name());
			pStatement.setString(2, car.getCar_type());
			pStatement.setInt(3, car.getCar_price());
			pStatement.setInt(4, car.getCapacity());
			pStatement.setString(5, car.getCar_fuel());
			pStatement.setString(6, car.getCar_loc());
			pStatement.setString(7, car.getCar_img());			
			pStatement.setInt(8, car.getCar_no());	
			
			pStatement.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	@Override
	public void Cardelete(int car_no) {
		Connection connection =null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_DELETE_SQL);			
				
			pStatement.setInt(1, car_no);			
		
			pStatement.executeUpdate();
			
			pStatement.close();
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	
	@Override
	public List<Carhoroscope> Carhoroscope() {
		List<Carhoroscope> carhoroscopeList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_REVIEW_HOROSCOPE);
			resultset = pStatement.executeQuery();				
			
			while(resultset.next()) {				
				
				Carhoroscope carhoroscope = new Carhoroscope();
				carhoroscope.setCar_no(resultset.getInt("car_no"));
				carhoroscope.setCar_horoscope(resultset.getDouble("car_horoscope"));				
				
				carhoroscopeList.add(carhoroscope);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		
		return carhoroscopeList;
	}
	@Override
	public List<Car> Cartypefuel(String car_type,String car_fuel) {
		List<Car> carList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_SELECT_TYPE_FUEL_SQL);
			
			pStatement.setString(1, car_type);
			pStatement.setString(2, car_fuel);
			
			resultset = pStatement.executeQuery();				
			
			while(resultset.next()) {				
				
				Car car = new Car();
				car.setCar_no(resultset.getInt("car_no"));
				car.setCar_name(resultset.getString("car_name"));
				car.setCar_type(resultset.getString("car_type"));	
				car.setCar_price(resultset.getInt("car_price"));
				car.setCapacity(resultset.getInt("capacity"));
				car.setCar_fuel(resultset.getString("car_fuel"));
				car.setCar_loc(resultset.getString("car_loc"));
				car.setCar_img(resultset.getString("car_img"));
				
				carList.add(car);
			}			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		
		return carList;
	}
	@Override
	public List<Car> Cartype(String car_type) {
		List<Car> carList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_SELECT_TYPE_SQL);
			
			pStatement.setString(1, car_type);
			
			resultset = pStatement.executeQuery();				
			
			while(resultset.next()) {				
				
				Car car = new Car();
				car.setCar_no(resultset.getInt("car_no"));
				car.setCar_name(resultset.getString("car_name"));
				car.setCar_type(resultset.getString("car_type"));	
				car.setCar_price(resultset.getInt("car_price"));
				car.setCapacity(resultset.getInt("capacity"));
				car.setCar_fuel(resultset.getString("car_fuel"));
				car.setCar_loc(resultset.getString("car_loc"));
				car.setCar_img(resultset.getString("car_img"));
				
				carList.add(car);
			}			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		
		return carList;
	}
	@Override
	public List<Car> Carfuel(String car_fuel) {
		List<Car> carList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_SELECT_FUEL_SQL);
			
			pStatement.setString(1, car_fuel);
			
			resultset = pStatement.executeQuery();				
			
			while(resultset.next()) {				
				
				Car car = new Car();
				car.setCar_no(resultset.getInt("car_no"));
				car.setCar_name(resultset.getString("car_name"));
				car.setCar_type(resultset.getString("car_type"));	
				car.setCar_price(resultset.getInt("car_price"));
				car.setCapacity(resultset.getInt("capacity"));
				car.setCar_fuel(resultset.getString("car_fuel"));
				car.setCar_loc(resultset.getString("car_loc"));
				car.setCar_img(resultset.getString("car_img"));
				
				carList.add(car);
			}			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		
		return carList;
	}
	@Override
	public int cha(String end_day,String start_day) {
		int cha = 0;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CAR_SELECT_PRICE_COUNT_SQL);			
			
			pStatement.setString(1, end_day);
			pStatement.setString(2, start_day);
			
			resultset = pStatement.executeQuery(); 		
			
			while(resultset.next()) {            
	               cha = resultset.getInt("cha");
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		return cha;
	}	
	
	
	/*@Override
	public void writeinsert(Bbs bbs) {
		Connection connection =null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.WRITE_INSERT_SQL);			
			pStatement.setString(1, bbs.getSubject());	
			pStatement.setString(2, bbs.getContent());		
			pStatement.setInt(3, bbs.getCnt());	
			pStatement.setString(4, bbs.getId());
			
			pStatement.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	
	@Override
	public int selectCntById(String id) {
		int cnt = 0;
		Connection connection =null;
		PreparedStatement pStatement = null;
		ResultSet resultSet =null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CUSTOMER_CNT_SQL);
			
			pStatement.setString(1, id);	
			
			resultSet = pStatement.executeQuery();		
			if(resultSet.next()) {
				cnt = resultSet.getInt("cnt");
			}				
					
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return cnt;
	
	}
	
	@Override
	public Customer login(String id,String pwd) {
		Customer customer = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CUSTOMER_LOGIN_SQL);
			
			pStatement.setString(1, id);
			pStatement.setString(2, pwd);
			
			resultset = pStatement.executeQuery(); 		
			
			if(resultset.next()) {	
				customer= new Customer();
				
				customer.setCustomerseq(resultset.getInt("customerseq"));
				customer.setId(resultset.getString("id"));
				customer.setName(resultset.getString("name"));
				customer.setPassword(resultset.getString("password"));
				customer.setPostcode(resultset.getString("postcode"));
				customer.setAddress(resultset.getString("address"));
				customer.setAddress2(resultset.getString("address2"));
				customer.setPhone(resultset.getString("phone"));
				customer.setEmail(resultset.getString("email"));			
						
			}			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		return customer;
	}
	
	@Override
	public void update(Customer customer) {
		Connection connection =null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CUSTOMER_UPDATE_SQL);				
			
			
			pStatement.setString(1, customer.getId());	
			pStatement.setString(2, customer.getName());	
			pStatement.setString(3, customer.getPassword());	
			pStatement.setString(4, customer.getPostcode());	
			pStatement.setString(5, customer.getAddress());	
			pStatement.setString(6, customer.getAddress2());	
			pStatement.setString(7, customer.getPhone());	
			pStatement.setString(8, customer.getEmail());	
			pStatement.setLong(9, customer.getCustomerseq());
			
			pStatement.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	@Override
	public List<Bbs> selectAll() {
		List<Bbs> bbsList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BBS_SELECT_ALL_SQL);
			resultset = pStatement.executeQuery();				
			
			while(resultset.next()) {				
				
				Bbs bbs = new Bbs();
				String[] data=resultset.getString("wdata").split(" ");
				bbs.setNo(resultset.getInt("no"));
				bbs.setSubject(resultset.getString("subject"));
				bbs.setContent(resultset.getString("content"));
				bbs.setId(resultset.getString("id"));
				bbs.setWdata(data[0]);
				bbs.setCnt(resultset.getInt("cnt"));		
				
				bbsList.add(bbs);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		
		return bbsList;
	}
	
	@Override
	public List<Bbs> select_by_search(String search) {	
		List<Bbs> bbsList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BBS_SEARCHNAME_SQL);
			
			pStatement.setString(1, "%"+search+"%");			
			resultset = pStatement.executeQuery(); 		
			
			while(resultset.next()) {				
				Bbs bbs = new Bbs();
				
				bbs.setNo(resultset.getInt("no"));
				bbs.setSubject(resultset.getString("subject"));
				bbs.setId(resultset.getString("id"));
				bbs.setWdata(resultset.getString("wdata"));
				bbs.setCnt(resultset.getInt("cnt"));		
			
				bbsList.add(bbs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		
		return bbsList;
	}
	@Override
	public void cntcount(String subject) {
		Connection connection =null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BBS_CNTCOUNT_SQL);		
			
			pStatement.setString(1, subject);	
			
			
			pStatement.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	@Override
	public Bbs selectbyno(int no) {
		Bbs bbs = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BBS_SELECT_BY_NO_SQL);
			
			pStatement.setInt(1, no);
			
			resultset = pStatement.executeQuery(); 		
			
			if(resultset.next()) {	
				bbs = new Bbs();				
				bbs.setNo(resultset.getInt("no"));
				bbs.setSubject(resultset.getString("subject"));
				bbs.setContent(resultset.getString("content"));
				bbs.setId(resultset.getString("id"));
				bbs.setWdata(resultset.getString("wdata"));
				bbs.setCnt(resultset.getInt("cnt"));		
					
			}			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		return bbs;
	}
	
	@Override
	public void bbsupdate(Bbs bbs) {
		Connection connection =null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BBS_UPDATE_SQL);	
			
			pStatement.setString(1, bbs.getSubject());	
			pStatement.setString(2, bbs.getContent());		
			pStatement.setInt(3, bbs.getNo());
			
			pStatement.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	
	
	@Override
	public void bbsdelete(int no) {
		Connection connection =null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BBS_DELETE_SQL);			
				
			pStatement.setInt(1, no);			
		
			pStatement.executeUpdate();
			
			pStatement.close();
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}

	

	@Override
	public Customer selectBycustomerseq(long customerseq) {		
		Customer customer = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CUSTOMER_SELECT_BY_ID_SQL);
			
			pStatement.setLong(1, customerseq);
			
			resultset = pStatement.executeQuery(); 		
			
			if(resultset.next()) {	
				customer= new Customer();
				customer.setCustomerseq(resultset.getInt("customerseq"));				
				customer.setId(resultset.getString("id"));
				customer.setName(resultset.getString("name"));
				customer.setPassword(resultset.getString("password"));
				customer.setPostcode(resultset.getString("postcode"));
				customer.setAddress(resultset.getString("address"));
				customer.setAddress2(resultset.getString("address2"));
				customer.setPhone(resultset.getString("phone"));
				customer.setEmail(resultset.getString("email"));				
				
				
			}			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		return customer;
	}*/
	
	
}
