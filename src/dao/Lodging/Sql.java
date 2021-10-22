package dao.Lodging;

public class Sql {
	public static final String Lodging_INSERT_SQL=
			"insert into lodging(lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_image) values(seqlodging_no.nextval,?,?,?,?)";
}
