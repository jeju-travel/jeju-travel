package dao.car;

public class Sql {
	//°ü¸®ÀÚ ¸ðµå ·»Æ®Ä« DML sql
	public static final String CAR_INSERT_SQL=
			"insert into car values(seq_car_no.nextval,?,?,?,?,?,?,?)";	
	
	public static final String CAR_SELECT_ALL_SQL=
			"select * from car order by car_no";
	
	public static final String CAR_SELECT_BY_NO_SQL=
			"select * from car where car_no= ?";
	
	public static final String CAR_UPDATE_SQL=
			"update car set car_name = ?,car_type =?,car_price=? ,capacity = ?,car_fuel=?,car_loc=?,car_image=? where car_no=?";
	
	public static final String CAR_DELETE_SQL=	
			"delete from car where car_no = ?";
	
	public static final String CAR_SELECT_ALL_PRICE_SQL=
			"select * from car order by car_price";
	
	public static final String CAR_SELECT_TYPE_SQL=	
			"select * from car where car_type = ? order by car_price";
	
	public static final String CAR_SELECT_FUEL_SQL=	
			"select * from car where  car_fuel= ? order by car_price";
	
	public static final String CAR_SELECT_TYPE_FUEL_SQL=	
			"select * from car where car_type = ? and car_fuel= ? order by car_price";
	
	public static final String CAR_SELECT_PRICE_COUNT_SQL=
			"select to_date(?,'yyyy-mm-dd')-to_date(?,'yyyy-mm-dd') as cha from dual";
	
	//·»Æ®Ä« ¿¹¾à
	public static final String CAR_RESERVE_INSERT_SQL=
			"insert into CAR_RESERVE values(seq_car_reserve_no.nextval,?,?,?,?)";
	
	public static final String RECENT_CAR_RESERVE =		
			"select max(car_reserve_no) as num from CAR_RESERVE";
	
	public static final String RESERVATION_CAR_UPDATE_RESERVE =		
			"update RESERVATION set car_reserve_no = ? where reserve_no = ?";
	//·»Æ®Ä« ¸®ºä
	public static final String CAR_REVIEW_INSERT_SQL=
			"insert into car_review values(seq_car_review_no.nextval,?,?,?,?)";	
	
	public static final String CAR_REVIEW_HOROSCOPE =
			"select car.car_no,avg(car_horoscope) as car_horoscope\r\n" + 
			"from car car, car_review car_review\r\n" + 
			"where car.car_no = car_review.car_no\r\n" + 
			"group by car.car_no";
	
	
	
}
