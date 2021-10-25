package reserve;

public class Reservation {
	
	int resNo;
	int memNo;
	String startDay;
	String endDay;
	String state;
	
	
	
	public Reservation(int resNo, int memNo, String startDay, String endDay, String state) {
		super();
		this.resNo = resNo;
		this.memNo = memNo;
		this.startDay = startDay;
		this.endDay = endDay;
		this.state = state;
	}
	
	public Reservation( int memNo, String startDay, String endDay, String state) {
		super();
		
		this.memNo = memNo;
		this.startDay = startDay;
		this.endDay = endDay;
		this.state = state;
	}
	
	public int getResNo() {
		return resNo;
	}
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
