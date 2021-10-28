package dao.Lodgingadmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	//��񿬰��ϴ°� ���⼭ �ϸ� �ȴ�.
	
	//����
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//�α���
	public static final String user = "SCOTT";
	public static final String password = "tiger";
	
	//Ŀ�ؼ� ��ü�� ����
	//�����ϴ� �κ�
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
	//�ݴ� �κ�
	public static void close(ResultSet resultSet, Statement statement,Connection connection) {
		if(resultSet != null) {
			try {
				//�� resultSet������Ʈ�� �����ִٸ� true �ݴ´�.
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
				//�� connection ������Ʈ�� �����ִٸ� true �ݴ´�.
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
				//�� statement ������Ʈ�� �����ִٸ� true �ݴ´�.
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
