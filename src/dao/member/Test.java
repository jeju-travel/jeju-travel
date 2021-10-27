package dao.member;

import model.manager.Member;

public class Test {

	public static void main(String[] args) {
	Member member = new Member("gns1127","1234","¹Ú»óÈÆ","food","Á·¹ß","010-7927-7479","tkdgns1127@naver.com");
		
		MemberDao dao = new MemberDaoImpl();
		dao.insert(member);
	}
}
