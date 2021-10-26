package dao.Lodgingadmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	//디비연결하는건 여기서 하면 된다.
	
	//접속
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@192.168.35.185:1521:xe";
	//로그인
	public static final String user = "SEUNGHYUN";
	public static final String password = "1207";
	
	//커넥션 객체를 리턴
	//연결하는 부분
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	//닫는 부분
	public static void close(ResultSet resultSet, Statement statement,Connection connection) {
		if(resultSet != null) {
			try {
				//이 resultSet오브젝트가 닫혀있다면 true 닫는다.
				if(!resultSet.isClosed()) {
					resultSet.close();
				}
			}catch(Exception e) {
				
			}finally {
				
				resultSet = null;
			}
		}
		
		if(connection != null) {
			try {
				//이 connection 오브젝트가 닫혀있다면 true 닫는다.
				if(!connection.isClosed()) {
					connection.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				connection = null;
			}
		}
		
		if(statement != null) {
			try {
				//이 statement 오브젝트가 닫혀있다면 true 닫는다.
				if(!statement.isClosed()) {
					statement.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				statement = null;
			}
		}
	}
}
