package member;

public class Test {

	public static void main(String[] args) {
	Member member = new Member("gns1127","1234","�ڻ���","food","����","010-7927-7479","tkdgns1127@naver.com");
		
		MemberDao dao = new MemberDaoImpl();
		dao.insert(member);
	}
}
