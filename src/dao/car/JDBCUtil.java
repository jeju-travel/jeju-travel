package dao.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String user = "scott";
	public static final String password = "tiger";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection; // Connection을 리턴한다는 의미
	}

	public static void close(ResultSet resultset, Statement statement, Connection connection) {
		if (resultset != null) {
			try {
				if (!resultset.isClosed()) {
					resultset.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				resultset = null;
			}
		}
		if (statement != null) {
			try {
				if (!statement.isClosed()) {
					statement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				statement = null;
			}
		}
		if (connection != null) {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}
}
