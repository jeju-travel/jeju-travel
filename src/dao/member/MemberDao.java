package dao.member;



import java.util.List;

import model.manager.Admin;
import model.manager.Member;

public interface MemberDao {

	public void insert(Member member);
	
	public List<Member> selectAll();
	
	public Member selectById(String id);
	
	public Member selectByNo(int no);

	public void delete(int no);
	
	public void update(Member member);
	
	public Member login(String id, String pw);

	public Admin adminLogin(String id, String pw);
	
	public int selectCntById(String id);
	
	public String FindId(String name, String phone);
	
	public String FindPw(String id, String name, String hint, String answer);
	
	
}
