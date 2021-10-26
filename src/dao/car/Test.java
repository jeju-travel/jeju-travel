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
		//------------�ڵ��� car db insert��-------------
		
		car.setCar_no(1);
		car.setCar_name("k2");
		car.setCar_type("������");
		car.setCar_price(20000);
		car.setCapacity(5);
		car.setCar_fuel("���ָ�");
		car.setCar_loc("���ֵ� �÷��� 52-10���� 3��");
		car.setCar_img(null);		
		cardao.insert(car);
		
		//------------��Ʈī CAR_RESERVE db insert��-------------
		
		carReserve.setBorrow_car("����");
		carReserve.setReturn_car("����");
		carReserve.setReserve_no(1);
		carReserve.setCar_no(1);
		cardao.CarReserve(carReserve);
		
		//------------��Ʈī CAR_REVIEW db insert��-------------
		
		carReview.setCar_content("����� �����ۼ�����");
		carReview.setWriter("id");
		carReview.setCar_horoscope(4);
		carReview.setCar_no(1);
		cardao.CarReview(carReview);
		
		/*System.out.println(dao.selectCntById("id"));
		System.out.println(dao.login("id", "pass"));
		*/
		
		/*bbs.setId("id");
		bbs.setNo(1);
		bbs.setContent("����");
		bbs.setSubject("����");
		dao.bbsupdate(bbs);*/
	/*	
		memo.setName("����2");
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
