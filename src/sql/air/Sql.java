package sql.air;

public class Sql {
	
	public static final String AIRLINE_INSERT = 
			"insert into airline values(airlineSeq.nextval, ?, ?, ?, ?, ?)";
	
	public static final String AIRLINE_UPDATE = 
			"update airline set air_name = ?, price = ?, air_loc = ?"
			+", take_off = ?, air_image = ? where air_no = ?";
	
	public static final String AIRLINE_DELETE = 
			"delete from airline where air_no = ?";
	
	public static final String AIRLINE_SELECT_BY_NO = 
			"select * from airline where air_no = ?";
	
	public static final String AIRLINE_SELECT_ALL = 
			"select * from airline";
	
	
	//AIR_RESERVE
	public static final String AIR_RESERVE_INSERT = 
			"insert into air_reserve values(airReserveSeq.nextval, ?, ?, ?, ?)";
	
	public static final String AIR_RESERVE_DELETE = 
			"delete from air_reserve where air_reserve_no = ?";
	
	public static final String AIR_RESERVE_SELECT_BY_RESERVENO = 
			"select * from air_reserve where air_reserve_no = ?";
	
	public static final String RECENT_AIR_RESERVE = 
			"select max(air_reserve_no) as num from air_reserve";
	
	
	//AIR_REVIEW
	public static final String AIR_REVIEW_INSERT = 
			"insert into air_review values(airReviewSeq.nextval, ?, ?, ?, ?)";
	
	public static final String AIR_REVIEW_DELETE = 
			"delete from air_review where air_review_no = ?";
	
	public static final String AIR_REVIEW_UPDATE = 
			"update air_review set content = ?, air_horoscope = ? "
			+"where air_review_no = ?";
	
	public static final String AIR_REVIEW_SELECT_BY_AIRNO = 
			"select * from air_review where air_no = ?";
	
	public static final String AIR_REVIEW_SELECT_BY_AIR_REVIEWNO = 
			"select * from air_review where air_no = ?";
	
	public static final String AVERAGE_HOROSCOPE = 
			"select avg(air_horoscope) as horoscope from air_review " + 
			"where air_no = ? group by air_no";
	
	

	public static final String CHECK_RESERVE_MEMBER = 
			"select air_reserve_no from RESERVATION " + 
			"where member_no = ? and air_reserve_no is not null";
	
	
	public static final String RESERVATION_AIR = 
			"update RESERVATION set air_reserve_no = ? where reserve_no = ?";

}
