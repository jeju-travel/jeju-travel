package dao.Lodgingadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Lodgingadmin.JDBCUtil;
import dao.Lodgingadmin.Sql;
import lodging.model.Lodgingadmin;

public class LodgingDaoImpl implements LodgingDao{

	@Override
	public void insert(Lodgingadmin lodging) {
		Connection connection = null;
		//insert�ϱ� ���� �ʿ��� ��
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.Lodging_INSERT_SQL);
			//"insert into lodging(lodging_no,lodging_name,lodging_loc,lodging_phone,
			//lodging_image) values(seqlodging_no.nextval,?,?,?,?)";
			pStatement.setString(1, lodging.getLodging_name());
			pStatement.setString(2, lodging.getLodging_loc());
			pStatement.setString(3, lodging.getLodging_phone());
			pStatement.setString(4, lodging.getLodging_image());
			
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
	public List<Lodgingadmin> selectAll() {
	      List<Lodgingadmin> lodgingList = new ArrayList<>();
	      
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      ResultSet resultset = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.Lodging_SELECT_All);
	         resultset = pStatement.executeQuery();            
	         
	         while(resultset.next()) {            
	            Lodgingadmin lodging = new Lodgingadmin();
	            
	            lodging.setLodging_no(resultset.getInt("lodging_no"));
	            lodging.setLodging_name(resultset.getString("lodging_name"));
	            lodging.setLodging_loc(resultset.getString("lodging_loc"));
	            lodging.setLodging_phone(resultset.getString("lodging_phone"));
	            lodging.setLodging_image(resultset.getString("lodging_image"));
	            
	            lodgingList.add(lodging);
	         }
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(resultset, pStatement, connection);
	      }
	      
	      return lodgingList;
	   }
	
	@Override
	   public void update(Lodgingadmin lodging) {
	      Connection connection =null;
	      PreparedStatement pStatement = null;
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.Lodging_UPDATE_All);         
	         //"update lodging set lodging_name=?,lodging_loc=?,lodging_phone=?,lodging_image=? where lodging_no=?";  
	         pStatement.setString(1, lodging.getLodging_name());
	         pStatement.setString(2, lodging.getLodging_loc());
	         pStatement.setString(3, lodging.getLodging_phone());
	         pStatement.setString(4, lodging.getLodging_image());
	         pStatement.setInt(5, lodging.getLodging_no());
	         
	         pStatement.executeUpdate();         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(null, pStatement, connection);
	      }
	   }
	
	@Override
	   public void delete(int lodging_no) {
		   Connection connection =null;
		   PreparedStatement pStatement = null;
		      try {
		         connection = JDBCUtil.getConnection();
		         pStatement = connection.prepareStatement(Sql.Lodging_DELETE_All);         
		            
		         pStatement.setInt(1, lodging_no);         
		      
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
	   public Lodgingadmin selectBylodging_no(int lodging_no) {      
		Lodgingadmin lodging = null;
	      
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      ResultSet resultset = null;
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.Lodging_SELECT_BY_LODGING_NO_ALL);
	         
	         pStatement.setInt(1, lodging_no);
	         
	         resultset = pStatement.executeQuery();       
	         
	         if(resultset.next()) {   
	            lodging = new Lodgingadmin();
	            
	            lodging.setLodging_no(resultset.getInt("lodging_no"));
	            lodging.setLodging_name(resultset.getString("lodging_name"));
	            lodging.setLodging_loc(resultset.getString("lodging_loc"));
	            lodging.setLodging_phone(resultset.getString("lodging_phone"));
	            lodging.setLodging_image(resultset.getString("lodging_image"));
	            
	         }         
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(resultset, pStatement, connection);
	      }
	      return lodging;
	   }
	
}
