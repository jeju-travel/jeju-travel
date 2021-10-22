package dao.car;

public class Sql {
	public static final String CAR_INSERT_SQL=
			"insert into car values(seq_car_no.nextval,?,?,?,?,?,?,?)";
	
	public static final String CAR_RESERVE_INSERT_SQL=
			"insert into CAR_RESERVE values(seq_car_reserve_no.nextval,?,?,?,?)";
	
	public static final String CAR_REVIEW_INSERT_SQL=
			"insert into car_review values(seq_car_review_no.nextval,?,?,?)";
	
	public static final String CAR_SELECT_ALL_SQL=
			"select car_no,car_name,car_type,car_price,capacity,car_fuel,car_loc,car_img from car";	
	public static final String CAR_SELECT_BY_NO_SQL=
			"select * from memo where car_no= ?";
	
	
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
