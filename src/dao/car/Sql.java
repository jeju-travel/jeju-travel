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
			"update car set car_name = ?,car_type =?,car_price=? ,capacity = ?,car_fuel=?,car_loc=?,car_img=? where car_no=?";
	
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
			"insert into CAR_RESERVE values(seq_car_reserve_no.nextval,?,?,?)";
	//·»Æ®Ä« ¸®ºä
	public static final String CAR_REVIEW_INSERT_SQL=
			"insert into car_review values(seq_car_review_no.nextval,?,?,?,?)";	
	
	public static final String CAR_REVIEW_HOROSCOPE =
			"select car.car_no,avg(car_horoscope) as car_horoscope\r\n" + 
			"from car car, car_review car_review\r\n" + 
			"where car.car_no = car_review.car_no\r\n" + 
			"group by car.car_no";
			
	/*public static final String CUSTOMER_CNT_SQL=
			"select count(*) as cnt from Login where id=?";	
	public static final String CUSTOMER_LOGIN_SQL=
			"select * from Login where id = ? and password = ?";
	public static final String CUSTOMER_SELECT_BY_ID_SQL=
			"select customerseq,id,name,password,postcode,address,address2,phone,email "
			+ "from Login where customerseq= ?";	
	public static final String CUSTOMER_UPDATE_SQL=
			"update Login set id=? ,name =? ,password =?,postcode=?,address=?,address2=?,phone=?,email=? "
			+ "where customerseq=?";	
*/
	
}
