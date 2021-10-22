package member;

import java.util.List;

public interface MemberDao {

	public void insert(Member member);
	
	public List<Member> selectAll();
	
	public Member selectById(String id);
	
	public void delete(int no);
	
	public void update(Member member);
	
}
