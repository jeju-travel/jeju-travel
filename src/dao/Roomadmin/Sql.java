package dao.Roomadmin;

public class Sql {
	public static final String Room_INSERT_SQL=
			"insert into room values(seqroom_no.nextval,?,?,?,?,?,?,?)";
	public static final String Room_SELECT_All=
			"select room_no,room_name,room_price,room_personnel,room_configuration,room_service,lodging_no,room_image from Room order by room_no asc";
	
	
	
}
