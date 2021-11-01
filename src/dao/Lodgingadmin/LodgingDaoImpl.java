package dao.Lodgingadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import dao.Lodgingadmin.Sql;
import model.Lodging.Lodging_reserve;
import model.Lodging.Lodgingadmin;
import model.Lodging.Lodginghoroscope;
import util.JDBCUtil;

public class LodgingDaoImpl implements LodgingDao{

	@Override
	public void insert(Lodgingadmin lodgingadmin) {
		Connection connection = null;
		//insert하기 위해 필요한 것
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.Lodging_INSERT_SQL);
			//"insert into lodging(lodging_no,lodging_name,lodging_loc,lodging_phone,
			//lodging_image) values(seqlodging_no.nextval,?,?,?,?)";
			pStatement.setString(1, lodgingadmin.getLodging_name());
			pStatement.setString(2, lodgingadmin.getLodging_loc());
			pStatement.setString(3, lodgingadmin.getLodging_phone());
			pStatement.setInt(4, lodgingadmin.getLodging_price());
			pStatement.setString(5, lodgingadmin.getLodging_image());
			
			pStatement.executeUpdate();
			
			JDBCUtil.close(null, pStatement, connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		//finally는 try에서 문제가 생겨도 finally에서 실행이 되게끔 한다.
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}
	
	@Override
	public void Reserveroominsert(Lodging_reserve lodging_reserve) {
		Connection connection = null;
		//insert하기 위해 필요한 것
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LODGING_RESERVE_INSERT_SQL);
			
			pStatement.setString(1, lodging_reserve.getCheck_in());
			pStatement.setString(2, lodging_reserve.getCheck_out());
			pStatement.setInt(3, lodging_reserve.getLodging_no());
			pStatement.executeUpdate();
			
			JDBCUtil.close(null, pStatement, connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		//finally는 try에서 문제가 생겨도 finally에서 실행이 되게끔 한다.
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
	            Lodgingadmin lodgingadmin = new Lodgingadmin();
	            
	            lodgingadmin.setLodging_no(resultset.getInt("lodging_no"));
	            lodgingadmin.setLodging_name(resultset.getString("lodging_name"));
	            lodgingadmin.setLodging_loc(resultset.getString("lodging_loc"));
	            lodgingadmin.setLodging_phone(resultset.getString("lodging_phone"));
	            lodgingadmin.setLodging_price(resultset.getInt("lodging_price"));
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
	   public void update(Lodgingadmin lodgingadmin) {
	      Connection connection =null;
	      PreparedStatement pStatement = null;
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.Lodging_UPDATE_All);         
	         //"update lodging set lodging_name=?,lodging_loc=?,lodging_phone=?,lodging_image=? where lodging_no=?";  
	         pStatement.setString(1, lodgingadmin.getLodging_name());
	         pStatement.setString(2, lodgingadmin.getLodging_loc());
	         pStatement.setString(3, lodgingadmin.getLodging_phone());
	         pStatement.setInt(4, lodgingadmin.getLodging_price());
	         pStatement.setString(5, lodgingadmin.getLodging_image());
	         pStatement.setInt(6, lodgingadmin.getLodging_no());
	         
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
              lodgingadmin.setLodging_price(resultset.getInt("lodging_price"));
              lodgingadmin.setLodging_image(resultset.getString("lodging_image"));

          }


       } catch (Exception e) {
          e.printStackTrace();
       } finally {
          JDBCUtil.close(resultset, pStatement, connection);
       }
       return lodgingadmin;
    }
	
	@Override
	public List<Lodgingadmin> lodging_name(String lodging_name) {
	      List<Lodgingadmin> lodgingList = new ArrayList<>();
	      
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      ResultSet resultset = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.Lodging_SELECT_BY_LODGING_NAME_ALL);
	         
	         pStatement.setString(1, "%"+lodging_name+"%");
	         
	         resultset = pStatement.executeQuery();            
	         
	         while(resultset.next()) {            
	            Lodgingadmin lodgingadmin = new Lodgingadmin();
	            
	            lodgingadmin.setLodging_no(resultset.getInt("lodging_no"));
	            lodgingadmin.setLodging_name(resultset.getString("lodging_name"));
	            lodgingadmin.setLodging_loc(resultset.getString("lodging_loc"));
	            lodgingadmin.setLodging_phone(resultset.getString("lodging_phone"));
	            lodgingadmin.setLodging_price(resultset.getInt("lodging_price"));
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
	   public int recentlodgingReserve() {
	      int number = 0;
	      
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      ResultSet resultSet = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         
	         pStatement = connection.prepareStatement(Sql.RECENT_LODGING_RESERVE);
	         
	         resultSet = pStatement.executeQuery();
	         
	         if(resultSet.next()) { //다음값으로 이동, null이라면 false
	            
	            number = resultSet.getInt("num");
	            
	         }
	      
	      } catch (Exception e) {
	         e.printStackTrace();
	         
	      } finally {
	         JDBCUtil.close(resultSet, pStatement, connection);
	      }
	      
	      return number;
	   }   
	
	@Override
	public List<Lodginghoroscope> Lodginghoroscope() {
		
		List<Lodginghoroscope> lodginghoroscopeList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.Lodging_REVIEW_HOROSCOPE);
			resultset = pStatement.executeQuery();				
			
			while(resultset.next()) {				
				
				Lodginghoroscope lodginghoroscope = new Lodginghoroscope();
				lodginghoroscope.setLodging_no(resultset.getInt("lodging_no"));
				lodginghoroscope.setLodging_horoscope(resultset.getDouble("lodging_horoscope"));
				
				lodginghoroscopeList.add(lodginghoroscope);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultset, pStatement, connection);
		}
		
		return lodginghoroscopeList;
	}
	
}
