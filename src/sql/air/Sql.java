package sql.air;

public class Sql {
	
	public static final String AIRLINE_INSERT = 
			"insert into airline values(airlineSeq.nextval, ?, ?, ?, ?, null)";
	
	public static final String AIRLINE_UPDATE = 
			"update airline set air_name = ?, price = ?, air_loc = ?"
			+", take_off = ?, air_image = null where air_no = ?";
	
	public static final String AIRLINE_DELETE = 
			"delete from airline where air_no = ?";
	
	public static final String AIRLINE_SELECT_BY_NO = 
			"select * from airline where air_no = ?";
	
	public static final String AIRLINE_SELECT_ALL = 
			"select * from airline";
	
	
	
	//AIR_RESERVE
	public static final String AIR_RESERVE_INSERT = 
			"insert into air_reserve values(airReserveSeq.nextval, ?, ?, ?, ?, ?)";
	
	public static final String AIR_RESERVE_DELETE = 
			"delete from air_reserve where air_reserve_no = ?";
	
	
	//AIR_REVIEW
	public static final String AIR_REVIEW_INSERT = 
			"insert into air_review values(airReviewSeq.nextval, ?, ?, ?)";
	
	public static final String AIR_REVIEW_DELETE = 
			"delete from air_review where air_review_no = ?";
	
	
	public static final String CHECK_RESERVE_AIR = 
			"select m.member_no as member_no, air_no, state " 
			+"from member m, reservation r, air_reserve ar "
			+"where m.member_no = r.member_no AND r.reserve_no = ar.reserve_no "
			+"AND m.member_no = ?";


}
