package model.Lodging;

public class Lodginghoroscope {
	
	private int lodging_no;
	private double lodging_horoscope;
	//private String content;
	
	public Lodginghoroscope() {}
	
	public Lodginghoroscope(int lodging_no, double lodging_horoscope) {
		super();
		this.lodging_no = lodging_no;
		this.lodging_horoscope = lodging_horoscope;
	}

	public Lodginghoroscope(double lodging_horoscope) {
		super();
		this.lodging_horoscope = lodging_horoscope;
	}

	@Override
	public String toString() {
		return "Lodginghoroscope [lodging_no=" + lodging_no + ", lodging_horoscope=" + lodging_horoscope + "]";
	}
	
	public int getLodging_no() {
		return lodging_no;
	}
	public void setLodging_no(int lodging_no) {
		this.lodging_no = lodging_no;
	}
	public double getLodging_horoscope() {
		
		lodging_horoscope = Math.ceil(lodging_horoscope * 10) / 10;
		return lodging_horoscope;
	}
	public void setLodging_horoscope(double lodging_horoscope) {
		this.lodging_horoscope = lodging_horoscope;
	}
	
	
}
