package dao.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;


import model.Lodging.Lodging_review;
import util.JDBCUtil;

public class ReviewDaoImple implements ReivewDao{

	@Override
	public void insertLoadingReview(Lodging_review lodging_review) {

		Connection connection =null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.INSERT_LODGING_REVIEW);					
			
			pStatement.setString(1, lodging_review.getWriter());
			pStatement.setString(2, lodging_review.getLodging_content());			
			pStatement.setDouble(3, lodging_review.getLodging_horoscope());			
			pStatement.setInt(4, lodging_review.getlodging_no());
			
			pStatement.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}



}
