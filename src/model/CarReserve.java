package model;

public class CarReserve {
	private int car_reserve_no;
	private String borrow_car;
	private String return_car;
	private int reserve_no;
	private int car_no;
	
	
	public CarReserve() {}	
	
	public CarReserve(int car_reserve_no, String borrow_car, String return_car, int reserve_no, int car_no) {
		super();
		this.car_reserve_no = car_reserve_no;
		this.borrow_car = borrow_car;
		this.return_car = return_car;
		this.reserve_no = reserve_no;
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
	public int getReserve_no() {
		return reserve_no;
	}
	public void setReserve_no(int reserve_no) {
		this.reserve_no = reserve_no;
	}
	public int getCar_no() {
		return car_no;
	}
	public void setCar_no(int car_no) {
		this.car_no = car_no;
	}

	@Override
	public String toString() {
		return "Car_Reserve [car_reserve_no=" + car_reserve_no + ", borrow_car=" + borrow_car + ", return_car="
				+ return_car + ", reserve_no=" + reserve_no + ", car_no=" + car_no + "]";
	}
	
	
}
