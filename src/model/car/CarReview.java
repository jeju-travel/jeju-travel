package model.car;

public class CarReview {
	private int car_review_no;
	private String writer; 
	private String car_content;
	private double car_horoscope;
	private int car_no;
	
	public CarReview() {}

	public CarReview(int car_review_no, String writer, String car_content, double car_horoscope, int car_no) {
		super();
		this.car_review_no = car_review_no;
		this.writer = writer;
		this.car_content = car_content;
		this.car_horoscope = car_horoscope;
		this.car_no = car_no;
	}

	public int getCar_review_no() {
		return car_review_no;
	}

	public void setCar_review_no(int car_review_no) {
		this.car_review_no = car_review_no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCar_content() {
		return car_content;
	}

	public void setCar_content(String car_content) {
		this.car_content = car_content;
	}

	public double getCar_horoscope() {
		return car_horoscope;
	}

	public void setCar_horoscope(double car_horoscope) {
		this.car_horoscope = car_horoscope;
	}

	public int getCar_no() {
		return car_no;
	}

	public void setCar_no(int car_no) {
		this.car_no = car_no;
	}

	@Override
	public String toString() {
		return "CarReview [car_review_no=" + car_review_no + ", writer=" + writer + ", car_content=" + car_content
				+ ", car_horoscope=" + car_horoscope + ", car_no=" + car_no + "]";
	}	
	
	
}
