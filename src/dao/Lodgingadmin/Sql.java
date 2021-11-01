package dao.Lodgingadmin;

public class Sql {
	public static final String Lodging_INSERT_SQL=
			"insert into LODGING values(seqlodging_no.nextval,?,?,?,?,?)";
	public static final String LODGING_RESERVE_INSERT_SQL=
			"insert into LODGING_RESERVE values(seqlodging_res_no.nextval,?,?,?)";
	public static final String Lodging_SELECT_All=
			"select lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_price,lodging_image from LODGING order by lodging_no asc" ;
	public static final String Lodging_UPDATE_All=
			"update lodging set lodging_name=?,lodging_loc=?,lodging_phone=?,lodging_price=?,lodging_image=? where lodging_no=?";
	public static final String Lodging_DELETE_All=
			"delete from lodging where lodging_no=?";
	public static final String Lodging_SELECT_BY_LODGING_NO_ALL=
			"select lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_price,lodging_image from lodging where lodging_no=?";
	public static final String Lodging_SELECT_BY_LODGING_NAME_ALL=
			"select * from lodging where lodging_name Like ?";
	public static final String RECENT_LODGING_RESERVE= 
			"select max(room_reserve_no) as num from LODGING_RESERVE";
	public static final String Lodging_REVIEW_HOROSCOPE =
			"select lodging.lodging_no,avg(lodging_horoscope) as lodging_horoscope\r\n" + 
			"from lodging lodging, lodging_review lodging_review\r\n" + 
			"where lodging.lodging_no = lodging_review.lodging_no\r\n" + 
			"group by lodging.lodging_no";
}
