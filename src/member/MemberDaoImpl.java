package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import member.Sql;



public class MemberDaoImpl implements MemberDao {

	@Override
	public void insert(Member member) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMBER_INSERT);

			

			
			
			
			pStatement.setString(1,member.getId());
			pStatement.setString(2,member.getPw());
			pStatement.setString(3,member.getName());
			pStatement.setString(4,member.getHint());
			pStatement.setString(5,member.getAnswer());
			pStatement.setString(6,member.getPhone());
			pStatement.setString(7,member.getEmail());
			
			pStatement.execute();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	
	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectById(String id) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		Member member = new Member();
	
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMBER_SELECT_BY_ID);

			
			pStatement.setString(1,id);
		

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				
				
				
				member.setNo(resultSet.getInt("member_no"));
				member.setEmail(resultSet.getString("email"));
				member.setId(resultSet.getString("id"));
				member.setPw(resultSet.getString("pw"));
				member.setName(resultSet.getString("name"));
				member.setPhone(resultSet.getString("phone"));
	
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		
			
		return member;
	}
	

	@Override
	public void delete(int no) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMBER_DELETE);

			pStatement.setLong(1, no);
			
		
			pStatement.execute();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void update(Member member) {

		Connection connection = null;
		PreparedStatement pStatement = null;

		try {

			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMBER_UPDATE);
			
		

			
			pStatement.setString(1, member.getPw());
			pStatement.setString(2, member.getName());
			pStatement.setString(3,member.getHint());
			pStatement.setString(4, member.getAnswer());

			pStatement.setString(5, member.getPhone());
			pStatement.setString(6, member.getEmail());
			pStatement.setLong(7, member.getNo());
			
		
			pStatement.execute();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

}
