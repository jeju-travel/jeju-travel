package dao.car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.car.Car;
import model.car.CarReserve;
import model.car.CarReview;
import util.JDBCUtil;


public class Test {

	public static void main(String[] args) throws SQLException {
		Connection connection = JDBCUtil.getConnection();		
		
		CarDao cardao = new CarDaoImpl();
		Car car = new Car();	
		CarReserve carReserve = new CarReserve();
		CarReview carReview = new CarReview();
		//------------자동차 car db insert문-------------
		
		car.setCar_no(1);
		car.setCar_name("k2");
		car.setCar_type("소형차");
		car.setCar_price(20000);
		car.setCapacity(5);
		car.setCar_fuel("가솔린");
		car.setCar_loc("제주도 올레길 52-10번길 3층");
		car.setCar_image(null);		
		cardao.insert(car);
		
		//------------렌트카 CAR_RESERVE db insert문-------------
		
		carReserve.setBorrow_car("오전");
		carReserve.setReturn_car("오후");
		carReserve.setCar_no(1);
		cardao.CarReserve(carReserve);
		
		//------------렌트카 CAR_REVIEW db insert문-------------
		
		carReview.setCar_content("여기는 리뷰작성내용");
		carReview.setWriter("id");
		carReview.setCar_horoscope(4);
		carReview.setCar_no(1);
		cardao.CarReview(carReview);
		
		/*System.out.println(dao.selectCntById("id"));
		System.out.println(dao.login("id", "pass"));
		*/
		
		/*bbs.setId("id");
		bbs.setNo(1);
		bbs.setContent("수정");
		bbs.setSubject("수정");
		dao.bbsupdate(bbs);*/
	/*	
		memo.setName("승혁2");
		memo.setAge(28);
		memo.setMemoid(1);		
		dao.update(memo);
		//void delete(int memoid);
		
		dao.delete(1);
		
		//List<Memo> selectAll();		
		List<Memo> list = dao.selectAll();
		for (Memo memo2 : list) {
			System.out.println(memo2.toString());
		}
		
		//Memo selectByMemoid(int memoid);
		memo = dao.selectByMemoid(1);
		System.out.println(memo.toString()); */
		
		
		JDBCUtil.close(null, null, connection);
		
		System.out.println(connection);
	}
}
