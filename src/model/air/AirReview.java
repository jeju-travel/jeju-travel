package model.air;

public class AirReview {

	private int airReviewNo;
	private String writer;
	private String airContent;
	private double airHoroscope;
	private int airNo;
	
	public AirReview() {
		super();
	}
	
	public int getAirReviewNo() {
		return airReviewNo;
	}
	public void setAirReviewNo(int airReviewNo) {
		this.airReviewNo = airReviewNo;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
	public int getAirNo() {
		return airNo;
	}
	public void setAirNo(int airNo) {
		this.airNo = airNo;
	}

	@Override
	public String toString() {
		return "AirReview [airReviewNo=" + airReviewNo + ", writer=" + writer + ", airContent=" + airContent
				+ ", airHoroscope=" + airHoroscope + ", airNo=" + airNo + "]";
	}

}
