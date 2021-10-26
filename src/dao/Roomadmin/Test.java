package dao.Roomadmin;

import java.sql.Connection;

import dao.Roomadmin.JDBCUtil;
import model.Lodging.Roomadmin;

public class Test {
	Connection connection = JDBCUtil.getConnection();
	
	RoomDao roomDao = new RoomDaoImpl();
	Roomadmin roomadmin = new Roomadmin();
	
	
}
