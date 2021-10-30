package model.car;

public class CarReserve {
	private int car_reserve_no;
	private String borrow_car;
	private String return_car;
	private int rental_day;
	private int car_no;
	
	
	public CarReserve() {}


	public CarReserve(int car_reserve_no, String borrow_car, String return_car, int car_no) {
		super();
		this.car_reserve_no = car_reserve_no;
		this.borrow_car = borrow_car;
		this.return_car = return_car;
		this.car_no = car_no;
	}

	public CarReserve(String borrow_car, String return_car, int rental_day, int car_no) {
		super();
		this.borrow_car = borrow_car;
		this.return_car = return_car;
		this.rental_day = rental_day;
		this.car_no = car_no;
	}


	public int getCar_reserve_no() {
		return car_reserve_no;
	}


	public void setCar_reserve_no(int car_reserve_no) {
		this.car_reserve_no = car_reserve_no;
	}


	public String getBorrow_car() {
		return borrow_car;
	}


	public void setBorrow_car(String borrow_car) {
		this.borrow_car = borrow_car;
	}


	public String getReturn_car() {
		return return_car;
	}


	public void setReturn_car(String return_car) {
		this.return_car = return_car;
	}


	public int getCar_no() {
		return car_no;
	}


	public void setCar_no(int car_no) {
		this.car_no = car_no;
	}

	public int getrental_day() {
		return rental_day;
	}


	public void setrental_day(int rental_day) {
		this.rental_day = rental_day;
	}

}
