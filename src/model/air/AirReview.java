package model.air;

public class AirReview {

	private int airReviewNo;
	private String airContent;
	private double airHoroscope;
	private int airReserveNo;
	
	public AirReview() {
		super();
	}
	
	public int getAirReviewNo() {
		return airReviewNo;
	}
	public void setAirReviewNo(int airReviewNo) {
		this.airReviewNo = airReviewNo;
	}
	public String getAirContent() {
		return airContent;
	}
	public void setAirContent(String airContent) {
		this.airContent = airContent;
	}
	public double getAirHoroscope() {
		return airHoroscope;
	}
	public void setAirHoroscope(double airHoroscope) {
		this.airHoroscope = airHoroscope;
	}
	public int getAirReserveNo() {
		return airReserveNo;
	}
	public void setAirReserveNo(int airReserveNo) {
		this.airReserveNo = airReserveNo;
	}

	@Override
	public String toString() {
		return "AirReview [airReviewNo=" + airReviewNo + ", airContent=" + airContent + ", airHoroscope=" + airHoroscope
				+ ", airReserveNo=" + airReserveNo + "]";
	}
}
