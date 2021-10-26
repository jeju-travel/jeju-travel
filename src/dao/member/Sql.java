package dao.member;

public class Sql {

	
	public static final String MEMBER_INSERT = "insert into member values (mem_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

	public static final String MEMBER_SELECT_CNT_BY_ID = "select count(*) as cnt from member where id = ?";
	
	public static final String MEMBER_LOGIN = "select * from MEMBER where id = ? and pw = ?";

	public static final String ADMIN_LOGIN = "select * from RESERVE_ADMIN where admin_id = ? and admin_pw = ?";

	public static final String MEMBER_SELECT_BY_ID = "select * from MEMBER where id = ?";
	
	public static final String MEMBER_SELECT_BY_NO = "select * from MEMBER where member_no = ?";

	public static final String MEMBER_UPDATE = "update member set pw = ?, name = ?, hint = ?, answer = ?, phone = ?, email = ? where member_no = ?";

	public static final String MEMBER_DELETE = "delete from member where member_no = ?";
	
	public static final String MEMBER_FIND_ID = "select id from member where name =? and phone=?";

	public static final String MEMBER_FIND_PW = "select pw from member where id = ? and name =? and hint =? and answer = ?";
}
