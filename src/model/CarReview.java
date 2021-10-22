package model;

public class CarReview {
	private int car_review_no;
	private String car_content;
	private int car_horoscope;
	private int car_reserve_no;
	
	public CarReview() {}
	
	public CarReview(int car_review_no, String car_content, int car_horoscope, int car_reserve_no) {
		super();
		this.car_review_no = car_review_no;
		this.car_content = car_content;
		this.car_horoscope = car_horoscope;
		this.car_reserve_no = car_reserve_no;
	}

	public int getCar_review_no() {
		return car_review_no;
	}
	public void setCar_review_no(int car_review_no) {
		this.car_review_no = car_review_no;
	}
	public String getCar_content() {
		return car_content;
	}
	public void setCar_content(String car_content) {
		this.car_content = car_content;
	}
	public int getCar_horoscope() {
		return car_horoscope;
	}
	public void setCar_horoscope(int car_horoscope) {
		this.car_horoscope = car_horoscope;
	}
	public int getCar_reserve_no() {
		return car_reserve_no;
	}
	public void setCar_reserve_no(int car_reserve_no) {
		this.car_reserve_no = car_reserve_no;
	}

	@Override
	public String toString() {
		return "Car_Review [car_review_no=" + car_review_no + ", car_content=" + car_content + ", car_horoscope="
				+ car_horoscope + ", car_reserve_no=" + car_reserve_no + "]";
	}	
	
	
	
}
