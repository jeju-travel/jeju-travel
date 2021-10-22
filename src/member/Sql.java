package member;

public class Sql {

	
	public static final String MEMBER_INSERT = "insert into member values (mem_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

	public static final String MEMBER_SELECT_CNT_BY_ID = "select count(*) as cnt from member where id = ?";
	
	public static final String MEMBER_LOGIN = "select * from MEMBER where id = ? and password = ?";

	public static final String MEMBER_SELECT_BY_ID = "select * from MEMBER where id = ?";

	public static final String MEMBER_UPDATE = "update member set password = ?, name = ?, hint = ?, answer = ?, phone = ?, email = ? where member_no = ?";

	public static final String MEMBER_DELETE = "delete from member where member_no = ?";
	
}
