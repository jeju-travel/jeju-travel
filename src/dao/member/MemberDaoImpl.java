package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.member.Sql;
import model.manager.Admin;
import model.manager.Member;
import util.JDBCUtil;



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
				member.setHint(resultSet.getString("hint"));
				member.setAnswer(resultSet.getString("answer"));
	
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		
			
		return member;
	}
	
public Member selectByNo(int no) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		Member member = new Member();
	
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMBER_SELECT_BY_NO);

			
			pStatement.setInt(1,no);
		

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				
				
				
				member.setNo(resultSet.getInt("member_no"));
				member.setEmail(resultSet.getString("email"));
				member.setId(resultSet.getString("id"));
				member.setPw(resultSet.getString("pw"));
				member.setName(resultSet.getString("name"));
				member.setPhone(resultSet.getString("phone"));
				member.setHint(resultSet.getString("hint"));
				member.setAnswer(resultSet.getString("answer"));
	
				
				
				
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

			pStatement.setInt(1, no);
			
		
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


	@Override
	public Member login(String id, String pw) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		Member member = new Member();
	
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMBER_LOGIN);

			
			pStatement.setString(1,id);
			pStatement.setString(2,pw);
			

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				
				
				
				member.setNo(resultSet.getInt("member_no"));
				member.setEmail(resultSet.getString("email"));
				member.setId(resultSet.getString("id"));
				member.setPw(resultSet.getString("pw"));
				member.setHint(resultSet.getString("hint"));
				member.setAnswer(resultSet.getString("answer"));
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
	public int selectCntById(String id) {
		
		int cnt = 0;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMBER_SELECT_CNT_BY_ID);

			
			pStatement.setString(1,id);
	
			

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				
				cnt = resultSet.getInt("cnt");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return cnt;
	}


	@Override
	public String FindId(String name, String phone) {
		
		String id = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMBER_FIND_ID);

			
			pStatement.setString(1,name);
			pStatement.setString(2,phone);
	
			

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				
				id = resultSet.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return id;
	}


	@Override
	public String FindPw(String id, String name, String hint, String answer) {
		String pw = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMBER_FIND_PW);

			
			pStatement.setString(1,id);
			pStatement.setString(2,name);
			pStatement.setString(3,hint);
			pStatement.setString(4,answer);
	
			

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				
				pw = resultSet.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return pw;
	}




@Override
public Admin adminLogin(String id, String pw) {
	
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet resultSet = null;
	
	Admin admin = new Admin();
	

	
	try {
		connection = JDBCUtil.getConnection();
		pStatement = connection.prepareStatement(Sql.ADMIN_LOGIN);

		
		pStatement.setString(1,id);
		pStatement.setString(2,pw);
		

		resultSet = pStatement.executeQuery();

		if (resultSet.next()) {
			
	
			admin.setId(resultSet.getString("admin_id"));
			admin.setName(resultSet.getString("admin_name"));
			admin.setNo(resultSet.getInt("admin_no"));
			admin.setPw(resultSet.getString("admin_pw"));
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCUtil.close(resultSet, pStatement, connection);
	}

	
		
	return admin;

}

}
