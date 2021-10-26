package dao.Roomadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Roomadmin.JDBCUtil;
import dao.Roomadmin.Sql;
import lodging.model.Roomadmin;

public class RoomDaoImpl implements RoomDao{

	@Override
	public void insert(Roomadmin roomadmin) {
		Connection connection = null;
		//insert�ϱ� ���� �ʿ��� ��
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.Room_INSERT_SQL);
			//"insert into room values(seqroom_no.nextval,?,?,?,?,?,?,?)";
			
			pStatement.setString(1, roomadmin.getRoom_name());
			pStatement.setInt(2, roomadmin.getRoom_price());
			pStatement.setInt(3, roomadmin.getRoom_personnel());
			pStatement.setString(4, roomadmin.getRoom_configuration());
			pStatement.setString(5, roomadmin.getRoom_service());
			pStatement.setInt(6, roomadmin.getLodging_no()); //�̺κ� lodging�� import�ϰ� lodging���� �������°ɷ�?
			pStatement.setString(7, roomadmin.getRoom_image());
			
			pStatement.executeUpdate();
			
			JDBCUtil.close(null, pStatement, connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		//finally�� try���� ������ ���ܵ� finally���� ������ �ǰԲ� �Ѵ�.
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	
	@Override
	public List<Roomadmin> selectAll() {
		
	      List<Roomadmin> roomList = new ArrayList<>();
	      
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      ResultSet resultset = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.Room_SELECT_All);
	         resultset = pStatement.executeQuery();            
	         
	         while(resultset.next()) {            
	        	 Roomadmin room = new Roomadmin();
	            
	        	 room.setRoom_no(resultset.getInt("room_no"));
	        	 room.setRoom_name(resultset.getString("room_name"));
	        	 room.setRoom_price(resultset.getInt("room_price"));
	        	 room.setRoom_personnel(resultset.getInt("room_personnel"));
	        	 room.setRoom_configuration(resultset.getString("room_configuration"));
	        	 room.setRoom_service(resultset.getString("room_service"));
	        	 room.setLodging_no(resultset.getInt("lodging_no"));//�̺κ� lodging�� import�ϰ� lodging���� �������°ɷ�?
	        	 room.setRoom_image(resultset.getString("room_image"));
	            
	        	 roomList.add(room);
	         }
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(resultset, pStatement, connection);
	      }
	      
	      return roomList;
	   }
	
}
