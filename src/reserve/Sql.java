package reserve;

public class Sql {

	public static final String RES_SELECT_BY_MEM_NO = 
			"select reserve_no, member_no, TO_CHAR(start_day, 'YY.MM.DD') AS start_day, "
			+ "TO_CHAR(end_day, 'YY.MM.DD') AS end_day, state  from reservation where member_no = ?";

	public static final String RES_SELECT_ITEM_NO_BY_RES_NO = 
			"select a.air_no, c.car_no, room.room_no from reservation r \r\n" + 
			"inner join AIR_RESERVE a on\r\n" + 
			"r.reserve_no = a.reserve_no\r\n" + 
			"inner join CAR_RESERVE c on\r\n" + 
			"r.reserve_no = c.reserve_no \r\n" + 
			"inner join ROOM_RESERVE room on \r\n" + 
			"r.reserve_no = room.room_reserve_no\r\n" + 
			"where r.reserve_no = ?";
	
	public static final String RES_SELECT_BY_NO = 
			"select reserve_no, member_no, TO_CHAR(start_day, 'YY.MM.DD') AS start_day, "
			+ "TO_CHAR(end_day, 'YY.MM.DD') AS end_day, state from RESERVATION where reserve_no = ?";
}
