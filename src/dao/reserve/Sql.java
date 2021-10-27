package dao.reserve;

public class Sql {

	public static final String RES_SELECT_BY_MEM_NO = 
			"select reserve_no, member_no, TO_CHAR(start_day, 'YY.MM.DD') AS start_day,"
					+ " TO_CHAR(end_day, 'YY.MM.DD') AS end_day, total_price, total_state,  air_reserve_no, room_reserve_no, car_reserve_no from RESERVATION where member_no = ?" + 
					"";

	public static final String RES_SELECT_ITEM_NO_BY_RES_NO = 
			"select a.air_no, c.car_no, room.room_no from reservation r \r\n" + 
			"inner join AIR_RESERVE a on\r\n" + 
			"r.reserve_no = a.reserve_no\r\n" + 
			"inner join CAR_RESERVE c on\r\n" + 
			"r.reserve_no = c.reserve_no \r\n" + 
			"inner join ROOM_RESERVE room on \r\n" + 
			"r.reserve_no = room.reserve_no\r\n" + 
			"where r.reserve_no = ?";
	
	public static final String RES_SELECT_BY_NO = 
			"select reserve_no, member_no, TO_CHAR(start_day, 'YY.MM.DD') AS start_day,"
					+ " TO_CHAR(end_day, 'YY.MM.DD') AS end_day, total_price, total_state,  air_reserve_no, room_reserve_no, car_reserve_no from RESERVATION where reserve_no = ?" + 
					"";

	public static final String SELECT_AIR_BY_RESNO = "select * from air_reserve ar inner join airline a on a.air_no = ar.air_no where air_reserve_no = ?";
	public static final String SELECT_CAR_BY_RESNO = "select * from car_reserve ar inner join car a on a.car_no = ar.car_no where car_reserve_no = ?";
	public static final String SELECT_ROOM_BY_RESNO = "select * from lodging_reserve ar inner join lodging a on a.lodging_no = ar.lodging_no where room_reserve_no = ?";
	
	
	public static final String RES_SELECT_AIRNAME_BY_RESNO = "select air_name from air_reserve ar inner join airline a on a.air_no = ar.air_no where air_reserve_no = ?";
	public static final String RES_SELECT_CARNAME_BY_RESNO = "select car_name from car_reserve ar inner join car a on a.car_no = ar.car_no where car_reserve_no = ?";
	public static final String RES_SELECT_ROOMNAME_BY_RESNO = "select lodging_name from lodging_reserve ar inner join lodging a on a.lodging_no = ar.lodging_no where room_reserve_no = ?";
	
	public static final String SELECT_AIR_RES_BY_RESNO = "select * from air_reserve where air_reserve_no = ?";
	
	public static final String SELECT_CAR_RES_BY_RESNO = "select * from car_reserve where car_reserve_no = ?";
	
	public static final String SELECT_ROOM_RES_BY_RESNO = "select * from lodging_reserve where room_reserve_no = ?";
}
