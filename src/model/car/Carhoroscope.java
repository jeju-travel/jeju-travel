package model.car;

public class Carhoroscope {
	private int car_no;
	private double car_horoscope;
	
	public Carhoroscope() {}

	public Carhoroscope(int car_no, double car_horoscope) {
		super();
		this.car_no = car_no;
		this.car_horoscope = car_horoscope;
	}

	public int getCar_no() {
		return car_no;
	}

	public void setCar_no(int car_no) {
		this.car_no = car_no;
	}

	public double getCar_horoscope() {
		//음수 한자릿수 올림
		car_horoscope = Math.ceil(car_horoscope * 10) / 10;
		return car_horoscope; 
	}

	public void setCar_horoscope(double car_horoscope) {
		this.car_horoscope = car_horoscope;
	}

	

	
	
}
