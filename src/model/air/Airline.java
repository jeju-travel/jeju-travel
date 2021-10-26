package model.air;

public class Airline {

	private int airNo;
	private String airName;
	private int price;
	private String airLoc;
	private String takeOff;
	private String airImage;
	
	public Airline() {
		super();
	}
	
	
	public Airline(String airName, int price, String airLoc, String takeOff) {
		super();
		this.airName = airName;
		this.price = price;
		this.airLoc = airLoc;
		this.takeOff = takeOff;
	}


	public int getAirNo() {
		return airNo;
	}
	public void setAirNo(int airNo) {
		this.airNo = airNo;
	}
	public String getAirName() {
		return airName;
	}
	public void setAirName(String airName) {
		this.airName = airName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAirLoc() {
		return airLoc;
	}
	public void setAirLoc(String airLoc) {
		this.airLoc = airLoc;
	}
	public String getTakeOff() {
		return takeOff;
	}
	public void setTakeOff(String takeOff) {
		this.takeOff = takeOff;
	}
	public String getAirImage() {
		return airImage;
	}
	public void setAirImage(String airImage) {
		this.airImage = airImage;
	}

	@Override
	public String toString() {
		return "Airline [airNo=" + airNo + ", airName=" + airName + ", price=" + price + ", airLoc=" + airLoc
				+ ", takeOff=" + takeOff + ", airImage=" + airImage + "]";
	}
	
	
}
