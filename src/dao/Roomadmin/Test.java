package dao.Roomadmin;

import java.sql.Connection;


import model.Lodging.Roomadmin;
import util.JDBCUtil;

public class Test {
	Connection connection = JDBCUtil.getConnection();
	
	RoomDao roomDao = new RoomDaoImpl();
	Roomadmin roomadmin = new Roomadmin();
	
	
}
