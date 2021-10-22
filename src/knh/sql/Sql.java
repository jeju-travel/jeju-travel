package knh.sql;

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
}
