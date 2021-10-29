package dao.Lodginguser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import dao.Lodgingadmin.Sql;
import model.Lodging.Lodgingadmin;

public class lodgingDaoImpluser implements lodgingDaouser{
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
	            Lodgingadmin lodgingadmin = new Lodgingadmin();
	            
	            lodgingadmin.setLodging_no(resultset.getInt("lodging_no"));
	            lodgingadmin.setLodging_name(resultset.getString("lodging_name"));
	            lodgingadmin.setLodging_loc(resultset.getString("lodging_loc"));
	            lodgingadmin.setLodging_phone(resultset.getString("lodging_phone"));
	            lodgingadmin.setLodging_image(resultset.getString("lodging_image"));
	            
	            lodgingList.add(lodgingadmin);
	         }
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(resultset, pStatement, connection);
	      }
	      
	      return lodgingList;
	   }
	
	@Override
	   public Lodgingadmin selectBylodging_no(int lodging_no) {   
		
		Lodgingadmin lodgingadmin = null;
	      
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      ResultSet resultset = null;
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.Lodging_SELECT_BY_LODGING_NO_ALL);
	         
	         pStatement.setInt(1, lodging_no);
	         
	         resultset = pStatement.executeQuery();       
	         
	         if(resultset.next()) {   
	        	 lodgingadmin = new Lodgingadmin();
	            
	        	 lodgingadmin.setLodging_no(resultset.getInt("lodging_no"));
	        	 lodgingadmin.setLodging_name(resultset.getString("lodging_name"));
	        	 lodgingadmin.setLodging_loc(resultset.getString("lodging_loc"));
	        	 lodgingadmin.setLodging_phone(resultset.getString("lodging_phone"));
	        	 lodgingadmin.setLodging_image(resultset.getString("lodging_image"));
	            
	         }         
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(resultset, pStatement, connection);
	      }
	      return lodgingadmin;
	   }
}
