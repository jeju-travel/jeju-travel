package dao.Lodginguser;

public class Sql {
	public static final String Lodging_SELECT_All=
			"select lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_image from LODGING order by lodging_no asc" ;
	public static final String Lodging_SELECT_BY_LODGING_NO_ALL=
			"select lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_image from lodging where lodging_no=?";
}
